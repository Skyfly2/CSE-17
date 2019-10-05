/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #4
 * Program: Shape
 * This program defines the Shape class and methods
 */
public class Shape{
    protected String color;
    protected boolean filled;
    
    /**
     * Creates a new instance of Shape with no color and not filled
     */
    public Shape(){
        this(" ", false);
    }
    
    /**
     * Creates a new instance of Shape
     * @param color the color of the Shape
     * @param filled whether or not the Shape is filled
     */
    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }
    
    /**
     * Retrieves the Color of the Shape
     * @return this.color the coor of the Shape
     */
    public String getColor(){
        return this.color;
    }
    
    /**
     * Sets the color of the Shape
     * @param color the new color of the Shape
     */
    public void setColor(String color){
        this.color = color;
    }
    
    /**
     * Determines whether or not the Shape is filled
     * @return this.filled whether or not the Shape is filled
     */
    public boolean isFilled(){
        return this.filled;
    }
    
    /**
     * Sets whether the Shape is filled or not
     * @param filled whether the Shape will be filled
     */
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    
    /**
     * Calculate area of the Shape. meant to be Overridden
     * @return -1
     */
    public double getArea(){
        return -1;
    }
    
    /**
     * Calculate the perimeter of the Shape. Meant to be Overridden
     * @return -1
     */
    public double getPerimeter(){
        return -1;
    }
    
    /**
     * Return the Shape as a String
     * @return shape the Shape as a String
     * @Override
     */
    public String toString(){
        String shape = "Shape:\nColor: " + this.getColor() + "\nFilled: " + this.isFilled();
        return shape;
    }
}