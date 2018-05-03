package net.chrisrichardson.eventstore.examples.customersandorders.common.shipment;

import net.chrisrichardson.eventstore.examples.customersandorders.common.domain.Money;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import net.chrisrichardson.eventstore.examples.customersandorders.common.order.OrderState;

public class ShipmentCreatedEvent implements ShipmentEvent {
  private String orderId;

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  private ShipmentCreatedEvent() {
  }

  public ShipmentCreatedEvent(String orderId) {

    this.orderId = orderId;
  }

  public String getOrderId() {
    return orderId;
  }
  public OrderState getState() {
    return OrderState.SHIPPED;
  }

}
