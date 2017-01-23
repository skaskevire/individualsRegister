package com.individualsRegister.convert.impl;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

import com.individualsRegister.convert.IConverter;
import com.individualsRegister.dao.entity.UserDO;
import com.individualsRegister.service.entity.User;

@Component("userConverter")
public class UserConverter implements IConverter<User, UserDO>
{

	@Override
	public UserDO convert(User source)
	{
		UserDO target = new UserDO();
		target.setFnsidRequestId(new BigInteger(source.getFnsidRequestId()));
		target.setBirthDate(source.getBirthDate());
		target.setFirstName(source.getFirstName());
		target.setId(source.getId());
		target.setFnsid(source.getFnsId());
		target.setLastName(source.getLastName());
		target.setMiddleName(source.getMiddleName());
		return target;
	}

}
