package io.github.rluu.airdash.controller.api;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class DataPointCreateRequest {

    private String requestUUID;
    
    @NotNull
    private ZonedDateTime acquireDttm;

    @NotNull
    @NotBlank
    private String locationName;

    @NotNull
    @NotBlank
    private String dataPointTypeName;

    @NotNull
    private Double dataPointValue;

    public String getRequestUUID() {
        return requestUUID;
    }

    public String getDataPointTypeName() {
        return dataPointTypeName;
    }

    public void setDataPointTypeName(String dataPointTypeName) {
        this.dataPointTypeName = dataPointTypeName;
    }

    public Double getDataPointValue() {
        return dataPointValue;
    }

    public void setDataPointValue(Double dataPointValue) {
        this.dataPointValue = dataPointValue;
    }

    public void setRequestUUID(String requestUUID) {
        this.requestUUID = requestUUID;
    }

    public ZonedDateTime getAcquireDttm() {
        return acquireDttm;
    }

    public void setAcquireDttm(ZonedDateTime acquireDttm) {
        this.acquireDttm = acquireDttm;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return "DataPointCreateRequest [requestUUID=" + requestUUID + ", acquireDttm=" + acquireDttm + ", locationName="
                + locationName + ", dataPointTypeName=" + dataPointTypeName + ", dataPointValue=" + dataPointValue
                + "]";
    }
}
