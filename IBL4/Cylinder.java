/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * IBL4
 * Program: Cylinder
 */
public class Cylinder extends Circle{
    private double height;
    public Cylinder(){
        super();
        this.height = 1;
    }
    
    public Cylinder(double height){
        super();
        this.height = height;
    }
    
    public Cylinder(double height, double radius){
        super(radius);
        this.height = height;
    }
    
    public Cylinder(double height, double radius, String Color){
        super(radius, Color);
        this.height = height;
    }
    
    public double getHeight(){
        return this.height;
    }
    
    public void setHeight(double height){
        this.height = height;
    }
    
    public String toString(){
        return "Cylinder[ height: " + height + ",radius: " + super.getRadius() + ",color: " + super.getColor();
    }
    
    public double getVolume(){
        return super.getArea() * this.getHeight();
    }
}