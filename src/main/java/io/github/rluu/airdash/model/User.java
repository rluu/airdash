package io.github.rluu.airdash.model;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "users_seq")
    @Column(name="user_id")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password_hash")
    private String passwordHash;

    @Column(name="first_name")
    private String firstName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="email_address_verified_ind")
    private Boolean emailAddressVerifiedInd;

    @Column(name="create_dttm")
    private ZonedDateTime createDttm;

    @Column(name="update_dttm")
    private ZonedDateTime updateDttm;

    @Column(name="delete_dttm")
    private ZonedDateTime deleteDttm;

    @Column(name="delete_ind")
    private Boolean deleteInd;

    @ManyToMany
    @JoinTable(name = "users_role", 
               joinColumns = @JoinColumn(name = "user_id"), 
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

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

    public Boolean getEmailAddressVerifiedInd() {
        return emailAddressVerifiedInd;
    }

    public void setEmailAddressVerifiedInd(Boolean emailAddressVerifiedInd) {
        this.emailAddressVerifiedInd = emailAddressVerifiedInd;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", firstName="
                + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", emailAddress=" + emailAddress
                + ", emailAddressVerifiedInd=" + emailAddressVerifiedInd + ", createDttm=" + createDttm
                + ", updateDttm=" + updateDttm + ", deleteDttm=" + deleteDttm + ", deleteInd=" + deleteInd + ", roles="
                + roles + "]";
    }
}
