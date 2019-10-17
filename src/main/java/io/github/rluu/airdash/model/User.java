package io.github.rluu.airdash.model;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name="user_seq", sequenceName="users_seq")
	private Long id;
	
	private String username;
	private String passwordHash;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailAddress;
	private ZonedDateTime createDttm;
	private ZonedDateTime updateDttm;
	private ZonedDateTime deleteDttm;
	private Boolean deleteInd;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", createDttm=" + createDttm + ", updateDttm=" + updateDttm + ", deleteDttm=" + deleteDttm
				+ ", deleteInd=" + deleteInd + "]";
	}
}