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
#      
#      - If the script is not intended to be started under root, proper permissions for the device should be set. Put the following two lines into a file /etc/udev/rules.d/98-co2mon.rules:
#
#        KERNEL=="hidraw*", ATTRS{idVendor}=="04d9", ATTRS{idProduct}=="a052", GROUP="plugdev", MODE="0666"
#        SUBSYSTEM=="usb", ATTRS{idVendor}=="04d9", ATTRS{idProduct}=="a052", GROUP="plugdev", MODE="0666"
#
#        and run sudo udevadm control --reload-rules && udevadm trigger.
# 
#      - Python dependencies for co2meter:
#        - cd ${AIRDASH_HOME}/src/client/python/
#        - virtualenv venv
#        - source venv/bin/activate
#        - pip install hidapi co2meter
#    
# Setup:
#   
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
#   3) Run the application.
#        - cd ${AIRDASH_HOME}/src/client/python/
#        - python3 ./src/main.py
#
##############################################################################

import os

class AirDashConfig:
    username = None
    password = None
    serverUrl = None

config = AirDashConfig()

key = "AIRDASH_USERNAME"
if os.environ.get(key) is not None:
    config.username = os.environ.get(key)
else:
    pass

key = "AIRDASH_PASSWORD"
if os.environ.get(key) is not None:
    config.password = os.environ.get(key)
else:
    pass

key = "AIRDASH_SERVER_URL"
if os.environ.get(key) is not None:
    config.serverUrl = os.environ.get(key)
else:
    pass

