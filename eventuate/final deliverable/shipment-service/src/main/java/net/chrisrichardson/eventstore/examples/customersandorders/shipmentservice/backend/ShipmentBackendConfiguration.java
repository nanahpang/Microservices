package net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.backend;

import io.eventuate.sync.AggregateRepository;
import io.eventuate.sync.EventuateAggregateStore;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEventHandlers
public class ShipmentBackendConfiguration {

  @Bean
  public ShipmentWorkflow shipmentWorkflow() {
    return new ShipmentWorkflow();
  }


  @Bean
  public ShipmentService shipmentService(AggregateRepository<Shipment, ShipmentCommand> shipmentRepository) {
    return new ShipmentServiceImpl(shipmentRepository);
  }

  @Bean
  public AggregateRepository<Shipment, ShipmentCommand> shipmentRepository(EventuateAggregateStore eventStore) {
    return new AggregateRepository<>(Shipment.class, eventStore);
  }

}


