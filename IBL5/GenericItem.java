public class GenericItem{
    public void setName(String newName){
        this.itemName = newName;
    }

    public void setQuantity(int newQty){
        this.itemQuantity = newQty;
    }

    public void printItem(){
        System.out.println("Item: " + this.itemName + " Quantity: " + this.itemQuantity);
    }

    protected String itemName;
    protected int itemQuantity;
}