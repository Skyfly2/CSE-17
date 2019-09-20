/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Programming Assignment #1
 * Program: ShoppingCartPrinter
 */
import java.util.*;
public class ShoppingCartPrinter{
    /**
     * Allows user input for testing of the ItemToPurchase class
     * @param args arguments
     */
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        //Prompt user input
        System.out.println("Item 1");
        System.out.println("Enter the item name: ");
        String name = scnr.nextLine();
        System.out.println("Enter the item price: ");
        int price = scnr.nextInt();
        System.out.println("Enter the item quantity: ");
        int quantity = scnr.nextInt();
        //Create first item using input
        ItemToPurchase item1 = new ItemToPurchase();
        item1.setName(name);
        item1.setPrice(price);
        item1.setQuantity(quantity);
        
        scnr.nextLine();
        //Prompt input
        System.out.println("Item 2");
        System.out.println("Enter the item name: ");
        name = scnr.nextLine();
        System.out.println("Enter the item price: ");
        price = scnr.nextInt();
        System.out.println("Enter the item quantity: ");
        quantity = scnr.nextInt();
        //Create second item using input
        ItemToPurchase item2 = new ItemToPurchase();
        item2.setName(name);
        item2.setPrice(price);
        item2.setQuantity(quantity);
        
        System.out.println(" ");
        //Calculate total costs
        int cost1, cost2, totalcost;
        cost1 = item1.getQuantity() * item1.getPrice();
        cost2 = item2.getQuantity() * item2.getPrice();
        totalcost = cost1 + cost2;
        //Output total costs
        System.out.println("TOTAL COST");
        System.out.println(item1.getName() + ": " + item1.getQuantity() + " @ $" + item1.getPrice() + " = $" + cost1);
        System.out.println(item2.getName() + ": " + item2.getQuantity() + " @ $" + item2.getPrice() + " = $" + cost2);
        System.out.println("Total Cost: $" + totalcost);
    }
}