package mx.softixx.cis.common.user.converter;

import java.util.List;

import lombok.val;
import mx.softixx.cis.common.data.role.RoleResponse;
import mx.softixx.cis.common.data.user.UserDetailsResponse;
import mx.softixx.cis.common.user.persistence.model.Role;
import mx.softixx.cis.common.user.persistence.model.User;

public final class UserDetailsConverter {

	private UserDetailsConverter() {
	}
	
	public static final UserDetailsResponse map(User user) {
		if (user == null) {
			return null;
		}
		
		val roles = getRoles(user);
		
		return UserDetailsResponse
				.builder()
				.id(user.getId())
				.email(user.getEmail())
				.password(user.getPassword())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.fullName(user.getFullName())
				.photo(user.getPhoto())
				.hash(user.getHash())
				.creationDate(user.getCreationDate())
				.activationDate(user.getActivationDate())
				.lastAccess(user.getLastAccess())
				.firstVisit(user.isFirstVisit())
				.initialConfigCompleted(user.isInitialConfigCompleted())
				.forcePasswdChange(user.isForcePasswdChange())
				.activationCode(user.getActivationCode())
				.activationCodeDuedate(user.getActivationCodeDuedate())
				.changePasswdCode(user.getChangePasswdCode())
				.changePasswdCodeDuedate(user.getChangePasswdCodeDuedate())
				.failedAttempts(user.getFailedAttempts())
				.blockedAccess(user.isBlockedAccess())
				.active(user.isActive())
				.roles(roles)
				.build();
	}
	
	public static final User map(UserDetailsResponse userDetails) {
		if (userDetails == null) {
			return null;
		}
		
		val roles = getRoles(userDetails);
		
		val user = new User();
		user.setId(userDetails.getId());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setPhoto(userDetails.getPhoto());
		user.setHash(userDetails.getHash());
		user.setCreationDate(userDetails.getCreationDate());
		user.setActivationDate(userDetails.getActivationDate());
		user.setLastAccess(userDetails.getLastAccess());
		user.setFirstVisit(userDetails.isFirstVisit());
		user.setInitialConfigCompleted(userDetails.isInitialConfigCompleted());
		user.setForcePasswdChange(userDetails.isForcePasswdChange());
		user.setActivationCode(userDetails.getActivationCode());
		user.setActivationCodeDuedate(userDetails.getActivationCodeDuedate());
		user.setChangePasswdCode(userDetails.getChangePasswdCode());
		user.setChangePasswdCodeDuedate(userDetails.getChangePasswdCodeDuedate());
		user.setFailedAttempts(userDetails.getFailedAttempts());
		user.setBlockedAccess(userDetails.isBlockedAccess());
		user.setActive(userDetails.isActive());
		user.setRoles(roles);
		
		return user;
	}
	
	private static final List<RoleResponse> getRoles(User user) {
		return user.getRoles().stream().map(RoleConverter::map).toList();
	}
	
	private static final List<Role> getRoles(UserDetailsResponse userDetailsResponse) {
		return userDetailsResponse.getRoles().stream().map(RoleConverter::map).toList();
	}
	
}