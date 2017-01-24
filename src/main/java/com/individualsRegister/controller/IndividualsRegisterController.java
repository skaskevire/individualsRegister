
package com.individualsRegister.controller;

import java.math.BigInteger;
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

/**
 * Controller class for user management operations
 * 
 * @author Raman Skaskevich
 * */
@Controller
public class IndividualsRegisterController
{
	@Autowired
	@Qualifier("individualsRegisterService")
	IIndividualsRegisterService individualsRegisterService;

	
	/**
	 * Returns list of all users
	 * 
	 * @return ResponseEntity<List<User>>
	 * */
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers()
	{
		List<User> users = individualsRegisterService.listAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	/**
	 * Returns user by id
	 * 
	 * @return ResponseEntity<User>
	 * */
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

	/**
	 * Creates user
	 * 
	 * @return ResponseEntity<Void>
	 * */
	@RequestMapping(value = "/user/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder)
	{

		if (individualsRegisterService.isUserExists(user.getId()))
		{
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		individualsRegisterService.createUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	/**
	 * Updates user
	 * 
	 * @return ResponseEntity<Void>
	 * */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user)
	{
		User currentUser = individualsRegisterService.getUser(id);
		if (currentUser == null)
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		mergeUserFields(currentUser, user);
		individualsRegisterService.updateUser(currentUser);

		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	private void mergeUserFields(User userFromDatabase, User userFromRequest)
	{
		userFromDatabase.setBirthDate(userFromRequest.getBirthDate());
		userFromDatabase.setFirstName(userFromRequest.getFirstName());
		userFromDatabase.setInn(userFromRequest.getInn());
		userFromDatabase.setLastName(userFromRequest.getLastName());
		userFromDatabase.setMiddleName(userFromRequest.getMiddleName());
	}

	/**
	 * Requests inn in FNS external service
	 * 
	 * @return ResponseEntity<User>
	 * */
	@RequestMapping(value = "/user/requestINN/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> requestINN(@PathVariable("id") Integer id)
	{
		User currentUser = individualsRegisterService.getUser(id);
		if (currentUser == null)
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		BigInteger requestID = individualsRegisterService.requestINN(currentUser);
		currentUser.setInnRequestId(requestID.toString());
		individualsRegisterService.updateUser(currentUser);

		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	/**
	 * Removes user
	 * 
	 * @return ResponseEntity<User>
	 * */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id)
	{
		User user = individualsRegisterService.getUser(id);
		if (user == null)
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		individualsRegisterService.deleteUser(id);

		return new ResponseEntity<User>(HttpStatus.OK);
	}

	/**
	 * Redirects to user management page
	 * 
	 * @return ResponseEntity<User>
	 * */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndexPage()
	{
		return "userManagement";
	}

}
