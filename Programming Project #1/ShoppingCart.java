/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Programming Assignment #1
 * Program: ShoppingCart
 */
import java.util.*;
public class ShoppingCart{
    private String customerName;
    private String currentDate;
    private ArrayList <ItemToPurchase> cartItems = new ArrayList<>();
    
    /**
     * Initialize new ShoppingCart with default name and date by calling 2 arg constructor
     */
    ShoppingCart(){
        this("none", "January 1, 2016");
    }
    
    /**
     * Initialize new ShoppingCart with user input name and date
     * @param customerName the name of the customer
     * @param currentDate the current date
     */
    ShoppingCart(String customerName, String currentDate){
        this.customerName = customerName;
        this.currentDate = currentDate;
    }
    
    /**
     * Retrieve the name of the customer
     * @return this.customerName the name of the customer
     */
    public String getCustomerName(){
        return this.customerName;
    }
    
    /**
     * Retrieve the date
     * @return this.currentDate the current date
     */
    public String getDate(){
        return this.currentDate;
    }
    
    /**
     * Add an item to a particular cart object
     * @param item the item that will be added to the cart
     */
    public void addItem(ItemToPurchase item){
        cartItems.add(item);
    }
    
    /**
     * Remove an item from a particular cart object if the item is in the cart
     * @param itemName the name of the item being removed
     */
    public void removeItem(String itemName){
        boolean found = false;
        //Loop through the ArrayList of items in the cart
        for(int c = 0; c < cartItems.size(); c++){
            if(cartItems.get(c).getName().equals(itemName)){
                //If the item exists, remove it
                cartItems.remove(c);
                found = true;
            }
        }
        
        //If the item doesn't exist, inform the user
        if(!found){
            System.out.println("The item could not be found! Nothing has been removed");
        }
    }
    
    /**
     * Edit an item's description, price, or quantity
     * @param item the item providing the input of what to change the values to
     */
    public void modifyItem(ItemToPurchase item){
        boolean found = false;
        int location = 0;
        //Loop through cartItems arraylist
        for(int c = 0; c < cartItems.size(); c++){
            if(cartItems.get(c).getName().equals(item.getName())){
                //If found, mark the location of the item
                found = true;
                location = c;
                break;
            }
        }
        
        if(found){
            //If the item is not a default item, modify it
            if(!(cartItems.get(location).getDescription().equals("none") && cartItems.get(location).getPrice() == 0 && cartItems.get(location).getQuantity() == 0)){
                
                //Since a user could be using this method to change one at a time, if the default values are entered into the parameter item, we want to change them to their actual values so they don't mess up the item being modified.
                //Only change the values if they are not significant to the operation
                if(item.getDescription().equals("none")){
                    item.setDescription(cartItems.get(location).getDescription());
                }
                if(item.getQuantity() == 0){
                    item.setQuantity(cartItems.get(location).getQuantity());
                }
                if(item.getPrice() == 0){
                    item.setPrice(cartItems.get(location).getPrice());
                }
                
                //Modify the item
                cartItems.get(location).setDescription(item.getDescription());
                cartItems.get(location).setQuantity(item.getQuantity());
                cartItems.get(location).setPrice(item.getPrice());
                System.out.println("Item Modified!");
            }
        }
        else{
            System.out.println("Item not found in cart. Nothing Modified");
        }
    }
    
    /**
     * Determine the number of items in a particular cart
     * @return cartItems.size() the number of items in the cart
     */
    public int getNumItemsInCart(){
        return cartItems.size();
    }
    
    /**
     * Determine the cost of all items in the cart
     * @return cost the total cost of the cart
     */
    public int getCostOfCart(){
        int cost = 0;
        //Loop through the ArrayList of items in the cart
        for(int c = 0; c < cartItems.size(); c++){
            //Multiply the cost of each item by the quantity and add it to the previous total cost
            cost = cost + (cartItems.get(c).getPrice() * cartItems.get(c).getQuantity());
        }
        return cost;
    }
    
    /**
     * Print the individual costs of all items in the cart
     */
    public void printTotal(){
        System.out.println(this.getCustomerName() + "'s Shopping Cart - " + this.getDate() + "\nNumber of Items: " + this.getNumItemsInCart() + "\n\n");
        //Loop through ArrayList of items in the cart
        for(int c = 0; c < cartItems.size(); c++){
            //Print the cost of each item
            cartItems.get(c).printItemCost();
        }
        
        System.out.println("Total Cost: $" + getCostOfCart());
    }
    
    /**
     * Print the individual descriptions of all items in the cart
     */
    public void printDescriptions(){
        System.out.println(this.getCustomerName() + "'s Shopping Cart - " + this.getDate() + "\n\nItem Descriptions");
        //Loop through ArrayList of items in the cart
        for(int c = 0; c < cartItems.size(); c++){
            //Print each description
            cartItems.get(c).printItemDescription();
        }
    }
}