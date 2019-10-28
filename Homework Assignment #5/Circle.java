
/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #5
 * Program: Circle
 */
import java.util.*;

public class Circle implements GeometricObject {
    protected double radius = 1.0;

    /**
     * Creates a new Instance of Circle
     * 
     * @param radius the radius of the circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Determines the perimeter of a Circle object
     * 
     * @return perimeter the perimeter of the circle
     * @Override
     */
    public double getPerimeter() {
        double perimeter = this.radius * 2 * Math.PI;
        return perimeter;
    }

    /**
     * Determines the area of a Circle object
     * 
     * @return area the area of the circle
     * @Override
     */
    public double getArea() {
        double area = Math.pow(this.radius, 2) * Math.PI;
        return area;
    }
}