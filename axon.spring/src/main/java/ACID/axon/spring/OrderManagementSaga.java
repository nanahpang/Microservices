package ACID.axon.spring;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.SagaLifecycle;
import org.axonframework.eventhandling.saga.StartSaga;

public class OrderManagementSaga {
	private boolean paid = false;
    private boolean delivered = false;
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "itemId")
    public void handle(OrderCreatedEvent event) {
        // client generated identifiers (1)
    
    		Item item = checkItemAvailibility(quantity);
        ShippingId shipmentId = createShipmentId();
        InvoiceId invoiceId = createInvoiceId();
        // associate the Saga with these values, before sending the commands (2)
        associateWith("shipmentId", shipmentId);
        associateWith("invoiceId", invoiceId);
        // send the commands
        commandGateway.send(new CreateMakeOrderCommand(itemId, description, price));
        commandGateway.send(new CreateInvoiceCommand(...));
    }

    @SagaEventHandler(associationProperty = "shipmentId")
    public void handle(ShippingArrivedEvent event) {
        delivered = true;
        if (paid) {
        		SagaLifecycle.end();
        }
    }

    @SagaEventHandler(associationProperty = "invoiceId")
    public void handle(InvoicePaidEvent event) {
        paid = true;
        if (delivered) {
        		SagaLifecycle.end();
        }
    }

}
