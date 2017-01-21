
package com.individualsRegister.client;

import java.math.BigInteger;

import ru.gosuslugi.smev.rev111111.GetType;
import ru.gosuslugi.smev.rev111111.QueryType;

public interface IFNSClient
{
	BigInteger requestINNFLFIODR(QueryType request);

	String getINNFLFIODR(GetType request);
}
