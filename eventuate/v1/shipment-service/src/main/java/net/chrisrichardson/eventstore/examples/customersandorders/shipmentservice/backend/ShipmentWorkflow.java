package net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.backend;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EventHandlerContext;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import net.chrisrichardson.eventstore.examples.customersandorders.common.domain.Money;
import net.chrisrichardson.eventstore.examples.customersandorders.common.order.OrderCreatedEvent;

import java.util.concurrent.CompletableFuture;

@EventSubscriber(id = "shipmentWorkflow")
public class ShipmentWorkflow {

}
