
package com.individualsRegister.convert.impl;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.individualsRegister.convert.IConverter;
import com.individualsRegister.dao.entity.UserDO;
import com.individualsRegister.exception.IndividualRegisterExceptionEnum;

import ru.gosuslugi.smev.rev111111.AppDataType;
import ru.gosuslugi.smev.rev111111.GetType;
import ru.gosuslugi.smev.rev111111.MessageDataType;
import ru.gosuslugi.smev.rev111111.MessageType;
import ru.gosuslugi.smev.rev111111.OrgExternalType;
import ru.gosuslugi.smev.rev111111.StatusType;
import ru.gosuslugi.smev.rev111111.TypeCodeType;
import unisoft.ws.innfiodr.get.rq.Документ;

/**
 * Converts {@link UserDO} to {@link GetType}
 * 
 * 
 * @author Raman Skaskevich
 * */
@Component("userDOToGetTypeConverter")
public class UserDOToGetTypeConverter implements IConverter<UserDO, GetType>
{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDOToGetTypeConverter.class);
	@Override
	public GetType convert(UserDO user)
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
			LOGGER.error(e.getMessage(), e);
			IndividualRegisterExceptionEnum.UNEXPECTED_ERROR.raise(e);
		}
		request.setMessage(messageType);

		MessageDataType mdt = new MessageDataType();

		AppDataType adt = new AppDataType();

		Документ документ = new Документ();
		документ.setВерсФорм("4.01");
		документ.setИдЗапросФ(user.getInnRequestId());
		adt.getAny().add(документ);
		mdt.setAppData(adt);
		request.setMessageData(mdt);

		return request;
	}

}
