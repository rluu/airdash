package io.github.rluu.airdash.controller;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.rluu.airdash.controller.api.DataPointCreateRequest;
import io.github.rluu.airdash.controller.api.DataPointResponse;
import io.github.rluu.airdash.model.Chart;
import io.github.rluu.airdash.model.DataPoint;
import io.github.rluu.airdash.model.DataPointType;
import io.github.rluu.airdash.model.Location;
import io.github.rluu.airdash.model.User;
import io.github.rluu.airdash.repository.ChartRepository;
import io.github.rluu.airdash.repository.DataPointRepository;
import io.github.rluu.airdash.repository.DataPointTypeRepository;
import io.github.rluu.airdash.repository.LocationRepository;
import io.github.rluu.airdash.repository.UserRepository;

@RestController
@RequestMapping(path = "/api/v1/dataPoint")
public class DataPointController {
    
    private static final Logger logger = LogManager.getLogger(DataPointController.class);

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DataPointTypeRepository dataPointTypeRepository;

    @Autowired
    private DataPointRepository dataPointRepository;

    @Autowired
    private ChartRepository chartRepository;
    
    @GetMapping("/test")
    public ResponseEntity<DataPointResponse> test() {
        logger.debug("Inside test()");
        ResponseEntity<DataPointResponse> rv = null;
        DataPointResponse response = new DataPointResponse();
        response.setSuccess(true);
        rv = new ResponseEntity<DataPointResponse>(response, HttpStatus.OK);
        return rv;
    }

    @PostMapping(path = "/testPost", consumes = "application/json", produces = "application/json")
//    @RequestMapping(value = "/testPost", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<DataPointResponse> testPost(@RequestBody String request) {
        logger.debug("Inside testPost().  request is: " + request);
        ResponseEntity<DataPointResponse> rv = null;
        DataPointResponse response = new DataPointResponse();
        response.setSuccess(true);
        rv = new ResponseEntity<DataPointResponse>(response, HttpStatus.OK);
        return rv;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DataPointResponse> create(Authentication authentication, @Valid @RequestBody DataPointCreateRequest request) {
        logger.debug("authentication: " + authentication + ", request: " + request);

        ResponseEntity<DataPointResponse> rv = null;
        DataPointResponse response = new DataPointResponse();
        
        if (request != null) {
            if (request.getAcquireDttm() == null) {
                response.setSuccess(false);
                response.setDetails("Missing required field: acquireDttm");
                rv = new ResponseEntity<DataPointResponse>(response, HttpStatus.BAD_REQUEST);
            }
            else if (request.getLocationName() == null) {
                response.setSuccess(false);
                response.setDetails("Missing required field: locationName");
                rv = new ResponseEntity<DataPointResponse>(response, HttpStatus.BAD_REQUEST);
            }
            else if (request.getDataPointTypeName() == null) {
                response.setSuccess(false);
                response.setDetails("Missing required field: dataPointTypeName");
                rv = new ResponseEntity<DataPointResponse>(response, HttpStatus.BAD_REQUEST);
            }
            else if (request.getDataPointValue() == null) {
                response.setSuccess(false);
                response.setDetails("Missing required field: dataPointValue");
                rv = new ResponseEntity<DataPointResponse>(response, HttpStatus.BAD_REQUEST);
            }
            else {
                // Validate the locationName.
                Location location = locationRepository.findByName(request.getLocationName());
                if (location == null) {
                    response.setSuccess(false);
                    response.setDetails("Invalid or unsupported locationName provided: " + request.getLocationName());
                    rv = new ResponseEntity<DataPointResponse>(response, HttpStatus.BAD_REQUEST);
                }
                else {
                    // Validate the data point type name.
                    DataPointType dataPointType = dataPointTypeRepository.findByName(request.getDataPointTypeName());
                    if (dataPointType == null) {
                        List<DataPointType> dataPointTypes = dataPointTypeRepository.findAll();
                        List<String> dataPointTypeNames = new ArrayList<>();
                        for (DataPointType dpt : dataPointTypes) {
                            if (dpt != null && dpt.getName() != null) {
                                dataPointTypeNames.add(dpt.getName());
                            }
                        }
                        response.setSuccess(false);
                        response.setDetails("Invalid or unsupported dataPointTypeName provided: " + 
                                request.getDataPointTypeName() + ".  Valid values are: " + dataPointTypeNames);
                        rv = new ResponseEntity<DataPointResponse>(response, HttpStatus.BAD_REQUEST);
                    }
                    else {
                        // Validate that a chart with the specified location exists for the user.
                        Long locationId = location.getId();
                        String username = authentication.getName();
                        User user = userRepository.findByUsername(username);
                        Long userId = user.getId();
                        List<Chart> charts = chartRepository.findAllByUserIdAndLocationIdOrderByUpdateDttmDesc(userId, locationId);
                        // Remove deleted charts.
                        for (Iterator<Chart> iter = charts.iterator(); iter.hasNext();) {
                            Chart chart = iter.next();
                            if (chart == null || chart.isDeleteInd()) {
                                iter.remove();
                            }
                        }
                        if (charts.isEmpty()) {
                            response.setSuccess(false);
                            response.setDetails("Unable to find a Chart for the provided username and locationName.  " + 
                                    "Username: " + username + ", locationName: " + request.getLocationName());
                            rv = new ResponseEntity<DataPointResponse>(response, HttpStatus.BAD_REQUEST);
                        }
                        else {
                            // All data has been validated.
                            // Get the latest updated chart that is not deleted.
                            Chart chart = charts.get(0);
                            Long chartId = chart.getId();
                            
                            ZonedDateTime now = ZonedDateTime.now();
                            
                            DataPoint dataPoint = new DataPoint();
                            dataPoint.setChartId(chartId);
                            dataPoint.setDataPointTypeId(dataPointType.getId());
                            dataPoint.setValue(request.getDataPointValue());
                            dataPoint.setAcquireDttm(request.getAcquireDttm());
                            dataPoint.setCreateDttm(now);
                            dataPoint.setUpdateDttm(now);
                            dataPoint.setDeleteDttm(null);
                            dataPoint.setDeleteInd(false);
                            
                            logger.debug("Saving dataPoint: " + dataPoint);
                            dataPoint = dataPointRepository.save(dataPoint);
                            logger.debug("Saved dataPoint as ID: " + dataPoint.getId());

                            response.setSuccess(true);
                            response.setDetails(null);
                            rv = new ResponseEntity<DataPointResponse>(response, HttpStatus.CREATED);
                        }
                    }
                }
            }
        }
        else {
            response.setSuccess(false);
            response.setDetails("Invalid request.");
            rv = new ResponseEntity<DataPointResponse>(response, HttpStatus.BAD_REQUEST);
        }

        return rv;
    }
}
