package co.simplon.bpi.services;

import java.util.Collection;

import co.simplon.bpi.dtos.UserAccountDto;
import co.simplon.bpi.dtos.UserAccountRoleUpdateDto;
import co.simplon.bpi.dtos.UserAccountView;

public interface UserAccountService {
    void create(UserAccountDto inputs);

    Collection<UserAccountView> getAll();

    void updateRole(UserAccountRoleUpdateDto inputs,
	    Long id);
}
