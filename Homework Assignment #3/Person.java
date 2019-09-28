/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #3
 * Program: Person
 */
public class Person{
    private String name;
    private String address;
    
    /**
     * Initialize a new instance of Person with a name and address
     * @param name defines the name of the Person
     * @param address declares the address of the person
     */
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }
    
    /**
     * Return the name of a person object
     * @return name the name of the person
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Return the address of the person
     * @return address the address of the person
     */
    public String getAddress(){
        return this.address;
    }
    
    /**
     * Edit the address of a person
     * @param address the address of the person
     */
    public void setAddress(String address){
        this.address = address;
    }
    
    /**
     * Print the person object as a string showing name and address
     * @return the name of the person followed by their address
     */
    public String toString(){
        return this.name + "(" + this.address + ")";
    }
}