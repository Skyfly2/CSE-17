/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * IBL7
 * Program: BigDog
 */
public class BigDog extends Dog {
    public void greeting() {
        System.out.println("Big Dog's Greeting of No Parameters");
    }

    public void greeting(Dog another) {
        System.out.println("Big Dog's Greeting of One Parameter");
    }
}