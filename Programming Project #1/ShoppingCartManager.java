/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Programming Assignment #1
 * Program: ShoppingCartManager
 */
import java.util.*;
public class ShoppingCartManager{
    /**
     * Allows user input to run the ShoppingCart class and printMenu() menu
     * @param args arguments
     */
    public static void main (String args[]){
        //Prompt user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Customer's Name: ");
        String name = scan.nextLine();
        System.out.println("Enter today's date: ");
        String date = scan.nextLine();

        //Create Shopping Cart
        ShoppingCart cart = new ShoppingCart(name, date);

        //Print key info
        System.out.println("\n\nCustomer Name: " + cart.getCustomerName());
        System.out.println("Today's Date: " + cart.getDate());
        
        printMenu(cart);
    }

    /**
     * Prints and runs menu system and user selection while calling ShoppingCart methods to perform the actions that the user wants
     * @param cart the user's ShoppingCart
     */
    public static void printMenu(ShoppingCart cart){
        Scanner scan = new Scanner(System.in);
        //Menu is shown to user unless they quit
        while(true){
            //Print menu
            System.out.println("MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\nChoose an option:");
            String select = scan.nextLine();
            if(select.equals("a")){
                //Add ItemToPurchase to cart
                System.out.println("ADD ITEM TO CART\nEnter the item name: ");
                String itemName = scan.nextLine();
                System.out.println("Enter the item description: ");
                String itemDescription = scan.nextLine();
                System.out.println("Enter the item price: ");
                int price = scan.nextInt();
                System.out.println("Enter the item quantity: ");
                int quantity = scan.nextInt();
                ItemToPurchase item = new ItemToPurchase(itemName, itemDescription, price, quantity);
                cart.addItem(item);
                scan.nextLine();
            }
            else if(select.equals("d")){
                //Remove item from cart
                System.out.println("Enter name of item to remove: ");
                String itemName = scan.nextLine();
                cart.removeItem(itemName);
                System.out.println("Item Has been removed!\n");
            }
            else if(select.equals("c")){
                //Modify item quantity
                System.out.println("Change Item Quantity\nEnter the item name: ");
                String name = scan.nextLine();
                System.out.println("Enter a new quantity: ");
                int quantity = scan.nextInt();
                ItemToPurchase item = new ItemToPurchase(name, "none", 0, quantity);
                cart.modifyItem(item);
                scan.nextLine();
            }
            else if(select.equals("i")){
                //Show user the descriptions of all items in the cart
                cart.printDescriptions();
            }
            else if(select.equals("o")){
                //Show user the total cost of the cart
                cart.printTotal();
            }
            else if(select.equals("q")){
                //Quit
                break;
            }
            else{
                //Catch bad input
                System.out.println("\nPlease enter a valid character!\n");
            }
        }
    }
}