/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * IBL7
 * Program: TestAnimal
 */
public class TestAnimal {
    public static void main(String[] args) {
        // Using the Subclasses
        Cat cat1 = new Cat();
        cat1.greeting(); // greeting() is called in Cat class because actual and declared type is of Cat
        Dog dog1 = new Dog();
        dog1.greeting(); // greeting() is called in Dog class because actual and declared type is of Dog
        BigDog bigDog1 = new BigDog();
        bigDog1.greeting(); // greeting() is called in BigDog class because actual and declared type is of
                            // BigDog

        // Using Polymorphism
        Animal animal1 = new Cat();
        animal1.greeting(); // greeting() is called in Cat class because actual type is of Cat
        Animal animal2 = new Dog();
        animal2.greeting(); // greeting() is called in Dog class because actual type is of Dog
        Animal animal3 = new BigDog();
        animal3.greeting(); // greeting() is called in BigDog class because actual type is of BigDog
        // Animal animal4 = new Animal(); Because Animal is an abstract class, it cannot
        // be instantiated

        // Downcast
        Dog dog2 = (Dog) animal2;
        BigDog bigDog2 = (BigDog) animal3;
        Dog dog3 = (Dog) animal3;
        // Cat cat2 = (Cat) animal2; animal2 has an actual type of Dog. Dog and Cat are
        // both subclasses of Cat, and are therefore not related, so animal2 with actual
        // type dog cannot be cast to Cat
        dog2.greeting(dog3); // greeting(Dog another) is called in Dog class because actual type of dog2 is
                             // of Dog
        dog3.greeting(dog2); // greeting(Dog another) is called in BigDog class because actual type of dog3
                             // is of BigDog
        dog2.greeting(bigDog2); // greeting(Dog another) is called in Dog class because actual type of dog2 is
                                // of Dog
        bigDog2.greeting(dog2); // greeting(Dog another) is called in BigDog class because actual type of
                                // bigDog2
                                // is of BigDog
        bigDog2.greeting(bigDog1); // greeting(Dog another) is called in BigDog class because actual type of
                                   // bigDog2
                                   // is of BigDog
    }
}