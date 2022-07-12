package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class VendingMachineProduct implements VendingMachine{

    private Product[] products;
    private int depositPool;
    private int id;

    public VendingMachineProduct(Product[] products, int depositPool) {
        this.products = products;
        this.depositPool = depositPool;
    }
    public Product[] getProduct(){
        return products;
    }

    public void setProduct(Product[] products) {
        this.products = products;
    }

    public int getDepositPool() {
        return depositPool;
    }

    public void setDepositPool(int depositPool) {
        this.depositPool = depositPool;
    }
    @Override
    public void addCurrency(int amount) {
        int [] depositPools = {1,2,5,10,20,50,100,200,500,1000 };
            for (int a : depositPools) {
                if (a == amount) {
                    setDepositPool(amount);
                    System.out.println("Your deposit is : " + getDepositPool());
                    break;
                }
         }
    }
    @Override
    public Product request(int id) {
        this.id = id;
        for ( Product i : products){
            if (i.getId() == id && i.getPrice()<= depositPool ){
                return i;
            }
        }
        return  null;
    }
    @Override
    public int getBalance() {
            depositPool -= request(id).getPrice();
            return depositPool;
    }
    @Override
    public int endSession() {
            depositPool = 0;
        return depositPool;
    }

    @Override
    public String getDescription(int id) {
        this.id = id;
        return request(id).examine();
    }
    @Override
    public String[] getProducts() {
        String [] arrays = new String[0];
        for (Product i : products) {
            String[] productName = Arrays.copyOf(arrays, arrays.length + 1);
            productName[arrays.length] = i.examine();
            arrays = Arrays.copyOf(productName, productName.length);
        }
        return arrays;
    }

    static Scanner scanner = new Scanner(System.in);
    static String getStringFromUser(){
        return scanner.nextLine();
    }
    static int getIntFromUser() {
        int number = 0;
        boolean invalid = true;
        while (invalid){
            try{
                number = Integer.parseInt(getStringFromUser());
                invalid = false;
            }
            catch (NumberFormatException ex){
                System.out.println("not an integer number");
            }
        }
        return number;
    }
}
