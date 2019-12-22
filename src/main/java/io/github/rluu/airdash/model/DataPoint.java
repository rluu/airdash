package io.github.rluu.airdash.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="data_point")
public class DataPoint {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="data_point_seq")
    @SequenceGenerator(name="data_point_seq", sequenceName="data_point_seq")
    @Column(name="data_point_id")
    private Long id;
    
    @Column(name="chart_id")
    private Long chartId;
    
    @Column(name="data_point_type_id")
    private Long dataPointTypeId;

    @Column(name="value")
    private Double value;
    
    @Column(name="acquire_dttm")
    private ZonedDateTime acquireDttm;
    
    @Column(name="create_dttm")
    private ZonedDateTime createDttm;

    @Column(name="update_dttm")
    private ZonedDateTime updateDttm;

    @Column(name="delete_dttm")
    private ZonedDateTime deleteDttm;

    @Column(name="delete_ind")
    private boolean deleteInd;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChartId() {
        return chartId;
    }

    public void setChartId(Long chartId) {
        this.chartId = chartId;
    }

    public Long getDataPointTypeId() {
        return dataPointTypeId;
    }

    public void setDataPointTypeId(Long dataPointTypeId) {
        this.dataPointTypeId = dataPointTypeId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public ZonedDateTime getAcquireDttm() {
        return acquireDttm;
    }

    public void setAcquireDttm(ZonedDateTime acquireDttm) {
        this.acquireDttm = acquireDttm;
    }

    public ZonedDateTime getCreateDttm() {
        return createDttm;
    }

    public void setCreateDttm(ZonedDateTime createDttm) {
        this.createDttm = createDttm;
    }

    public ZonedDateTime getUpdateDttm() {
        return updateDttm;
    }

    public void setUpdateDttm(ZonedDateTime updateDttm) {
        this.updateDttm = updateDttm;
    }

    public ZonedDateTime getDeleteDttm() {
        return deleteDttm;
    }

    public void setDeleteDttm(ZonedDateTime deleteDttm) {
        this.deleteDttm = deleteDttm;
    }

    public boolean isDeleteInd() {
        return deleteInd;
    }

    public void setDeleteInd(boolean deleteInd) {
        this.deleteInd = deleteInd;
    }
}
