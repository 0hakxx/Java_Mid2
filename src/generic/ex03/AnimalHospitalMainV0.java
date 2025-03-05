package generic.ex03;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV0 {
    public static void main(String[] args) {
        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();

        Dog dog = new Dog("허스키",100);
        Cat cat = new Cat("검은고양이",50);


        //개 병원
        dogHospital.set(dog);
        dogHospital.Checkup();

        //고양이 병원
        catHospital.set(cat);
        catHospital.Checkup();

        // 문제1: 개 병원에 고양이 전달
        // dogHospital.set(cat); // 다른 타입 입력: 컴파일 오류
        // 문제2: 개 타입 반환
        dogHospital.set(dog);
        Dog biggerDog = dogHospital.bigger(new Dog("멍멍이2", 200));
        System.out.println("biggerDog = " + biggerDog);




    }
}
