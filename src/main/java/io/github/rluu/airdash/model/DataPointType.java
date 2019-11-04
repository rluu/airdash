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
@Table(name="data_point_type")
public class DataPointType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="data_point_type_seq")
    @SequenceGenerator(name="data_point_type_seq", sequenceName="data_point_type_seq")
    @Column(name="data_point_type_id")
    private Long id;

    @Column(name="name")
	private String name;

    @Column(name="display_name")
	private String displayName;

    @Column(name="abbreviation")
	private String abbreviation;

	@Column(name="description")
	private String description;

    @Column(name="create_dttm")
    private ZonedDateTime createDttm;

    @Column(name="update_dttm")
    private ZonedDateTime updateDttm;

    @Column(name="delete_dttm")
    private ZonedDateTime deleteDttm;

    @Column(name="delete_ind")
    private Boolean deleteInd;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Boolean getDeleteInd() {
        return deleteInd;
    }

    public void setDeleteInd(Boolean deleteInd) {
        this.deleteInd = deleteInd;
    }
}
