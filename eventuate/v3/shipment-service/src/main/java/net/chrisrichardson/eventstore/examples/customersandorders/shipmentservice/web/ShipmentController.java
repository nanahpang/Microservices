package net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.web;

import io.eventuate.EntityNotFoundException;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import net.chrisrichardson.eventstore.examples.customersandorders.shipmentcommon.CreateShipmentRequest;
import net.chrisrichardson.eventstore.examples.customersandorders.shipmentcommon.CreateShipmentResponse;
import net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.backend.Shipment;
import net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.backend.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController {

  private ShipmentService shipmentService;

  @Autowired
  public ShipmentController(ShipmentService shipmentService) {
    this.shipmentService = shipmentService;
  }

  @RequestMapping(value = "/shipment", method = RequestMethod.POST)
  public CreateShipmentResponse createShipment(@RequestBody CreateShipmentRequest createShipmentRequest) {
    EntityWithIdAndVersion<Shipment> ewidv = shipmentService.createShipment(createShipmentRequest.getOrderId());
    return new CreateShipmentResponse(ewidv.getEntityId());
  }

}
