/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #4
 * Program: TestShapes
 * This program tests Shape and all of its subclasses utilizing polymorphism
 */
public class TestShapes{
    /**
     * Tests Shape and all of its Child Classes
     * @param args arguments
     */
    public static void main(String[] args){
        //Legal implicit casting
        Shape s1 = new Circle(5.5, "RED", false);
        //Output: Circle:\nRadius: 5.5\n Area: 95.03\n Perimeter: 34.558, Invokes the overridden toString method in the Circle class because the actual type of the object is Circle
        System.out.println(s1);
        //Output: 95.03, Invokes the overridden getArea method in the Circle class because the actual type of the object is Circle
        System.out.println(s1.getArea());
        //Output: 34.558, Invokes the overridden getPerimeter method in the Circle class because the actual type of the object is Circle
        System.out.println(s1.getPerimeter());
        //Output: RED, Invokes the getColor method from the Shape class because the declared type of the object is Shape and there is no overriden getColor method in the Circle class
        System.out.println(s1.getColor());
        //Output: false, Invokes the isFilled method from the Shape class because the declared type of the object is Shape and there is no overriden isFilled method in the Circle class
        System.out.println(s1.isFilled());
        //This code will not run because the declared type of s1 is shape, so it can only use methods explicitly declared by Shape. Since its actual type is Circle, it will be able to use Circle's overridden methods of shape, but not its other methods. getRadius() is one of the other methods, not overriden
        //System.out.println(s1.getRadius());

        //Legal casting
        Circle c1 = (Circle)s1;
        //Output: Circle:\nRadius: 5.5\n Area: 95.03\n Perimeter: 34.558, Invokes the toString method in the Circle class because the object is of declared and actual type Circle
        System.out.println(c1);
        //Output: 95.03, Invokes the getArea method in the Circle class because the actual and declared type of the object is Circle
        System.out.println(c1.getArea());
        //Output: 34.558, Invokes the getArea method in the Circle class because the actual and declared type of the object is Circle
        System.out.println(c1.getPerimeter());
        //Output: RED, Invokes the getColor method which it inherits from the Shape class
        System.out.println(c1.getColor());
        //Output: false, Invokes the isFilled method which it inherits from the Shape class
        System.out.println(c1.isFilled());
        //Output: 5.5, Invokes the getRadius method in the Circle class because the actual and declared type of the object is Circle
        System.out.println(c1.getRadius());

        Shape s2 = new Shape();

        //Legal implicit casting
        Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
        //Output: Rectangle:\nLength: 2.0\n Width: 1.0\n Area: 2\n Perimeter: 6, Invokes the overridden toString method in the Rectangle class because the actual type of the object is Rectangle
        System.out.println(s3);
        //Output: 2.0, Invokes the overridden getArea method in the Rectangle class because the actual type of the object is Rectangle
        System.out.println(s3.getArea());
        //Output: 6.0, Invokes the overridden getPerimeter method in the Rectangle class because the actual type of the object is Rectangle
        System.out.println(s3.getPerimeter());
        //Output: RED, Invokes the getColor method which it inherits from the Shape class
        System.out.println(s3.getColor());
        //This code will not run because the declared type of s3 is shape, so it can only use methods explicitly declared by Shape. Since its actual type is Rectangle, it will be able to use Rectangle's overridden methods of shape, but not its other methods. getLength() is one of the other methods, not overriden
        //System.out.println(s3.getLength());

        //Legal casting
        Rectangle r1 = (Rectangle)s3;
        //Output: Rectangle:\nLength: 2.0\n Width: 1.0\n Area: 2\n Perimeter: 6, Invokes the toString method in the Rectangle class because the actual and declared type of the object are Rectangle
        System.out.println(r1);
        //Output: 2.0, Invokes the getArea method from the Rectangle class because the object is of declared and actual type Rectangle
        System.out.println(r1.getArea());
        //Output: RED, Invokes the getColor method which it inherits from the Shape class
        System.out.println(r1.getColor());
        //Output: 2.0, Invokes the getLength method from the Rectangle class because the object is of actual and declared type Rectangle
        System.out.println(r1.getLength());

        //Legal implicit casting
        Shape s4 = new Square(6.6);
        //Output: Square:\n Side: 6.6\n Area: 43.56\n Perimeter: 26.4, Invokes the overridden toString method from the Square class because the actual type of the object is Square
        System.out.println(s4);
        //Output: 43.56, Invokes the overriden getArea method from the Square class because the actual type of the object is Square
        System.out.println(s4.getArea());
        //Output: "", Invokes the getColor method which it inherits from the Shape class. No color is declared in the constructor, so the default color is blank
        System.out.println(s4.getColor());
        //This code will not run because the declared type of s4 is shape, so it can only use methods explicitly declared by Shape. Since its actual type is Square, it will be able to use Square's overridden methods of shape, but not its other methods. getSide() is one of the other methods, not overriden
        //System.out.println(s4.getSide());

        //Legal Casting
        Rectangle r2 = (Rectangle)s4;
        //Output: Square:\n Side: 6.6\n Area: 43.56\n Perimeter: 26.4, Invokes the overridden toString method from the Square class because the actual type of the object is still Square. All that changed was the declared type became Rectangle
        System.out.println(r2);
        //Output: 43.56, Invokes the getArea method from the Square class because even though the declared type is Rectngle, the actual type is Square
        System.out.println(r2.getArea());
        //Output: "", Invokes the inherited getColor method from the Shape class. Because no color is ever declared, it defaults to blank
        System.out.println(r2.getColor());
        //This code will not run because the object is of declared and actual type Rectangle, whoch does not have access to the methods of its child class Square, which getSide() is.
        //System.out.println(r2.getSide());
        //Output: 6.6, Invokes the getLength method from the Rectangle class because the declared type is Rectangle and it is not overridden in Square
        System.out.println(r2.getLength());

        //Legal casting
        Square sq1 =(Square)r2;
        //Output: Square:\n Side: 6.6\n Area: 43.56\n Perimeter: 26.4, Invokes the toString method fromSquare because the actual and declared type of the object is Square
        System.out.println(sq1);
        //Output: 43.56, Invokes the getArea method from the Square class because the actual and declared type of the object is Square
        System.out.println(sq1.getArea());
        //Output: "", Invokes the getColor method which it inherits from the Shape class. No color is declared in the constructor, so the default color is blank
        System.out.println(sq1.getColor());
        //Output: 6.6, Invokes the getSide method from the Square class because the object is of actual and declared type Square
        System.out.println(sq1.getSide());
        //Output: 6.6, Invokes the getLength method which it inherits from the Rectangle class
        System.out.println(sq1.getLength());
    }
}