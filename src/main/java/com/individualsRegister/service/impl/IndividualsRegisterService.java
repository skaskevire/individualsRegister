
package com.individualsRegister.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.individualsRegister.client.IFNSClient;
import com.individualsRegister.convert.IConverter;
import com.individualsRegister.dao.IDao;
import com.individualsRegister.dao.entity.UserDO;
import com.individualsRegister.service.IIndividualsRegisterService;
import com.individualsRegister.service.entity.User;

import ru.gosuslugi.smev.rev111111.AppDataType;
import ru.gosuslugi.smev.rev111111.MessageDataType;
import ru.gosuslugi.smev.rev111111.MessageType;
import ru.gosuslugi.smev.rev111111.OrgExternalType;
import ru.gosuslugi.smev.rev111111.QueryType;
import ru.gosuslugi.smev.rev111111.StatusType;
import ru.gosuslugi.smev.rev111111.TypeCodeType;
import unisoft.ws.innfiodr.query.rq.Документ;

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

	@Override
	public boolean isUserExists(Integer id)
	{
		boolean exists = false;
		if(id != null && userDao.read(id) != null)
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
		for(UserDO userDO : userDOList)
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

	@Override
	public void createUser(User user)
	{
		QueryType request = new QueryType();			
		
		
		MessageType messageType = new MessageType();

		
		
		OrgExternalType fnsR = new OrgExternalType();
		fnsR.setCode("FNSR01001");
		fnsR.setName("ФНС России");		
		messageType.setSender(fnsR);
		messageType.setRecipient(fnsR);
		messageType.setOriginator(fnsR);
		messageType.setTypeCode(TypeCodeType.GSRV);
		messageType.setStatus(StatusType.REQUEST);
		messageType.setExchangeType("2");
		try
		{
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(new Date());
			XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			messageType.setDate(date);
		}
		catch (DatatypeConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		request.setMessage(messageType);
		
		
		
MessageDataType mdt = new MessageDataType();
		
		AppDataType adt = new AppDataType();
		
		Документ документ = new Документ();
		документ.setВерсФорм("4.01");
		Документ.СвФЛ свФЛ = new Документ.СвФЛ();
		свФЛ.setДатаРожд("12.07.1954");
		свФЛ.setИмя("ПЕТР");
		свФЛ.setФамилия("ЧАХЛОВ");
		свФЛ.setОтчество("АЛЕКСЕЕВИЧ");
		документ.setСвФЛ(свФЛ);
		adt.getAny().add(документ);	
		mdt.setAppData(adt);
		request.setMessageData(mdt);
		
		BigInteger requestId = fnsClient.requestINNFLFIODR(request);
		if(requestId == null)
		{
			throw new RuntimeException();
		}
		
		UserDO userDO = userConverter.convert(user);
		userDO.setFnsidRequestId(requestId);
		userDao.create(userDO);
	}

	@Override
	public void updateUser(User user)
	{
		QueryType request = new QueryType();			
		
		MessageType messageType = new MessageType();
		OrgExternalType fnsR = new OrgExternalType();
		fnsR.setCode("FNSR01001");
		fnsR.setName("ФНС России");		
		messageType.setSender(fnsR);
		messageType.setRecipient(fnsR);
		messageType.setOriginator(fnsR);
		messageType.setTypeCode(TypeCodeType.GSRV);
		messageType.setStatus(StatusType.REQUEST);
		messageType.setExchangeType("2");
		try
		{
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(new Date());
			XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			messageType.setDate(date);
		}
		catch (DatatypeConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		request.setMessage(messageType);
		
		MessageDataType mdt = new MessageDataType();
		
		AppDataType adt = new AppDataType();
		
		Документ документ = new Документ();
		документ.setВерсФорм("4.01");
		Документ.СвФЛ свФЛ = new Документ.СвФЛ();
		свФЛ.setДатаРожд("12.07.1954");
		свФЛ.setИмя("ПЕТР");
		свФЛ.setФамилия("ЧАХЛОВ");
		свФЛ.setОтчество("АЛЕКСЕЕВИЧ");
		документ.setСвФЛ(свФЛ);
		adt.getAny().add(документ);	
		adt.getOtherAttributes().put(new QName("fns-AppData","wsu","Id"), null);
		mdt.setAppData(adt);
		request.setMessageData(mdt);
		
		BigInteger requestId = fnsClient.requestINNFLFIODR(request);
		if(requestId == null)
		{
			throw new RuntimeException();
		}
		
		UserDO userDO = userConverter.convert(user);
		userDO.setFnsidRequestId(requestId);
		userDao.update(userDO);
	}

	@Override
	public void deleteUser(Integer id)
	{
		UserDO entity = userDao.read(id);
		userDao.delete(entity);
	}

}
