public class ProduceItem extends GenericItem{
    public void setExpiration(String newDate){
        this.expirationDate = newDate;
    }

    public String getExpiration(){
        return this.expirationDate;
    }

    @Override
    public void printItem(){
        System.out.println("Item: " + super.itemName + " Quantity: " + super.itemQuantity + " Expiration: " + this.getExpiration());
    }
    
    private String expirationDate;
}