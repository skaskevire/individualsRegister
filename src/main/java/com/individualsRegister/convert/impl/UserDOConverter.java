package com.individualsRegister.convert.impl;

import org.springframework.stereotype.Component;

import com.individualsRegister.convert.IConverter;
import com.individualsRegister.dao.entity.UserDO;
import com.individualsRegister.service.entity.User;
@Component("userDOConverter")
public class UserDOConverter implements IConverter<UserDO, User>
{

	@Override
	public User convert(UserDO source)
	{
		User target = new User();
		target.setBirthDate(source.getBirthDate());
		target.setFirstName(source.getFirstName());
		target.setId(source.getId());
		target.setFnsId(source.getFnsid());
		target.setLastName(source.getLastName());
		target.setMiddleName(source.getMiddleName());
		return target;
	}

}
