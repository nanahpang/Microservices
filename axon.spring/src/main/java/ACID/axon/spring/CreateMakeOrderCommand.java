package ACID.axon.spring;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CreateMakeOrderCommand {
	@TargetAggregateIdentifier
    private final String itemId;
    private final String description;
    private final int price;
 
    public CreateMakeOrderCommand(String itemId, String description, int price) {
        this.itemId = itemId;
        this.description = description;
        this.price = price;
    }
 
    public String getItemId() {
        return itemId;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getPrice() {
    		return price;
    }
}
