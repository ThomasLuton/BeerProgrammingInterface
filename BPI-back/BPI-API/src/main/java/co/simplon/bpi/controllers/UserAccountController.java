package co.simplon.bpi.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.bpi.dtos.UserAccountDto;
import co.simplon.bpi.dtos.UserAccountRoleUpdateDto;
import co.simplon.bpi.dtos.UserAccountView;
import co.simplon.bpi.services.UserAccountService;

@RestController
@RequestMapping("/user-accounts")
public class UserAccountController {

    private UserAccountService service;

    public UserAccountController(
	    UserAccountService service) {
	this.service = service;
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(
	    @Valid @RequestBody UserAccountDto inputs) {
	service.create(inputs);
    }

    @GetMapping
    public Collection<UserAccountView> getAll() {
	return service.getAll();
    }

    @PutMapping("/update-role/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRole(@PathVariable("id") Long id,
	    @RequestBody UserAccountRoleUpdateDto inputs) {
	service.updateRole(inputs, id);
    }

}
