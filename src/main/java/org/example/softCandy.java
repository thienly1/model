package org.example;

public class softCandy extends Product{
    private String size;
    public softCandy(int id, double price, String productName, String size) {
        super(id, price, productName);
        this.size = size;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    @Override
    public String examine() {
        return " Id product: "+ getId() + " Name product: " + getProductName()+ " price : " + getPrice();
    }
    @Override
    public String use() {
        return "soft Candy" ;
    }
}
