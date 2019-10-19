package io.github.rluu.airdash.model;

import java.time.ZonedDateTime;
import java.util.Collection;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "users_seq")
    @Column(name="user_id")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="email_address_verified_ind")
    private boolean emailAddressVerifiedInd;

    @Column(name="create_dttm")
    private ZonedDateTime createDttm;

    @Column(name="update_dttm")
    private ZonedDateTime updateDttm;

    @Column(name="delete_dttm")
    private ZonedDateTime deleteDttm;

    @Column(name="delete_ind")
    private boolean deleteInd;

	@Column(name="account_expired_ind")
	private boolean accountExpiredInd;

	@Column(name="account_locked_ind")
	private boolean accountLockedInd;

	@Column(name="credentials_expired_ind")
	private boolean credentialsExpiredInd;
	
	@Column(name="enabled_ind")
	private boolean enabledInd;
	
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isEmailAddressVerifiedInd() {
        return emailAddressVerifiedInd;
    }

    public void setEmailAddressVerifiedInd(boolean emailAddressVerifiedInd) {
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

    public boolean isDeleteInd() {
        return deleteInd;
    }

    public void setDeleteInd(boolean deleteInd) {
        this.deleteInd = deleteInd;
    }

    public boolean isAccountExpiredInd() {
        return accountExpiredInd;
    }

    public void setAccountExpiredInd(boolean accountExpiredInd) {
        this.accountExpiredInd = accountExpiredInd;
    }

    public boolean isAccountLockedInd() {
        return accountLockedInd;
    }

    public void setAccountLockedInd(boolean accountLockedInd) {
        this.accountLockedInd = accountLockedInd;
    }

    public boolean isCredentialsExpiredInd() {
        return credentialsExpiredInd;
    }

    public void setCredentialsExpiredInd(boolean credentialsExpiredInd) {
        this.credentialsExpiredInd = credentialsExpiredInd;
    }

    public boolean isEnabledInd() {
        return enabledInd;
    }

    public void setEnabledInd(boolean enabledInd) {
        this.enabledInd = enabledInd;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (accountExpiredInd ? 1231 : 1237);
        result = prime * result + (accountLockedInd ? 1231 : 1237);
        result = prime * result + ((createDttm == null) ? 0 : createDttm.hashCode());
        result = prime * result + (credentialsExpiredInd ? 1231 : 1237);
        result = prime * result + ((deleteDttm == null) ? 0 : deleteDttm.hashCode());
        result = prime * result + (deleteInd ? 1231 : 1237);
        result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
        result = prime * result + (emailAddressVerifiedInd ? 1231 : 1237);
        result = prime * result + (enabledInd ? 1231 : 1237);
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((roles == null) ? 0 : roles.hashCode());
        result = prime * result + ((updateDttm == null) ? 0 : updateDttm.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
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
        User other = (User) obj;
        if (accountExpiredInd != other.accountExpiredInd)
            return false;
        if (accountLockedInd != other.accountLockedInd)
            return false;
        if (createDttm == null) {
            if (other.createDttm != null)
                return false;
        } else if (!createDttm.equals(other.createDttm))
            return false;
        if (credentialsExpiredInd != other.credentialsExpiredInd)
            return false;
        if (deleteDttm == null) {
            if (other.deleteDttm != null)
                return false;
        } else if (!deleteDttm.equals(other.deleteDttm))
            return false;
        if (deleteInd != other.deleteInd)
            return false;
        if (emailAddress == null) {
            if (other.emailAddress != null)
                return false;
        } else if (!emailAddress.equals(other.emailAddress))
            return false;
        if (emailAddressVerifiedInd != other.emailAddressVerifiedInd)
            return false;
        if (enabledInd != other.enabledInd)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (middleName == null) {
            if (other.middleName != null)
                return false;
        } else if (!middleName.equals(other.middleName))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (roles == null) {
            if (other.roles != null)
                return false;
        } else if (!roles.equals(other.roles))
            return false;
        if (updateDttm == null) {
            if (other.updateDttm != null)
                return false;
        } else if (!updateDttm.equals(other.updateDttm))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !accountExpiredInd;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLockedInd;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsExpiredInd;
    }

    @Override
    public boolean isEnabled() {
        return enabledInd;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
                + ", middleName=" + middleName + ", lastName=" + lastName + ", emailAddress=" + emailAddress
                + ", emailAddressVerifiedInd=" + emailAddressVerifiedInd + ", createDttm=" + createDttm
                + ", updateDttm=" + updateDttm + ", deleteDttm=" + deleteDttm + ", deleteInd=" + deleteInd
                + ", accountExpiredInd=" + accountExpiredInd + ", accountLockedInd=" + accountLockedInd
                + ", credentialsExpiredInd=" + credentialsExpiredInd + ", enabledInd=" + enabledInd + ", roles=" + roles
                + "]";
    }
}
