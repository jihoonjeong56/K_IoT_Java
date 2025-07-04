package org.example.chapter04;

class Person{
    String name;
    int age;
    static int population;

    Person(){
        population++;
    }

    void introduce(){
        System.out.println("안녕하세요, 저는 ["+name+"] 이고, ["+age+"]살 입니다.");
    }
    Person(String name, int age){
        this.name = name;
        this.age = age;
        population++;
    }
}
public class G_Practice {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동", 25);
        p1.introduce();

        System.out.println(Person.population);

        new Person();
        new Person();
        new Person();
        new Person();
        new Person();

        System.out.println(Person.population);
    }
}
