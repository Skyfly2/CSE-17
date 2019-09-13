/** IBL2
 * 9/6/2019
@author Asher Hamrick*/
public class Store{
    private static int nextId;
    private String name;
    private String type;
    private int id;
    Store(String storeName, String storeType){
        name = storeName;
        type = storeType;
        id = nextId;
        nextId++;
    }
    public int getId(){
        return id;
    }
    public static int getNextId(){
        return nextId;
    }
}