/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Programming Assignment #1
 * Program: ItemToPurchase
 */
public class ItemToPurchase{
    //Declare fields
    private String itemDescription;
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
     
    /**
     * Creates a new ItemToPurchase calling the 4 arg constructor
     */
    ItemToPurchase(){
        this("none", "none", 0, 0);
    }
    
    /**
     * Creates a new ItemToPurchase setting name, description, price, and quantity
     * @param name determines the name of the item
     * @param descritpion sets the item description
     * @param price sets the price of the item
     * @param quantity determines the quantity of the item
     */
    ItemToPurchase(String name, String description, int price, int quantity){
        this.itemName = name;
        this.itemDescription = description;
        this.itemPrice = price;
        this.itemQuantity = quantity;
    }
    
    /**
     * Prints thetotal cost of a specific item
     */
    public void printItemCost(){
        //Determine cost
        int subtotal = itemPrice * itemQuantity;
        System.out.println(itemName + ": " + itemQuantity + " @ $" + itemPrice + " = $" + subtotal);
    }
    
    /**
     * Prints the description of a specific item
     */
    public void printItemDescription(){
        System.out.println(itemName + ": " + itemDescription);
    }
    
    /**
     * Sets the description of a specific item
     * @param description determines the description
     */
    public void setDescription(String description){
        itemDescription = description;
    }
    
    /**
     * Retrieves the description of an item
     * @return itemDescription the description of the item
     */
    public String getDescription(){
        return itemDescription;
    }

    /**
     * Sets the name of an item
     * @param name determines the name of the item
     */
    public void setName(String name){
        itemName = name;
    }

    /**
     * Retrieves the name of the item
     * @return itemName the name of the item
     */
    public String getName(){
        return itemName;
    }  

    /**
     * Sets the price of the item
     * @param price determines the price of the item
     */
    public void setPrice(int price){
        itemPrice = price;
    }

    /**
     * Retrieves the price of an item
     * @return itemPrice the price of the item
     */
    public int getPrice(){
        return itemPrice;
    } 

    /**
     * Sets the quantity of the item
     * @param quantity determinesd the item quantity
     */
    public void setQuantity(int quantity){
        itemQuantity = quantity;
    }

    /**
     * Retrieves the quantity of an item
     * @return itemQuantity the quantity of the item
     */
    public int getQuantity(){
        return itemQuantity;
    }
}