package com.login.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.login.model.AppUser;
import com.login.service.AppUserServiceImpl;
import com.login.service.LoginServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
    private AppUserServiceImpl service;

	@RequestMapping(method = RequestMethod.GET)
    public List<AppUser> findAll() {
        return service.findAll();
    }

	 @RequestMapping(method = RequestMethod.POST)
	    public AppUser create(@Valid @RequestBody AppUser user) throws SQLException {
	        return service.create(user);
	    }

	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	    public AppUser update(@PathVariable Long id, @Valid @RequestBody AppUser dto) {
	        return service.update(id, dto);
	    }

	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public void delete(@PathVariable Long id) throws DataAccessException, SQLException {
	        service.delete(id);
	    }

	   


}
