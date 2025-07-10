package org.example.test0710.자바OOP구현문제;
class Animal{
    String name;
    void makeSound(){
        System.out.println("동물은 울음소리를 냅니다.");
    }
}
class Dog extends Animal{
    public Dog(String name) {
        this.name = name;
    }
    @Override
    void makeSound() {
        System.out.println("멍멍");
    }
}
class Cat extends Animal{
    public Cat(String name) {
        this.name = name;
    }

    @Override
    void makeSound() {
        System.out.println("야옹");
    }
}
public class Q1 {
    public static void main(String[] args) {
        Dog dog = new Dog("강아지");
        Cat cat = new Cat("고양이");
        Animal[] animals;
        animals = new Animal[]{ dog,cat

        };
        for (Animal animal: animals){
            System.out.println(animal.name);
            animal.makeSound();

        }
    }
}
