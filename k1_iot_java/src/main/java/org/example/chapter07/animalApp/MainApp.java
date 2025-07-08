package org.example.chapter07.animalApp;

import java.util.ArrayList;

//==동물 관리 시스템 ==
public class MainApp {
    public static void main(String[] args) {
        // == 서비스 계층(실행) 생성
        // : service 객체의 handleAnimal 메서드는 Animal 타입의 객체를 인자로 바등ㅁ
        AnimalService service = new AnimalService();

        //동물을 관리하는 List 생성
        // : 객체 타입을 저장할 수 있는 ArrayList
        ArrayList<Animal> animals = new ArrayList<>();

        //동적 배열에 객체 추가
        // : Animal 타입에 Cat/Dog 객체 추가
        animals.add(new Cat()); // 객체 생성과 동시에 업캐스팅(자동타입 변환)
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Cat());

        //배열의 모든 동물을 service 에 전달하여 출력
        for(Animal animal: animals){
            if(animal instanceof Cat){
                System.out.println("고양이가 있다.");
                Cat cat = (Cat)animal; // 다운캐스팅
                cat.eat(); // 자식 클래스가 가지는 고유한 메서드에 대해 접근 가능
            }
            service.handleAnimal(animal);
        }
        //객체 생성 및 처리
        Animal cat = new Cat();
        Animal dog = new Dog();

        service.handleAnimal(cat);
        service.handleAnimal(dog);

        //cat.eat();
        System.out.println("for use cat.eat");
        if(cat instanceof Cat){
            Cat onlyCat = (Cat) cat;
            onlyCat.eat();
        }
        System.out.println("====================");
        if(dog instanceof Cat){ // false(조건문 안의 구문이 실행되지 않음)
            Cat dogCat = (Cat)  dog;
            dogCat.eat();
            System.out.println("강아지는 고양이의 인스턴스가 아니기 때문에 출력 x");
        }

    }
}
