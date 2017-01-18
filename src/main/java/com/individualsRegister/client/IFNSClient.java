
package com.individualsRegister.client;

import ru.gosuslugi.smev.rev111111.GetResponseType;
import ru.gosuslugi.smev.rev111111.GetType;
import ru.gosuslugi.smev.rev111111.QueryResponseType;
import ru.gosuslugi.smev.rev111111.QueryType;

public interface IFNSClient
{
	QueryResponseType requestINNFLFIODR(QueryType request);

	GetResponseType getINNFLFIODR(GetType request);
}
