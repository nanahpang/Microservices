// Register EventSubscriber for order service
@EventSubscriber(id="orderWorkflow")
public class OrderWorkflow {
  // Register EventHandlerMethod for listening ShipmentCreatedEvent from shipment service
  @EventHandlerMethod
  public CompletableFuture<EntityWithIdAndVersion<Order>> shipOrder(
          EventHandlerContext<ShipmentCreatedEvent> ctx) {
    // Get orderId from ShipmentCreatedEvent
    String orderId = ctx.getEvent().getOrderId();
    // Get order state from ShipmentCreatedEvent
    OrderState state = ctx.getEvent().getState();
    // Update order aggregate with same orderId and process ShipOrderCommand
    return ctx.update(Order.class, orderId, new ShipOrderCommand(state));
  }
}
