package net.chrisrichardson.eventstore.examples.customersandorders.ordersservice.backend;

import net.chrisrichardson.eventstore.examples.customersandorders.common.domain.Money;
import net.chrisrichardson.eventstore.examples.customersandorders.common.order.OrderState;

public class ShipOrderCommand implements OrderCommand {
  private final OrderState state;

  public ShipOrderCommand(OrderState state) {
    this.state = state;
  }

  public OrderState getState() {
    return state;
  }

}
