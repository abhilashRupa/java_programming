package com.oops.inheritance;

public class AnimalMain {

    public static void main(String[] args) {
        Animal animal = (Cat) new Cat();
        animal.eat();
        Cat cat1 = (Cat) animal;
        cat1.eat();

//        Cat cat2 = (Cat) new Animal(); class cast exception





    }
}
