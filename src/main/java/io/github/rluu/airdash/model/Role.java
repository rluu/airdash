package io.github.rluu.airdash.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="role_seq")
	@SequenceGenerator(name="role_seq", sequenceName="role_seq")
	@Column(name="role_id")
	private Long id;
	
	@Column(name="name")
	private String name;

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
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createDttm == null) ? 0 : createDttm.hashCode());
        result = prime * result + ((deleteDttm == null) ? 0 : deleteDttm.hashCode());
        result = prime * result + ((deleteInd == null) ? 0 : deleteInd.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((updateDttm == null) ? 0 : updateDttm.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Role other = (Role) obj;
        if (createDttm == null) {
            if (other.createDttm != null)
                return false;
        } else if (!createDttm.equals(other.createDttm))
            return false;
        if (deleteDttm == null) {
            if (other.deleteDttm != null)
                return false;
        } else if (!deleteDttm.equals(other.deleteDttm))
            return false;
        if (deleteInd == null) {
            if (other.deleteInd != null)
                return false;
        } else if (!deleteInd.equals(other.deleteInd))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (updateDttm == null) {
            if (other.updateDttm != null)
                return false;
        } else if (!updateDttm.equals(other.updateDttm))
            return false;
        return true;
    }

    @Override
    public String getAuthority() {
        return name;
    }

	@Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + ", description=" + description + ", createDttm=" + createDttm
                + ", updateDttm=" + updateDttm + ", deleteDttm=" + deleteDttm + ", deleteInd=" + deleteInd + "]";
    }
}
