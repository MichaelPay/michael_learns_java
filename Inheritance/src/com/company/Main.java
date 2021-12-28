package com.company;

public class Main {

    public static void main(String[] args) {
	Object[] list = {new Dog(), new DogFood()};
    Dog dog = (Dog)list[0];
    dog.makeSound();
    }
}

class Animal {
    String sound = "";
    void makeSound() {
        System.out.println(sound);
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getClass().getSimpleName() + ": sound = " + sound;
    }
    
    
}

class Dog extends Animal {
    Dog() {
        sound = "Barksss";
    }
}

class DogFood {}