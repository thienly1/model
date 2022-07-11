package org.example;

public class Candy extends  Product{
    private String type;

    public Candy(int id, double price, String productName, String type) {
        super(id, price, productName);
        this.type = type;
    }
    @Override
    public String examine() {
        return " Id product: "+ getId() + " Name product: " + getProductName()+ " price : " + getPrice();

    }

    @Override
    public String use() {
        return "Candy" ;
    }
}
