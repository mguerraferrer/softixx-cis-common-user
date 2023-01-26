package mx.softixx.cis.common.user.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.common.user.persistence.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByIdAndActiveTrue(Long id);
	
	Optional<User> findByEmailAndActiveTrueAndBlockedAccessFalse(String email);
	
	Optional<User> findByEmailAndHashAndActiveTrueAndBlockedAccessFalse(String email, String hash);
	
	Optional<User> findByHashAndActiveTrue(String hash);
	
	Optional<User> findByEmail(String email);

	Boolean existsByEmail(String email);

}