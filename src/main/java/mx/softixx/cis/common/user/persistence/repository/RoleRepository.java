package mx.softixx.cis.common.user.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.common.user.persistence.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(String name);
	
}