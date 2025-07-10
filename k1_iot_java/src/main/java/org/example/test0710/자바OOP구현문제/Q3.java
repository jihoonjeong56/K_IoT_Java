package org.example.test0710.자바OOP구현문제;

abstract class Shape{
    abstract double getArea();
}
class Circle extends Shape{
    double a;
    @Override
    double getArea() {

        return a*a*3.14;
    }

    public double getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
class Rectangle extends Shape{
    double a;//가로
    double b;//세로


    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }



    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }



    @Override
    double getArea() {
        return a*b*0.5;
    }
}
public class Q3 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setA(5);
        System.out.println(circle.getArea());
        Rectangle rectangle = new Rectangle();
        rectangle.setA(4);
        rectangle.setB(5);
        System.out.println(rectangle.getArea());
    }
}
