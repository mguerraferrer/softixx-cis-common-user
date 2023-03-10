package mx.softixx.cis.common.user.persistence.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import mx.softixx.cis.common.jpa.model.BaseEntity;

@Entity
@Table(name = "users", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.user_seq_id", allocationSize = 1)
public class User extends BaseEntity {
	
	@Column(name = "email", length = 250, nullable = false)
	private String email;
	
	@Column(name = "first_name", length = 45, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 45, nullable = false)
	private String lastName;
	
	@Column(name = "photo", length = 64)
	private String photo;
	
	@Column(name = "password", length = 128, nullable = false)
	private String password;
	
	@Column(name = "hash", length = 128, nullable = false)
	private String hash;
	
	@Column(name = "creation_date", nullable = false)
	private LocalDateTime creationDate;
	
	@Column(name = "activation_date")
	private LocalDateTime activationDate;
	
	@Column(name = "last_access")
	private LocalDateTime lastAccess;
	
	@Column(name = "first_visit")
	private boolean firstVisit;
	
	@Column(name = "initial_config_completed")
	private boolean initialConfigCompleted;
	
	@Column(name = "force_passwd_change")
	private boolean forcePasswdChange;
	
	@Column(name = "activation_code", length = 128, nullable = false)
	private String activationCode;
	
	@Column(name = "activation_code_duedate", nullable = false)
	private LocalDateTime activationCodeDuedate;
	
	@Column(name = "change_passwd_code", length = 128)
	private String changePasswdCode;
	
	@Column(name = "change_passwd_code_duedate")
	private LocalDateTime changePasswdCodeDuedate;
	
	@Column(name = "failed_attempts")
	private Integer failedAttempts;
	
	@Column(name = "blocked_access")
	private boolean blockedAccess;
	
	@Column(name = "active")
	private boolean active;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		schema = "security",
		name = "users_roles",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private List<Role> roles;
	
	/* Getters and Setters */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(LocalDateTime activationDate) {
		this.activationDate = activationDate;
	}

	public LocalDateTime getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(LocalDateTime lastAccess) {
		this.lastAccess = lastAccess;
	}

	public boolean isFirstVisit() {
		return firstVisit;
	}

	public void setFirstVisit(boolean firstVisit) {
		this.firstVisit = firstVisit;
	}

	public boolean isInitialConfigCompleted() {
		return initialConfigCompleted;
	}

	public void setInitialConfigCompleted(boolean initialConfigCompleted) {
		this.initialConfigCompleted = initialConfigCompleted;
	}

	public boolean isForcePasswdChange() {
		return forcePasswdChange;
	}

	public void setForcePasswdChange(boolean forcePasswdChange) {
		this.forcePasswdChange = forcePasswdChange;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public LocalDateTime getActivationCodeDuedate() {
		return activationCodeDuedate;
	}

	public void setActivationCodeDuedate(LocalDateTime activationCodeDuedate) {
		this.activationCodeDuedate = activationCodeDuedate;
	}

	public String getChangePasswdCode() {
		return changePasswdCode;
	}

	public void setChangePasswdCode(String changePasswdCode) {
		this.changePasswdCode = changePasswdCode;
	}

	public LocalDateTime getChangePasswdCodeDuedate() {
		return changePasswdCodeDuedate;
	}

	public void setChangePasswdCodeDuedate(LocalDateTime changePasswdCodeDuedate) {
		this.changePasswdCodeDuedate = changePasswdCodeDuedate;
	}

	public Integer getFailedAttempts() {
		return failedAttempts;
	}

	public void setFailedAttempts(Integer failedAttempts) {
		this.failedAttempts = failedAttempts;
	}

	public boolean isBlockedAccess() {
		return blockedAccess;
	}

	public void setBlockedAccess(boolean blockedAccess) {
		this.blockedAccess = blockedAccess;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Role> getRoles() {
		if (roles == null) {
			roles = new ArrayList<>();
		}
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role) {
		if (this.roles == null) {
			this.roles = new ArrayList<>();
		}
		this.roles.add(role);
	}

	@Transient
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	@Transient
	public boolean hasRole(String roleCode) {
		return roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase(roleCode));
	}
	
}