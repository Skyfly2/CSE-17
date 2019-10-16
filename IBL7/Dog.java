/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * IBL7
 * Program: Dog
 */
public class Dog extends Animal {
    public void greeting() {
        System.out.println("Dog's Greeting of No Parameters");
    }

    public void greeting(Dog anotherDog) {
        System.out.println("Dog's Greeting of One Parameter");
    }
}