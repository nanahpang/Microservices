package net.chrisrichardson.eventstore.examples.customersandorders.shipmentcommon;

import net.chrisrichardson.eventstore.examples.customersandorders.common.domain.Money;

public class CreateShipmentRequest {
  private String orderId;

  public CreateShipmentRequest() {
  }

  public CreateShipmentRequest(String orderId) {

    this.orderId = orderId;
  }


  public String getOrderId() {
    return orderId;
  }

}
