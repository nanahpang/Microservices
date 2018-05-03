package net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.backend;

import net.chrisrichardson.eventstore.examples.customersandorders.common.domain.Money;

public class CreateShipmentCommand implements ShipmentCommand {
  private final String orderId;
  
  public CreateShipmentCommand(String orderId) {
    this.orderId = orderId;
  }

  public String getOrderId() {
    return orderId;
  }
}
