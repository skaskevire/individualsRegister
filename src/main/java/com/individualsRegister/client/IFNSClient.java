
package com.individualsRegister.client;

import java.math.BigInteger;

import ru.gosuslugi.smev.rev111111.GetType;
import ru.gosuslugi.smev.rev111111.QueryType;


/**
 * FNS Service client 
 * 
 * @author Raman Skaskevich
 * */
public interface IFNSClient
{
	/**
	 * Query for INN
	 * 
	 * @return Inn request id
	 * */
	BigInteger requestINNFLFIODR(QueryType request);

	/**
	 * Check for the request completion
	 * 
	 * @return INN
	 * */
	String getINNFLFIODR(GetType request);
}
