package generic.ex2;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;


public class AnimalMain1 {
    public static void main(String[] args) {
        Animal animal = new Animal("동물", 0);
        Dog dog = new Dog("강아지", 10);
        Cat cat = new Cat("고양이", 10);

        Box<Dog> dogBox = new Box<>();
        dogBox.set(dog);
        Dog findDog = dogBox.get();
        System.out.println("findDog = " + findDog);
        System.out.println("------------------------");

        Box<Cat> catBox = new Box<>();
        catBox.set(cat);
        Cat findCat = catBox.get();
        System.out.println("findCat = " + findCat);
        System.out.println("------------------------");

        Box<Animal> animalBox = new Box<>();
        animalBox.set(animal);
        animalBox.set(dog);
        animalBox.set(cat);
        Animal findAnimal = animalBox.get();
        System.out.println("findAnimal = " + findAnimal);



    }
}
