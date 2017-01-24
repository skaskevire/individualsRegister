
package com.individualsRegister.client.impl;

import java.math.BigInteger;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceOperations;

import com.individualsRegister.client.IFNSClient;
import com.individualsRegister.exception.IndividualRegisterExceptionEnum;

import ru.gosuslugi.smev.rev111111.GetResponseType;
import ru.gosuslugi.smev.rev111111.GetType;
import ru.gosuslugi.smev.rev111111.QueryResponseType;
import ru.gosuslugi.smev.rev111111.QueryType;
import unisoft.ws.innfiodr.query.rs.��������;

/**
 * Implementation of {@link IFNSClien}
 * 
 * @author Raman Skaskevich
 */
@Service
public class FNSClient implements IFNSClient
{

	@Autowired
	@Qualifier("fnsServiceClient")
	private WebServiceOperations fnsServiceClient;

	/**
	 * {@inheritDoc}
	 * 
	 */
	public String getINNFLFIODR(GetType request)
	{
		unisoft.ws.ObjectFactory objectFactory = new unisoft.ws.ObjectFactory();
		GetResponseType response = sendRequest(objectFactory.createGetINNFLFIODR(request),
				fnsServiceClient);
		unisoft.ws.innfiodr.get.rs.�������� �������� = ((unisoft.ws.innfiodr.get.rs.��������) response
				.getMessageData().getAppData().getAny().get(0));

		return ��������.get�����();
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	public BigInteger requestINNFLFIODR(QueryType request)
	{
		unisoft.ws.ObjectFactory objectFactory = new unisoft.ws.ObjectFactory();
		QueryResponseType response = sendRequest(objectFactory.createQueryINNFLFIODR(request),
				fnsServiceClient);
		�������� �������� = ((unisoft.ws.innfiodr.query.rs.��������) response.getMessageData()
				.getAppData().getAny().get(0));

		BigInteger requestId = ��������.get���������();
		if (requestId == null)
		{
			IndividualRegisterExceptionEnum.INNFLFIODR_REQUEST_FAILED.raise(��������.get������());
		}
		return requestId;
	}

	@SuppressWarnings("unchecked")
	private <R, A> A sendRequest(JAXBElement<R> request, WebServiceOperations webServiceTemplate)
	{
		return ((JAXBElement<A>) webServiceTemplate.marshalSendAndReceive(request)).getValue();

	}

}
