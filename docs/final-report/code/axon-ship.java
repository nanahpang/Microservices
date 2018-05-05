@CommandHandler
public Shipment(PrepareShipmentCommand command) throws InterruptedException {
    log.info("received PrepareShipmentCommand command for order: " + command.getOrderId());
    String id = Util.generateId();
    int shipment = computeShipment(command.getProductInfo());
    apply(new ShipmentPreparedEvent(id, command.getOrderId(), shipment));
}
