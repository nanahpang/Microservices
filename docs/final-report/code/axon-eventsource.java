@EventSourcingHandler
public void on(ShipmentPreparedEvent event) {
    this.id = event.getShipmentId();
    this.orderId = event.getOrderId();
    this.price = event.getPrice();
}
@EventSourcingHandler
public void on(ShipmentPreparationFailedEvent event) {
    this.id = event.getShipmentId();
    this.orderId = event.getOrderId();
}
