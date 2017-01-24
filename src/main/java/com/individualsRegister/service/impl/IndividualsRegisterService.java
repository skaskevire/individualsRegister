
package com.individualsRegister.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.individualsRegister.client.IFNSClient;
import com.individualsRegister.convert.IConverter;
import com.individualsRegister.dao.IDao;
import com.individualsRegister.dao.entity.UserDO;
import com.individualsRegister.service.IIndividualsRegisterService;
import com.individualsRegister.service.entity.User;

import ru.gosuslugi.smev.rev111111.QueryType;

/**
 * Implementation of {@link IIndividualsRegisterService}
 * 
 * @author Raman Skaskevich
 */
@Component("individualsRegisterService")
public class IndividualsRegisterService implements IIndividualsRegisterService
{
	@Autowired
	private IFNSClient fnsClient;

	@Autowired
	@Qualifier("userDao")
	private IDao<UserDO, Integer> userDao;

	@Autowired
	@Qualifier("userDOConverter")
	private IConverter<UserDO, User> userDOConverter;

	@Autowired
	@Qualifier("userConverter")
	private IConverter<User, UserDO> userConverter;

	@Autowired
	@Qualifier("userToQueryTypeConverter")
	IConverter<User, QueryType> userToQueryTypeConverter;

	@Override
	public boolean isUserExists(Integer id)
	{
		boolean exists = false;
		if (id != null && userDao.read(id) != null)
		{
			exists = true;
		}

		return exists;
	}

	@Override
	public List<User> listAllUsers()
	{
		List<User> userList = new ArrayList<User>();
		List<UserDO> userDOList = userDao.readAll();
		for (UserDO userDO : userDOList)
		{
			userList.add(userDOConverter.convert(userDO));
		}
		return userList;
	}

	@Override
	public User getUser(Integer id)
	{
		return userDOConverter.convert(userDao.read(id));
	}

	public BigInteger requestINN(User user)
	{
		BigInteger requestId = fnsClient.requestINNFLFIODR(userToQueryTypeConverter.convert(user));
		return requestId;
	}

	@Override
	public void createUser(User user)
	{
		UserDO userDO = userConverter.convert(user);
		userDao.create(userDO);
	}

	@Override
	public void updateUser(User user)
	{
		UserDO userDO = userConverter.convert(user);
		userDao.update(userDO);
	}

	@Override
	public void deleteUser(Integer id)
	{
		UserDO entity = userDao.read(id);
		userDao.delete(entity);
	}

}
