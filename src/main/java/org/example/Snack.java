package org.example;

public class Snack extends Product{
    private String ingredient;

    public Snack(int id, double price, String productName, String ingredient) {
        super(id, price, productName);
        this.ingredient = ingredient;

    }
    @Override
    public String examine() {
        return " Id product: "+ getId() + " Name product: " + getProductName()+ " price : " + getPrice();

    }
    @Override
    public String use() {
        return "Snack" ;
    }
}
