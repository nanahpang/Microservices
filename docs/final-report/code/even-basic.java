public class ShipmentCreatedEvent implements ShipmentEvent {
  // ShipmentEvent extends from Event class in Eventuate
  // ShipmentCreatedEvent implements ShipmentEvent
  // ShipmentCreatedEvent takes String orderId as argument
  //     for changing order status
  // ShipmentCreatedEvent defines OrderState as SHIPPED in getState()
  private String orderId;
  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }
  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }
  private ShipmentCreatedEvent() { }
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
public class OrderShippedEvent implements OrderEvent {
  // OrderEvent extends Event class in Eventuate
  // OrderShipped Event implements OrderEvent
  // Constructor takes String customerId as argument for
  //     customer history order query
  private String customerId;
  private OrderShippedEvent() { }
  public OrderShippedEvent(String customerId) {
    this.customerId = customerId;
  }
  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }
  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }
  public String getCustomerId() {
    return customerId;
  }
}
public class ShipOrderCommand implements OrderCommand {
  // OrderCommand extends from Command class in Eventuate
  // ShipOrderCommand implements OrderCommand class
  // ShipOrderCommand takes OrderState as arugument for
  //     changing order status in Order Aggregate
  private final OrderState state;
  public ShipOrderCommand(OrderState state) {
    this.state = state;
  }
  public OrderState getState() {
    return state;
  }
}
