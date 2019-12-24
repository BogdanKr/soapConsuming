package sopa.consuming;

import com.soap.consuming.wsdl.GetConferenceResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sopa.consuming.client.ConferenceClient;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

  }

  @Bean
  CommandLineRunner lookup(ConferenceClient quoteClient) {
    return args -> {
      int id = 6;
      if (args.length > 0) {
        id = Integer.parseInt(args[0]);
      }
      GetConferenceResponse response = quoteClient.getConferenceResponse(id);
      System.err.println(
          "Subject: " + response.getConference().getSubject() + ", reader: " + response
              .getConference().getReaderName());
    };
  }
}
