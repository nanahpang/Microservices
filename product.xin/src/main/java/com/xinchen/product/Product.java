package com.xinchen.product;

public class Product {
	private int count;
	private int id;
	private String name;
	
	public Product(int count, int id, String name) {
		this.count = count;
		this.id = id;
		this.name = name;	
	}
	
    @Override
    public String toString() {
        return String.format(
                "Product[count=%d, id='%d', name='%s']",
                count, id, name);
    }
    
    public int getCount() {
    		int countCopy = count;
    		return countCopy;
    }
    public int getId() {
    		int idCopy = id;
    		return idCopy;
    }
    public String getName() {
    		return new String(name);
    }
    public void changeCount(int count) {
    		this.count += count;
    }
}
