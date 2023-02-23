package co.simplon.bpi.services;

import java.util.Collection;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import co.simplon.bpi.dtos.UserAccountDto;
import co.simplon.bpi.dtos.UserAccountRoleUpdateDto;
import co.simplon.bpi.dtos.UserAccountView;
import co.simplon.bpi.entitites.Role;
import co.simplon.bpi.entitites.UserAccount;
import co.simplon.bpi.repositories.RoleRepository;
import co.simplon.bpi.repositories.UserAccountRepository;

@Service
public class UserAccountServiceImpl
	implements UserAccountService {
    private UserAccountRepository userAccounts;
    private RoleRepository roles;
    private final int COST = 12;

    public UserAccountServiceImpl(
	    UserAccountRepository userAccounts,
	    RoleRepository roles) {
	this.userAccounts = userAccounts;
	this.roles = roles;
    }

    @Override
    public void create(UserAccountDto inputs) {
	UserAccount userAccount = new UserAccount();
	userAccount.setPseudo(inputs.getPseudo());
	userAccount.setMail(inputs.getMail());

	String hash = BCrypt.hashpw(inputs.getPassword(),
		BCrypt.gensalt(COST));
	userAccount.setPassword(hash);

	Role role = roles.getReferenceById((long) 1);
	userAccount.setRole(role);

	userAccounts.save(userAccount);
    }

    @Override
    public Collection<UserAccountView> getAll() {
	return userAccounts.findAllProjectedBy();
    }

    @Override
    public void updateRole(UserAccountRoleUpdateDto inputs,
	    Long id) {
	UserAccount entity = userAccounts.findById(id)
		.get();
	Role role = roles
		.getReferenceById(inputs.getRoleId());
	entity.setRole(role);

	userAccounts.save(entity);

    }

}
