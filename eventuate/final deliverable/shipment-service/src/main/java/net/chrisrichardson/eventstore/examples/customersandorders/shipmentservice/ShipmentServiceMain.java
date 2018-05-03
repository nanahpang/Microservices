package net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import net.chrisrichardson.eventstore.examples.customersandorders.commonswagger.CommonSwaggerConfiguration;
import net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.web.ShipmentWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ShipmentWebConfiguration.class,
        EventuateDriverConfiguration.class,
        CommonSwaggerConfiguration.class})
@EnableAutoConfiguration
@ComponentScan
public class ShipmentServiceMain {
  public static void main(String[] args) {
    SpringApplication.run(ShipmentServiceMain.class, args);
  }
}
