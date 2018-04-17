package ACID.axon.spring;

public class OrderCreatedEvent {
    private final String itemId;
    private final String description;
    private int price;
 
    public OrderCreatedEvent(String itemId, String description,int price) {
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
