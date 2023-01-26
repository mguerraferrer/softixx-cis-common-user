package mx.softixx.cis.common.user.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

@Entity
@Table(name = "roles", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.role_seq_id", allocationSize = 1)
public class Role extends BaseEntity {
	
	@Column(name = "code", length = 20)
	private String code;
	
	@Column(name = "name", length = 20)
	private String name;

	@Column(name = "value_mx", length = 20)
	private String valueMx;

	@Column(name = "value_us", length = 20)
	private String valueUs;

	@Column(name = "visible")
	private boolean visible;

	@Column(name = "active")
	private boolean active;

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValueMx() {
		return valueMx;
	}

	public void setValueMx(String valueMx) {
		this.valueMx = valueMx;
	}

	public String getValueUs() {
		return valueUs;
	}

	public void setValueUs(String valueUs) {
		this.valueUs = valueUs;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}