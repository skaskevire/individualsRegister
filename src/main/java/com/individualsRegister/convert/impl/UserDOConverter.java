package com.individualsRegister.convert.impl;

import org.springframework.stereotype.Component;

import com.individualsRegister.convert.IConverter;
import com.individualsRegister.dao.entity.UserDO;
import com.individualsRegister.service.entity.User;


/**
 * Converts {@link UserDO} to {@link User}
 * 
 * @author Raman Skaskevich
 * */
@Component("userDOConverter")
public class UserDOConverter implements IConverter<UserDO, User>
{

	@Override
	public User convert(UserDO source)
	{
		User target = new User();
		if(source!=null)
		{
			if(source.getInnRequestId() != null)
			{
				target.setInnRequestId(source.getInnRequestId().toString());
			}			
			target.setBirthDate(source.getBirthDate());
			target.setFirstName(source.getFirstName());
			target.setId(source.getId());
			target.setInn(source.getInn());
			target.setLastName(source.getLastName());
			target.setMiddleName(source.getMiddleName());
		}

		return target;
	}

}
