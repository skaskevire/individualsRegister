
package com.individualsRegister.service;

import java.math.BigInteger;
import java.util.List;

import com.individualsRegister.service.entity.User;

/**
 * Service layer for operations with user data
 * 
 * @author Raman Skaskevich
 */
public interface IIndividualsRegisterService
{
	public List<User> listAllUsers();

	public User getUser(Integer id);

	public void createUser(User user);

	public void updateUser(User user);

	public void deleteUser(Integer id);

	public boolean isUserExists(Integer id);

	public BigInteger requestINN(User user);

}
