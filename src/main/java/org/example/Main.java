package org.example;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Your task is to create a VendingMachine (candy vending machine) in Java. It should be able to
 * receive money in predetermined amounts. Of course, you should also be able to decide which
 * product to buy by choosing the product from a list of choices. The machine should also be able
 * to give back change
 */
public class Main {
    public static void main(String[] args) {
        softCandy softCandy = new softCandy(1, 20, "masboh", "smallbag");
        Snack snack = new Snack(11, 50, "chips", "Cheese");
        Chocolate chocolate = new Chocolate(21, 10, "Chocolate", "white");
        int depositPool = 0;
        Scanner scanner = new Scanner(System.in);

        VendingMachineProduct vendingMachineProduct = new VendingMachineProduct(new Product[]{softCandy, snack, chocolate},depositPool);
        boolean run = true;

          System.out.print(" Pls put money in the machine: ");
        int money = scanner.nextInt();
          vendingMachineProduct.addCurrency(money);
        while(run) {
            System.out.println("This is a list of products, pls request a product by choosing the product's id: ");
            System.out.println("The list of products in detail: " + Arrays.toString(vendingMachineProduct.getProducts()));
            int getInt = VendingMachineProduct.getIntFromUser();
            Product i = vendingMachineProduct.request(getInt);
            int balance = vendingMachineProduct.getBalance();
            System.out.println("get Balance: " + balance);
            System.out.println("Do you want to continue?(y/n)");
            String getString = VendingMachineProduct.getStringFromUser();
            if (getString.equalsIgnoreCase("n")) {
                System.out.println("you get back change: " + balance);
                System.out.println("vendingMachineProduct = " +i.getProductName() );
                System.out.println("end session : " +vendingMachineProduct.endSession() );
                run = false;
            }
        }
    }

}