/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #4
 * Program: Square
 * This program defines the Square class and methods
 */
public class Square extends Rectangle{
    /**
     * Creates a new instance of a Square object with a default side length of 0, no color, and not filled
     */
    public Square(){
        this(0, " ", false);
    }
    
    /**
     * Creates a new instance of a Square object with no color, and not filled
     * @param side the length of one of the sides
     */
    public Square (double side){
        this(side, " ", false);
    }
    
    /**
     * Creates a new instance of a Square object
     * @param side the length of one of the sides
     * @param color the color of the square
     * @param filled whether or not the square is filled
     */
    public Square(double side, String color, boolean filled){
        super(side, side, color, filled);
    }
    
    /**
     * Returns the length of the side of a square
     * @return super.length the length of the side
     */
    public double getSide(){
        return super.length;
    }
    
    /**
     * Sets the length of the sides
     * @param side the new length of the sides
     */
    public void setSide(double side){
        this.setWidth(side);
        this.setLength(side);
    }
    
    /**
     * Sets the width of the square
     * @param side the length of the width
     * @Override
     */
    public void setWidth(double side){
        super.width = side;
    }
    
    /**
     * Sets the length of the square
     * @param side the length of the length
     * @Override
     */
    public void setLength(double side){
        super.length = side;
    }
    
    /**
     * Returns the square object as a String
     * @return square the square as a string
     * @Override
     */
    public String toString(){
        String square = "Square:\nSide: " + this.getSide() + "\nArea: " + this.getArea() + "\nPerimeter: " + this.getPerimeter(); ;
        return square;
    }
}