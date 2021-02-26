package com.userh2db.userdb.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
	public List<String> getUser()
	{
        return userService.getUser();
	}
    @GetMapping(path="/rich")
	public List<User> getUserRich()
	{
        return userService.getUserRich();
	}
    @GetMapping(path="/first/{forename}")
	public List<User> getUserByForename(@PathVariable("forename") String forename)
	{
        return userService.getUserByForename(forename);
	}
    @GetMapping(path="/last/{surename}")
	public List<User> getUserBySurename(@PathVariable("surename") String surename)
	{
        return userService.getUserBySurename(surename);
	}

    @PostMapping
    public void registerNewUser(@RequestBody User user, HttpServletRequest response) {
        try{
            userService.addNewUser(user);
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already taken!");
        }
    }
    
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId, HttpServletRequest response) {
        try {
            userService.deleteUser(userId);
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user with ID: " + userId + " found!");
        }
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId, 
                            @RequestParam(required = false) String forename,
                            @RequestParam(required = false) String surename,
                            @RequestParam(required = false) String email) {
        userService.updateUser(userId, forename, surename, email);        
    }
}
