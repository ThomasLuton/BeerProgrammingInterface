package co.simplon.bpi.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.bpi.dtos.RoleView;
import co.simplon.bpi.entitites.Role;

public interface RoleRepository
	extends JpaRepository<Role, Long> {
    Collection<RoleView> findAllProjectedBy();
}