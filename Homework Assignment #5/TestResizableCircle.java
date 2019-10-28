
/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #5
 * Program TestResizableCircle
 */
import java.util.*;

public class TestResizableCircle {
    /**
     * Test the ResizableCircle methods
     * 
     * @param args arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the radius for a Resizable to be cast to a Resizable Circle: ");
        double rad = scan.nextDouble();
        // Polymorphism
        Resizable c1 = new ResizableCircle(rad);
        System.out.println("Current radius: " + rad);
        System.out.println("Enter percentage to resize radius by: ");
        int percent = scan.nextInt();
        ResizableCircle c2 = (ResizableCircle) c1;
        System.out.println("The new radius of the Resizable cast to ResizableCircle is " + c2.resize(percent));
        System.out.println(("Enter the radius for a ResizableCircle: "));
        double rad2 = scan.nextDouble();
        // Regular Resizable Circle
        ResizableCircle c3 = new ResizableCircle(rad2);
        System.out.println("Area: " + c3.getArea());
        System.out.println("Perimeter: " + c3.getPerimeter());
        System.out.println("Current Radius: " + c3.radius);
        System.out.println("Enter percentage to resize radius by: ");
        percent = scan.nextInt();
        System.out.println("New radius size: " + c3.resize(percent));
        System.out.println("New Area: " + c3.getArea());
        System.out.println("New Perimeter: " + c3.getPerimeter());
    }
}