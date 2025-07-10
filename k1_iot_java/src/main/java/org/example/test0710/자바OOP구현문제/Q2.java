package org.example.test0710.자바OOP구현문제;

class Person{
    private String name;
    private int age;

    void info(){
        System.out.println("이름: "+name+ ", 나이: "+age);
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if(age<0){
            System.out.println("잘못된 나이 입니다.");
        }else{
            this.age = age;
        }
    }
}
public class Q2 {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        p1.setName("asd");
        p1.setAge(15);
        p1.info();
        p2.setName("qwe");
        p2.setAge(-5);
        p2.info();

    }
}
