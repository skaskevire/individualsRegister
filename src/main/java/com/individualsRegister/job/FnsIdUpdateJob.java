package com.individualsRegister.job;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.individualsRegister.client.IFNSClient;
import com.individualsRegister.dao.IDao;
import com.individualsRegister.dao.entity.UserDO;

import ru.gosuslugi.smev.rev111111.AppDataType;
import ru.gosuslugi.smev.rev111111.GetType;
import ru.gosuslugi.smev.rev111111.MessageDataType;
import ru.gosuslugi.smev.rev111111.MessageType;
import ru.gosuslugi.smev.rev111111.OrgExternalType;
import ru.gosuslugi.smev.rev111111.StatusType;
import ru.gosuslugi.smev.rev111111.TypeCodeType;
import unisoft.ws.innfiodr.get.rq.Документ;

@Component("fnsIdUpdateJob")
public class FnsIdUpdateJob implements IFnsIdUpdateJob
{
	
	@Autowired
	private IFNSClient fnsClient;
	
	@Autowired
	@Qualifier("userDao")
	private IDao<UserDO, Integer> userDao;
	
	@Override
	public void updateFnsIds()
	{
		
		 int offset = 0;

		    List<UserDO> users;
		    while ((users = userDao.getAllUsersIterable(10, offset)).size() > 0)
		    {
		        for (UserDO user : users)
		        {
		        	GetType request = new GetType();
		        	
		        	MessageType messageType = new MessageType();

		    		
		    		
		    		OrgExternalType fnsR = new OrgExternalType();
		    		fnsR.setCode("FNSR01001");
		    		fnsR.setName("ФНС России");		
		    		messageType.setSender(fnsR);
		    		messageType.setRecipient(fnsR);
		    		messageType.setOriginator(fnsR);
		    		messageType.setTypeCode(TypeCodeType.GSRV);
		    		messageType.setStatus(StatusType.PING);
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
		    		документ.setИдЗапросФ(user.getFnsidRequestId());
		    		adt.getAny().add(документ);	
		    		mdt.setAppData(adt);
		    		request.setMessageData(mdt);
		        	String fnsId = fnsClient.getINNFLFIODR(request);
		        	if(fnsId != null)
		        	{
		        		user.setFnsid(fnsId);
		        		userDao.update(user);
		        	}		        	
		        }
		        offset += users.size();
		    }		
	}
}
