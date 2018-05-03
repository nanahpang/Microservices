package net.chrisrichardson.eventstore.examples.customersandorders.shipmentcommon;


public class CreateShipmentResponse {
  private String shipmentId;

  public CreateShipmentResponse() {
  }

  public CreateShipmentResponse(String shipmentId) {
    this.shipmentId = shipmentId;

  }

  public String getShipmentId() {
    return shipmentId;
  }
}
