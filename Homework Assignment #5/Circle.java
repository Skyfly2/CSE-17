/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #5
 * Program: Circle
 */
public class Circle implements GeometricObject {
    protected double radius = 1.0;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        double perimeter = this.radius * 2 * MATH.PI;
        return perimeter;
    }

    public double getArea() {
        double area = MATH.pow(this.radius, 2) * MATH.PI;
        return area;
    }
}