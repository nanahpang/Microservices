@CommandHandler
public OrderAggregate(FileOrderCommand command) {
    apply(new OrderFiledEvent(command.getOrderId(), command.getProductInfo()));
}
@CommandHandler
public void handle(OrderCompletedCommand command) {
    apply(new OrderCompletedEvent(command.getOrderId(), command.getProductInfo()));
}
@CommandHandler
public void handle(CancelOrderCommand command) {
    apply(new OrderCancelledEvent(command.getOrderId()));
}
@EventSourcingHandler
public void on(OrderFiledEvent event) {
    orderId = event.getOrderId();
}
