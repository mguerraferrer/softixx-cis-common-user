package mx.softixx.cis.common.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import mx.softixx.cis.common.validation.exception.CustomException;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper = false)
public class UserNotFoundException extends CustomException {

	@Getter
	private final Long id;
	@Getter
	private final String email;

	public UserNotFoundException(Long id) {
		super("User not found");
		this.id = id;
		this.email = null;
	}

	public UserNotFoundException(String email) {
		super("User not found");
		this.email = email;
		this.id = null;
	}

}