package net.chrisrichardson.eventstore.examples.customersandorders.common.shipment;


import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.backend.Shipment")
public interface ShipmentEvent extends Event {
}
