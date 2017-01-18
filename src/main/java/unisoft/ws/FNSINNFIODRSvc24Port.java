
package unisoft.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import ru.gosuslugi.smev.rev111111.MessageDataType;
import ru.gosuslugi.smev.rev111111.MessageType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FNSINNFIODRSvc_24Port", targetNamespace = "http://ws.unisoft/")
@XmlSeeAlso({
    unisoft.ws.innfiodr.query.rq.ObjectFactory.class,
    org.w3._2004._08.xop.include.ObjectFactory.class,
    ru.gosuslugi.smev.rev111111.ObjectFactory.class,
    unisoft.ws.ObjectFactory.class,
    unisoft.ws.innfiodr.get.rq.ObjectFactory.class,
    unisoft.ws.innfiodr.get.rs.ObjectFactory.class,
    unisoft.ws.innfiodr.query.rs.ObjectFactory.class
})
public interface FNSINNFIODRSvc24Port {


    /**
     * 
     * @param message
     * @param messageData
     */
    @WebMethod(action = "queryINNFLFIODR")
    @RequestWrapper(localName = "queryINNFLFIODR", targetNamespace = "http://ws.unisoft/", className = "ru.gosuslugi.smev.rev111111.QueryType")
    @ResponseWrapper(localName = "queryINNFLFIODRResponse", targetNamespace = "http://ws.unisoft/", className = "ru.gosuslugi.smev.rev111111.QueryResponseType")
    public void queryINNFLFIODR(
        @WebParam(name = "Message", targetNamespace = "http://smev.gosuslugi.ru/rev111111", mode = WebParam.Mode.INOUT)
        Holder<MessageType> message,
        @WebParam(name = "MessageData", targetNamespace = "http://smev.gosuslugi.ru/rev111111", mode = WebParam.Mode.INOUT)
        Holder<MessageDataType> messageData);

    /**
     * 
     * @param message
     * @param messageData
     */
    @WebMethod(action = "getINNFLFIODR")
    @RequestWrapper(localName = "getINNFLFIODR", targetNamespace = "http://ws.unisoft/", className = "ru.gosuslugi.smev.rev111111.GetType")
    @ResponseWrapper(localName = "getINNFLFIODRResponse", targetNamespace = "http://ws.unisoft/", className = "ru.gosuslugi.smev.rev111111.GetResponseType")
    public void getINNFLFIODR(
        @WebParam(name = "Message", targetNamespace = "http://smev.gosuslugi.ru/rev111111", mode = WebParam.Mode.INOUT)
        Holder<MessageType> message,
        @WebParam(name = "MessageData", targetNamespace = "http://smev.gosuslugi.ru/rev111111", mode = WebParam.Mode.INOUT)
        Holder<MessageDataType> messageData);

    /**
     * 
     * @param testRequestIN
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "test")
    @WebResult(name = "TestResponse", targetNamespace = "http://ws.unisoft/", partName = "TestRequest_OUT")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public String test(
        @WebParam(name = "TestRequest", targetNamespace = "http://ws.unisoft/", partName = "TestRequest_IN")
        String testRequestIN);

}
