/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #5
 * Program ResizableCircle
 */
public class ResizableCircle extends Circle implements Resizable {
    /**
     * Creates a new instance of ResizableCircle
     * 
     * @param radius
     */
    public ResizableCircle(double radius) {
        super(radius);
    }

    /**
     * Resizes a resizable circle by a specified percentage
     * 
     * @param percent the percentage to be resized
     * @Override from Resizable interface
     */
    public double resize(int percent) {
        double newsize = (double) percent * this.radius * .01;
        this.radius = newsize;
        return newsize;
    }
}