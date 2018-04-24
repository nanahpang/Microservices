package net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.backend;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import net.chrisrichardson.eventstore.examples.customersandorders.common.domain.Money;

public interface ShipmentService {

  EntityWithIdAndVersion<Shipment> createShipment(String orderId);

}
