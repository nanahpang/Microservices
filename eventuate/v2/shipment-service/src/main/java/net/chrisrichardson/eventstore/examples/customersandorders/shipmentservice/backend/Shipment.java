package net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.backend;

import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import net.chrisrichardson.eventstore.examples.customersandorders.common.shipment.ShipmentCreatedEvent;
import net.chrisrichardson.eventstore.examples.customersandorders.common.domain.Money;

import java.util.List;

public class Shipment extends ReflectiveMutableCommandProcessingAggregate<Shipment, ShipmentCommand> {

  private String orderId;

  public List<Event> process(CreateShipmentCommand cmd) {
    return EventUtil.events(new ShipmentCreatedEvent(cmd.getOrderId()));
  }


  public void apply(ShipmentCreatedEvent event) {
    this.orderId = event.getOrderId();
  }
  

  public String getOrderId() {
    return orderId;
  }
}



