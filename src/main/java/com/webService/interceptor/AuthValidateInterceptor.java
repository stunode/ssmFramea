package com.webService.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.stereotype.Component;

/**
 * webservice 出口拦截器
 * Created by heylear on 15/11/9.
 */
@Component("authValidateInterceptor")
public class AuthValidateInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

    /*@Autowired
    WsAuthValidateService wsAuthValidateService;*/

    public AuthValidateInterceptor() {
        super(Phase.PRE_INVOKE);
    }

    public void handleMessage(SoapMessage soapMessage) throws Fault {
        /*List<Header> headerList = soapMessage.getHeaders();

        if (headerList == null || headerList.size() == 0) {
            throw new Fault(new SOAPException("no soap header provided!"));
        }

        SoapHeader appIdHeader = (SoapHeader) soapMessage.getHeader(new QName("authorization_app_id"));

        SoapHeader appSecretHeader = (SoapHeader) soapMessage.getHeader(new QName("authorization_app_secret"));

        if (appIdHeader == null || appIdHeader.getObject() == null) {
            throw new Fault(new SOAPException("no soap header [authorization_app_id] provided!"));
        }

        if (appSecretHeader == null || appSecretHeader.getObject() == null) {
            throw new Fault(new SOAPException("no soap header [authorization_app_secret] provided!"));
        }

        String appId = ((Element) appIdHeader.getObject()).getTextContent();

        String appSecret = ((Element) appSecretHeader.getObject()).getTextContent();*/

        /*if (!wsAuthValidateService.validateClientByAppIdAndAppSecret(appId, appSecret)){
            throw new Fault(new SOAPException("invalid client!"));
        }*/
    }
}
