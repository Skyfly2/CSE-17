
/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #5
 * Program TestCircle
 */
import java.util.*;

public class TestCircle {
    /**
     * Test the Circle methods
     * 
     * @param args arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the radius for a Geometric Object to cast to a Circle: ");
        double rad = scan.nextDouble();
        // Polymorphism
        GeometricObject c1 = new Circle(rad);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());
        System.out.println(("Enter the radius for a Circle: "));
        double rad2 = scan.nextDouble();
        // Regular Circle
        Circle c2 = new Circle(rad2);
        System.out.println("Area: " + c2.getArea());
        System.out.println("Perimeter: " + c2.getPerimeter());
    }
}