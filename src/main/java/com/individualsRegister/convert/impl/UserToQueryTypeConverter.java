
package com.individualsRegister.convert.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.individualsRegister.convert.IConverter;
import com.individualsRegister.exception.IndividualRegisterExceptionEnum;
import com.individualsRegister.service.entity.User;

import ru.gosuslugi.smev.rev111111.AppDataType;
import ru.gosuslugi.smev.rev111111.MessageDataType;
import ru.gosuslugi.smev.rev111111.MessageType;
import ru.gosuslugi.smev.rev111111.OrgExternalType;
import ru.gosuslugi.smev.rev111111.QueryType;
import ru.gosuslugi.smev.rev111111.StatusType;
import ru.gosuslugi.smev.rev111111.TypeCodeType;
import unisoft.ws.innfiodr.query.rq.Документ;

/**
 * Converts {@link User} to {@link QueryType}
 * 
 * @author Raman Skaskevich
 * */
@Component("userToQueryTypeConverter")
public class UserToQueryTypeConverter implements IConverter<User, QueryType>
{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserToQueryTypeConverter.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	private static final String FNS_CODE="FNSR01001";
	private static final String FNS_CODE_DESCRIPTION = "ФНС России";
	private static final String EXCHANGE_TYPE = "2";
	private static final String DOCUMENT_VERSION = "4.01";

	@Override
	public QueryType convert(User source)
	{
		QueryType request = new QueryType();

		MessageType messageType = new MessageType();

		OrgExternalType fnsR = new OrgExternalType();
		fnsR.setCode(FNS_CODE);
		fnsR.setName(FNS_CODE_DESCRIPTION);
		messageType.setSender(fnsR);
		messageType.setRecipient(fnsR);
		messageType.setOriginator(fnsR);
		messageType.setTypeCode(TypeCodeType.GSRV);
		messageType.setStatus(StatusType.REQUEST);
		messageType.setExchangeType(EXCHANGE_TYPE);
		messageType.setDate(getCurrentDate());
		request.setMessage(messageType);

		MessageDataType mdt = new MessageDataType();

		AppDataType adt = new AppDataType();

		Документ документ = new Документ();
		документ.setВерсФорм(DOCUMENT_VERSION);
		Документ.СвФЛ свФЛ = new Документ.СвФЛ();
		if(source.getBirthDate() != null)
		{
			свФЛ.setДатаРожд(dateFormat.format(source.getBirthDate()));
		}		
		свФЛ.setИмя(source.getFirstName());
		свФЛ.setФамилия(source.getLastName());
		свФЛ.setОтчество(source.getMiddleName());
		документ.setСвФЛ(свФЛ);
		adt.getAny().add(документ);
		mdt.setAppData(adt);
		request.setMessageData(mdt);
		return request;
	}
	
	private XMLGregorianCalendar getCurrentDate()
	{
		XMLGregorianCalendar date = null;
		try
		{
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(new Date());
			date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			
		}
		catch (DatatypeConfigurationException e)
		{
			LOGGER.error(e.getMessage(), e);
			IndividualRegisterExceptionEnum.UNEXPECTED_ERROR.raise(e);
		}
		
		return date;
	}

}
