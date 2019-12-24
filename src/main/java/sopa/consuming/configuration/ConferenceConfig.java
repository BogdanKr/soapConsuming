package sopa.consuming.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import sopa.consuming.client.ConferenceClient;

@Configuration
public class ConferenceConfig {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    marshaller.setContextPath("com.soap.consuming.wsdl");
    return marshaller;
  }

  @Bean
  public ConferenceClient conferenceClient(Jaxb2Marshaller marshaller) {
    ConferenceClient conferenceClient = new ConferenceClient();
    conferenceClient.setDefaultUri("http://localhost:8080/ws");
    conferenceClient.setMarshaller(marshaller);
    conferenceClient.setUnmarshaller(marshaller);
    return conferenceClient;
  }
}
