package net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.backend;

import io.eventuate.sync.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import net.chrisrichardson.eventstore.examples.customersandorders.common.domain.Money;

public class ShipmentServiceImpl implements ShipmentService {

  private final AggregateRepository<Shipment, ShipmentCommand> shipmentRepository;

  public ShipmentServiceImpl(AggregateRepository<Shipment, ShipmentCommand> shipmentRepository) {
    this.shipmentRepository = shipmentRepository;
  }

  @Override
  public EntityWithIdAndVersion<Shipment> createShipment(String orderId) {
    return shipmentRepository.save(new CreateShipmentCommand(orderId));
  }
}
