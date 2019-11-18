#!/usr/bin/env python3
##############################################################################
#
# Description:
#   This script reads temperature and carbon dixiode levels from a CO2 meter and sends the data to an Airdash application server.  
# 
# Requirements:
#   - Python 3
#   - Install dependencies required for co2meter Python library:
#      - System libraries: 
#        - libusb      (sudo apt-get install libusb-1.0.0-dev)
#        - hidapi      (sudo apt-get install libhidapi-dev)
#        - udev        (sudo apt-get install libudev-dev)
#      
#      - If the script is not intended to be started under root, proper permissions for the device should be set. Put the following two lines into a file /etc/udev/rules.d/98-co2mon.rules:
#
#        KERNEL=="hidraw*", ATTRS{idVendor}=="04d9", ATTRS{idProduct}=="a052", GROUP="plugdev", MODE="0666"
#        SUBSYSTEM=="usb", ATTRS{idVendor}=="04d9", ATTRS{idProduct}=="a052", GROUP="plugdev", MODE="0666"
#
#        and run sudo udevadm control --reload-rules && udevadm trigger.
# 
#      - Python dependencies for co2meter:
#        - cd ${AIRDASH_HOME}
#        - virtualenv venv
#        - source venv/bin/activate
#        - pip install hidapi co2meter
#
#   - Python libraries used by this script:
#      - cd ${AIRDASH_HOME}
#      - source venv/bin/activate
#      - pip install requests
#    
# Setup:
#   1) Plug device into the USB slot of the computer.
# 
# Usage:
#   1) Set environment variables:
#        $ export AIRDASH_USERNAME=<USERNAME>
#        $ export AIRDASH_PASSWORD=<PASSWORD>
#        $ export AIRDASH_SERVER_URL=<URL>
#   
#        For example, the URL could be: https://abc.airdash.myhostname/
#   
#   2) Activate the Python virtualenv.
#        - cd ${AIRDASH_HOME}/src/client/python/
#        - virtualenv venv
#        - source venv/bin/activate
#
#   3) Run the application, specifying the location.
#        - cd ${AIRDASH_HOME}/src/client/python/
#        - python3 ./src/main.py --location=HOME_BEDROOM
#
##############################################################################

# For obtaining current directory path information.
import os

# For handling signal interrupt and clean shutdown.
import sys
import signal

# For sleeping
import time

# For logging.
import logging
import logging.handlers
import logging.config

# For parsing command-line options
from optparse import OptionParser

# For reading CO2 meter USB device.  
# This comes from the co2meter package.
import co2meter

# For making HTTP requests to the AirDash server.
import requests

##############################################################################
# Global Variables
##############################################################################

# Version string.
VERSION = "0.1"

# Location of the source directory, based on this main.py file.
thisScriptDir = os.path.dirname(os.path.abspath(__file__))
SRC_DIR = thisScriptDir

# Directory where log files will be written.
LOG_DIR = \
    os.path.abspath(os.path.join(SRC_DIR,
                                 ".." + os.sep + "logs"))

# Location of the config file for logging.
LOG_CONFIG_FILE = \
    os.path.abspath(os.path.join(SRC_DIR,
                                 ".." + os.sep +
                                 "resources" + os.sep +
                                 "logging.conf"))

# List of valid locations used for reporting the CO2 and temperature
# measurements.
VALID_LOCATIONS = [
        "HOME_BEDROOM",
        "HOME_OFFICE",
        "HOME_LIVING_ROOM",
        "HOME_KITCHEN",
        "WORK_OFFICE",
        "OTHER",
        ]

# Logger.  
# 
# Parsing the log config file doesn't work on the current version
# of cx_Freeze (on Windows and on Mac).  The author of cx_Freeze
# knows about this bug and hopefully the next release of cx_Freeze
# addresses this issue.  Until then, only parse the config file if
# this file is referenced as a .py file.
if sys.argv[0].split(".")[-1] == "py":
    # Logging config file specifies the log filename relative to
    # the current directory, so we need to chdir to the SRC_DIR
    # before loading the logging config.
    os.chdir(SRC_DIR)
    logging.config.fileConfig(LOG_CONFIG_FILE)
log = logging.getLogger("main")

# Application-specific configuration data.
# These are obtained from environment variables and command-line option.
username = None
password = None
serverUrl = None
locationName = None

##############################################################################

def main():
    # Set up the logger.

    log.info("##########################################");
    log.info("# Starting " + sys.argv[0] + ", version " + VERSION);
    log.info("##########################################");

    (options, args) = parseCommandlineArgs()
    parseRequiredEnvironmentVariables()

    # All required str fields are set at this point, but do a quick assertion
    # just in case.
    assert username
    assert password
    assert serverUrl
    assert locationName

    monitor = co2meter.CO2monitor()

    log.info("CO2 monitor information: {}".format(monitor.info))
    # Example output of the monitor info:
    # >>> monitor.info
    # {'product_name': 'USB-zyTemp', 'vendor_id': 1241, 'manufacturer': 'Holtek', 'serial_no': '1.40', 'product_id': 41042}

    while True:
        print("Sleeping for 10 seconds ...")
        time.sleep(10)

        # Example output of the monitor read_data() method:
        # >>> monitor.read_data()
        # (datetime.datetime(2019, 11, 18, 3, 5, 22), 551, 21.975000000000023)
        (dateTime, co2ppm, temperatureCelcius) = mon.read_data()

        log.debug("dateTime: {}, co2ppm: {}, temperatureCelcius: {}".\
                format(dateTime, co2ppm, temperatureCelcius))


def parseCommandlineArgs():
    global log

    # Create the parser
    parser = OptionParser()

    # Specify all valid options.
    parser.add_option("-v", "--version",
                    action="store_true",
                    dest="version",
                    default=False,
                    help="Display script version info and author contact.")
    parser.add_option("--list-locations",
                      action="store_true",
                      dest="listLocations",
                      default=False,
                      help="Display a list of possible locations that can be used to the --location option.")
    parser.add_option("--location",
                      action="store",
                      type="str",
                      dest="locationName",
                      default=None,
                      metavar="<LOCATION_NAME>",
                      help="Sets the location which will be used when reporting CO2 and temperature information to the AirDash server.  For a list of possible values, please see the --list-locations option.  This is a required field.")

    # Parse the arguments into options.
    (options, args) = parser.parse_args()

    # Print version information if the flag was used.
    if options.version == True:
        log.debug("Printing version information.")
        print(os.path.basename(sys.argv[0]) + " (Version " + VERSION + ")")
        print("By Ryan Luu, ryanluu@gmail.com")
        shutdown(0)

    if options.listLocations == True:
        log.debug("Printing list of possible values for location.")
        print("List of possible values for location:")
        for location in VALID_LOCATIONS:
            print("  " + location)
        shutdown(0)

    if not options.locationName:
        print("The location name is required and was not provided by the user.", file=sys.stderr)
        print("For more details, please see the help page by using the --help option.", file=sys.stderr)
        shutdown(1)
    elif options.locationName not in VALID_LOCATIONS:
        print("The location name provided was not valid.", file=sys.stderr)
        print("For a list of valid values, please rerun with the --list-locations option.", file=sys.stderr)
        shutdown(1)
    elif options.locationName in VALID_LOCATIONS:
        global locationName
        locationName = options.locationName

    return (options, args)

def parseRequiredEnvironmentVariables():
    global log

    key = "AIRDASH_USERNAME"
    if os.environ.get(key):
        global username
        username = os.environ.get(key)
    else:
        errMsg = "Required environment variable must be set: {}".format(key)
        log.error(errMsg)
        print(errMsg, file=sys.stderr)
        shutdown(1)

    key = "AIRDASH_PASSWORD"
    if os.environ.get(key):
        global password
        password = os.environ.get(key)
    else:
        errMsg = "Required environment variable must be set: {}".format(key)
        log.error(errMsg)
        print(errMsg, file=sys.stderr)
        shutdown(1)

    key = "AIRDASH_SERVER_URL"
    if os.environ.get(key):
        global serverUrl
        serverUrl = os.environ.get(key)
    else:
        errMsg = "Required environment variable must be set: {}".format(key)
        log.error(errMsg)
        print(errMsg, file=sys.stderr)
        shutdown(1)

def shutdown(rc):
    """Exits the script, but first flushes all logging handles, etc."""

    # Execution completed.
    log.info("Done.")

    logging.shutdown()
    sys.exit(rc)

##############################################################################

if __name__ == "__main__":

    # Program return code.
    exitCode = 0

    try:
        exitCode = main()
    except KeyboardInterrupt:
        infoMsg = "Caught KeyboardInterrupt.  Shutting down..."
        log.info(infoMsg)
        print(infoMsg)
        exitCode = 0

    shutdown(exitCode)

##############################################################################

