
package com.individualsRegister.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.individualsRegister.service.IIndividualsRegisterService;
import com.individualsRegister.service.entity.User;

@Controller
public class IndividualsRegisterController
{
	@Autowired
	@Qualifier("individualsRegisterService")
	IIndividualsRegisterService individualsRegisterService;

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers()
	{
		List<User> users = individualsRegisterService.listAllUsers();
		if (users.isEmpty())
		{
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id)
	{
		User user = individualsRegisterService.getUser(id);
		if (user == null)
		{
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder)
	{        
        if (individualsRegisterService.isUserExists(user.getId())) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        individualsRegisterService.createUser(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user)
	{
		User currentUser = individualsRegisterService.getUser(id);
		   if (currentUser==null) {
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
		   currentUser.setBirthDate(user.getBirthDate());   
		   currentUser.setFirstName(user.getFirstName());
		   currentUser.setINNFLFIODR(user.getINNFLFIODR());
		   currentUser.setLastName(user.getLastName());
		   currentUser.setMiddleName(user.getMiddleName());
		   individualsRegisterService.updateUser(currentUser);
		   return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id)
	{
        User user = individualsRegisterService.getUser(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
  
        individualsRegisterService.deleteUser(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
