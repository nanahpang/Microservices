// Order class extends ReflectiveMutableCommandProcessingAggregate class in Eventuate
// ReflectiveMutableCommandProcessingAggregate has two type parameters: the aggregate type and the aggregate’s command superinterface.
// ReflectiveMutableCommandProcessingAggregate uses reflection to invoke the appropriate handler method for each command and event.
public class Order extends
    ReflectiveMutableCommandProcessingAggregate<Order, OrderCommand> {
  // Each orrder aggregate contains order state variable and customerId
  private OrderState state;
  private String customerId;
  // Overload process method for ShipOrderCommand
  // ShipOrderCommand creates new OrderShippedEvent
  //    in order aggregate repository
  public List<Event> process(ShipOrderCommand cmd) {
    return EventUtil.events(new OrderShippedEvent(customerId));
  }
  // Overload apply method for OrderShippedEvent
  // OrderShippedEvent change order state to SHIPPED
  public void apply(OrderShippedEvent event) {
    this.state = OrderState.SHIPPED;
  }
}
