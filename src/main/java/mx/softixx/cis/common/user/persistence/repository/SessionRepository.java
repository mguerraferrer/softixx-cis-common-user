package mx.softixx.cis.common.user.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import mx.softixx.cis.common.user.persistence.model.Session;
import mx.softixx.cis.common.user.persistence.model.User;

public interface SessionRepository extends JpaRepository<Session, Long> {
	
	Optional<Session> findByUser(User user);
	
	Optional<Session> findBySessionKey(String token);
	
	@Modifying
	int deleteByUser(User user);
	
	@Modifying
	int deleteBySessionKey(String sessionKey);
	
}