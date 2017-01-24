
package com.individualsRegister.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.individualsRegister.client.IFNSClient;
import com.individualsRegister.convert.IConverter;
import com.individualsRegister.dao.IDao;
import com.individualsRegister.dao.entity.UserDO;

import ru.gosuslugi.smev.rev111111.GetType;

/**
 * Job which updates INN of users which are requested it's creation ( request id
 * stored in database ).
 * 
 * 1. get batch with users from DB. 2. check whether INN processed. 3. updates
 * users in database with processed INN.
 * 
 * @author Raman Skaskevich
 */
@Component("innUpdateJob")
public class INNUpdateJob implements IINNUpdateJob
{
	private static final Logger LOGGER = LoggerFactory.getLogger(INNUpdateJob.class);

	@Autowired
	private IFNSClient fnsClient;

	@Autowired
	@Qualifier("userDao")
	private IDao<UserDO, Integer> userDao;

	@Autowired
	@Qualifier("userDOToGetTypeConverter")
	IConverter<UserDO, GetType> userDOToGetTypeConverter;

	@Override
	public void updateInns()
	{

		int offset = 0;

		List<UserDO> users;
		while ((users = userDao.getAllUsersIterable(10, offset)).size() > 0)
		{

			for (UserDO user : users)
			{
				try
				{
					if(user.getInnRequestId() != null)
					{
						String inn = fnsClient.getINNFLFIODR(userDOToGetTypeConverter.convert(user));
						if (inn != null)
						{
							user.setInn(inn);
							userDao.update(user);
						}
					}					
				}
				catch (Exception e)
				{
					LOGGER.error(e.getMessage(), e);
				}

			}
			offset += users.size();
		}
	}
}
