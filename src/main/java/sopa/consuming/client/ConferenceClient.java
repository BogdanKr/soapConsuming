package sopa.consuming.client;

import com.soap.consuming.wsdl.GetConferenceRequest;
import com.soap.consuming.wsdl.GetConferenceResponse;
import com.soap.consuming.wsdl.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ConferenceClient extends WebServiceGatewaySupport {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConferenceClient.class);

  public GetConferenceResponse getConferenceResponse(int id) {
    GetConferenceRequest request = new ObjectFactory().createGetConferenceRequest();
    request.setId(id);
    LOGGER.info("Requesting for conference ig= " + id);

    GetConferenceResponse response = (GetConferenceResponse) getWebServiceTemplate()
        .marshalSendAndReceive("http://localhost:8080/ws/conferences", request,
            new SoapActionCallback(
                "http://spring.io/guides/gs-producing-web-service/GetConferenceRequest"));
    return response;
  }

}
