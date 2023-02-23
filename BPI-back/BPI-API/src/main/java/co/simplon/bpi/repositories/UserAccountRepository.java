package co.simplon.bpi.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.bpi.dtos.UserAccountView;
import co.simplon.bpi.entitites.UserAccount;

public interface UserAccountRepository
	extends JpaRepository<UserAccount, Long> {
    Collection<UserAccountView> findAllProjectedBy();
}
