package net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.web;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import io.eventuate.Aggregates;
import io.eventuate.DefaultMissingApplyEventMethodStrategy;
import io.eventuate.EntityIdAndVersion;
import io.eventuate.EntityNotFoundException;
import io.eventuate.EntityWithMetadata;
import io.eventuate.Int128;
import net.chrisrichardson.eventstore.examples.customersandorders.common.shipment.ShipmentCreatedEvent;
import net.chrisrichardson.eventstore.examples.customersandorders.common.domain.Money;
import net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.backend.Shipment;
import net.chrisrichardson.eventstore.examples.customersandorders.shipmentservice.backend.ShipmentService;
import org.junit.Before;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public abstract class AbstractShipmentServiceContractTest {

  private ShipmentService shipmentService;

  @Before
  public void setup() {
    shipmentService = mock(ShipmentService.class);
    RestAssuredMockMvc.standaloneSetup(new ShipmentController(shipmentService));
    when(shipmentService.findById("1223232-none")).thenThrow(new EntityNotFoundException());

    Shipment shipment = Aggregates.recreateAggregate(Shipment.class,
            Collections.singletonList(new ShipmentCreatedEvent("Fred")), DefaultMissingApplyEventMethodStrategy.INSTANCE);

    EntityWithMetadata<Shipment> result =
            new EntityWithMetadata<>(new EntityIdAndVersion("1223232", new Int128(1, 2)), Optional.empty(),
            Collections.emptyList(), shipment);
    when(shipmentService.findById("1223232"))
            .thenReturn(result);
  }
}
