package co.simplon.bpi.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import co.simplon.bpi.dtos.RoleView;
import co.simplon.bpi.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roles;

    public RoleServiceImpl(RoleRepository roles) {
	this.roles = roles;
    }

    @Override
    public Collection<RoleView> getAll() {
	return roles.findAllProjectedBy();
    }

}
