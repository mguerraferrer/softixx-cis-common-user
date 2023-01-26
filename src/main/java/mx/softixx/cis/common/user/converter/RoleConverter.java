package mx.softixx.cis.common.user.converter;

import lombok.val;
import mx.softixx.cis.common.data.role.RoleResponse;
import mx.softixx.cis.common.user.persistence.model.Role;

public final class RoleConverter {

	private RoleConverter() {
	}
	
	public static final RoleResponse map(Role role) {
		if (role == null) {
			return null;
		}
		
		return RoleResponse
				.builder()
				.id(role.getId())
				.code(role.getCode())
				.name(role.getName())
				.valueMx(role.getValueMx())
				.valueUs(role.getValueUs())
				.visible(role.isVisible())
				.active(role.isActive())
				.build();
	}
	
	public static final Role map(RoleResponse roleResponse) {
		if (roleResponse == null) {
			return null;
		}
		
		val role = new Role();
		role.setId(roleResponse.getId());
		role.setCode(roleResponse.getCode());
		role.setName(roleResponse.getName());
		role.setValueMx(roleResponse.getValueMx());
		role.setValueUs(roleResponse.getValueUs());
		role.setVisible(roleResponse.isVisible());
		role.setActive(roleResponse.isActive());
		
		return role;
	}
	
}