/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #4
 * Program: Circle
 * This program defines the Circle class and metods
 */
public class Circle extends Shape{
    protected double radius;
    
    /**
     * Creates a new instance of a Circle with a default radius of 0, no color, and not filled
     */
    public Circle(){
        this(0, " ", false);
    }
    
    /**
     * Creates a new instance of a Circle with no color and not filled
     * @param radius the radius of the Circle
     */
    public Circle(double radius){
        this(radius, " ", false);
    }
    
    /**
     * Creates a new instance of a Circle
     * @param radius the radius of the Circle
     * @param color the color of the Circle
     * @param filled whether or not the Circle is filled
     */
    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }
    
    /**
     * Retrieves the radius of the Circle
     * @return this.radius the radius of the Circle
     */
    public double getRadius(){
        return this.radius;
    }
    
    /**
     * Sets the radius of the Circle
     * @param radius the new radius
     */
    public void setRadius(double radius){
        this.radius = radius;
    }
    
    /**
     * Calculates the area of the Circle
     * @return area the area of the circle
     * @Override
     */
    public double getArea(){
        double area = Math.PI * this.radius * this.radius;
        return area;
    }
    
    /**
     * Calculates the Perimeter of the Circle
     * @return perimeter the perimeter of the Circle
     * @Override
     */
    public double getPerimeter(){
        double perimeter = 2 * Math.PI * this.radius;
        return perimeter;
    }
    
    /**
     * Returns the Circle as a String
     * @return circle the Circle as a String
     * @Override
     */
    public String toString(){
        String circle = "Circle:\nRadius: " + this.getRadius() + "\nArea: " + this.getArea() + "\nPerimeter: " + this.getPerimeter();
        return circle;
    }
}