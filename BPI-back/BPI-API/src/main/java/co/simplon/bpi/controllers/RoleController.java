package co.simplon.bpi.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.bpi.dtos.RoleView;
import co.simplon.bpi.services.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private RoleService roles;

    public RoleController(RoleService roles) {
	this.roles = roles;
    }

    @GetMapping
    public Collection<RoleView> getAll() {
	return roles.getAll();
    }
}
