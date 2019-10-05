/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #4
 * Program: Rectangle
 * This program defines the Rectangle class and methods
 */
public class Rectangle extends Shape{
    protected double width;
    protected double length;
    
    /**
     * Creates a new instance of Rectangle with default side values of 0, no color, and not filled
     */
    public Rectangle(){
        this(0, 0, " ", false);
    }

    /**
     * Creates a new instance of Rectangle with no color and not filled
     * @param width the width of the Rectangle
     * @param length the length of the rectangle
     */
    public Rectangle(double width, double length){
        this(width, length, " ", false);
    }

    /**
     * Creates a new instance of a Rectangle
     * @param width the width of the Rectangle
     * @param length the length of the Rectangle
     * @param color the color of the Rectangle
     * @param filled whether or not the Rectangle is filled
     */
    public Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /**
     * Retrieves the width of the Rectangle
     * @return this.width the width of the Rectangle
     */
    public double getWidth(){
        return this.width;
    }

    /**
     * Sets the width of the Rectangle
     * @param width the new width of the rectangle
     */
    public void setWidth(double width){
        this.width = width;
    }

    /**
     * Retrieves the length of the Rectangle
     * @return this.length the length of the Rectangle
     */
    public double getLength(){
        return this.length;
    }

    /**
     * Sets the length of the Rectangle
     * @param length the new length of the Rectangle
     */
    public void setLength(double length){
        this.length = length;
    }

    /**
     * Calculates the area of the Rectangle
     * @return area the area of the Rectangle
     * @Override
     */
    public double getArea(){
        double area = this.length * this.width;
        return area;
    }

    /**
     * Calculates the perimeter of the Rectangle
     * @return perimeter the perimeter of the Rectangle
     * @Override
     */
    public double getPerimeter(){
        double perimeter = (2 * this.length) + (2 * this.width);
        return perimeter;
    }

    /**
     * Return the Rectangle as a String
     * @return rectangle the Rectangle as a String
     * @Override
     */
    public String toString(){
        String rectangle = "Rectangle:\nLength: " + this.getLength() + "\nWidth: " + this.getWidth() + "\nArea: " + this.getArea() + "\nPerimeter: " + this.getPerimeter();
        return rectangle;
    }
}