package generic.ex04;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class MethodMain2 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("강아지", 150);
        Dog dog2 = new Dog("허스키", 200);

        Cat cat = new Cat("고양이", 50);



        AnimalMethod.checkup(dog1); //==AnimalMethod.<Dog>checkup(dog1);
        AnimalMethod.checkup(cat);

        System.out.println(AnimalMethod.getBigger(dog1, dog2));



    }
}
