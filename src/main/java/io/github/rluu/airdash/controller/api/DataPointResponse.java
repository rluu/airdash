package io.github.rluu.airdash.controller.api;

public class DataPointResponse {

    private Boolean success;
    private String details;

    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    @Override
    public String toString() {
        return "DataPointResponse [success=" + success + ", details=" + details + "]";
    }
}
