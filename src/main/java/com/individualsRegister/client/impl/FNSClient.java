
package com.individualsRegister.client.impl;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceOperations;

import com.individualsRegister.client.IFNSClient;

import ru.gosuslugi.smev.rev111111.GetResponseType;
import ru.gosuslugi.smev.rev111111.GetType;
import ru.gosuslugi.smev.rev111111.QueryResponseType;
import ru.gosuslugi.smev.rev111111.QueryType;

@Service
public class FNSClient implements IFNSClient
{

	@Autowired
	@Qualifier("fnsServiceClient")
	private WebServiceOperations fnsServiceClient;

	public GetResponseType getINNFLFIODR(GetType request)
	{
		unisoft.ws.ObjectFactory objectFactory = new unisoft.ws.ObjectFactory();
		GetResponseType response = sendRequest(objectFactory.createGetINNFLFIODR(request), fnsServiceClient);
		return response;
	}
	
	public QueryResponseType requestINNFLFIODR(QueryType request)
	{
		unisoft.ws.ObjectFactory objectFactory = new unisoft.ws.ObjectFactory();
		QueryResponseType response = sendRequest(objectFactory.createQueryINNFLFIODR(request), fnsServiceClient);
		return response;
	}

	@SuppressWarnings("unchecked")
	private <R, A> A sendRequest(JAXBElement<R> request, WebServiceOperations webServiceTemplate)
	{
		return ((JAXBElement<A>) webServiceTemplate.marshalSendAndReceive(request)).getValue();

	}

}
