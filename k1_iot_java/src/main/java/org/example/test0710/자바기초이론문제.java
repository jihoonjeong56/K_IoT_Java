package org.example.test0710;

public class 자바기초이론문제 {
}
/*
 Q1. 다음 중 같은 패키지 내에서는 접근 가능한 접근 제어자가 아닌 것은?
- (A) public
- (B) protected
- (C) default
- (D) private

Answer: (D) private

 Q2. static 키워드에 대한 설명으로 틀린 것은?

- (A) static 변수는 클래스에 한 개만 존재한다.
- (B) static 메서드는 인스턴스를 생성하지 않아도 호출할 수 있다.
- (C) static 메서드 내에서는 this 키워드를 사용할 수 있다.
- (D) static 변수는 모든 인스턴스가 공유한다.

Answer: (A) static 변수는 클래스에 한 개만 존재한다.

 Q3. 다음 중 static 중첩 클래스의 특징으로 올바른 것은?

- (A) 외부 클래스의 인스턴스가 있어야 생성 가능하다.
- (B) 일반 클래스와 동일하게 선언된다.
- (C) 외부 클래스의 private 멤버에 직접 접근할 수 있다.
- (D) 외부 클래스의 인스턴스 없이도 생성 가능하다.

Answer: (A) 외부 클래스의 인스턴스가 있어야 생성 가능하다.

 Q4. 다음 중 final 키워드의 특성으로 옳지 않은 것은?

- (A) final 변수는 값이 한 번 지정되면 변경할 수 없다.
- (B) final 메서드는 하위 클래스에서 오버라이딩할 수 있다.
- (C) final 클래스는 상속할 수 없다.
- (D) final 키워드는 상수, 메서드, 클래스에 모두 사용될 수 있다.

Answer: (B) final 메서드는 하위 클래스에서 오버라이딩할 수 있다.

 Q6. 오버로딩과 오버라이딩에 대한 설명 중 올바른 것은?

- (A) 오버로딩은 상속 관계에서만 발생한다.
- (B) 오버라이딩은 메서드 이름은 같지만 매개변수가 달라야 한다.
- (C) 오버로딩은 같은 클래스 내에서 메서드 이름은 같지만 매개변수가 달라야 한다.
- (D) 오버라이딩은 메서드 이름과 매개변수 모두 달라야 한다.

Answer: (A) 오버로딩은 상속 관계에서만 발생한다.

 Q7. abstract 클래스에 대한 설명으로 올바른 것은?

- (A) 객체 생성이 가능하다.
- (B) 모든 메서드는 abstract이어야 한다.
- (C) 추상 메서드를 포함할 수 있다.
- (D) abstract 클래스는 반드시 final이어야 한다.

Answer: (C) 추상 메서드를 포함할 수 있다.

 Q8. 인터페이스(interface)와 추상 클래스(abstract class)의 차이로 옳은 것은?

- (A) 인터페이스는 인스턴스 필드를 가질 수 있다.
- (B) 추상 클래스는 다중 상속이 가능하다.
- (C) 인터페이스는 오직 추상 메서드만 가질 수 있다 (Java 8 이전 기준).
- (D) 추상 클래스는 implements로 구현한다.

Answer: (B) 추상 클래스는 다중 상속이 가능하다.

 Q9. 다음 코드 중 컴파일 에러가 발생하는 부분은?

```java
interface A {
    void doSomething();
}

abstract class B {
    abstract void doAnotherThing();
}

class C extends A {
    public void doSomething() {
        System.out.println("Doing something...");
    }
}
```

- (A) interface A 정의
- (B) abstract class B 정의
- (C) class C 정의
- (D) class C가 interface를 상속하려 할 때 발생

Answer: (D) class C가 interface를 상속하려 할 때 발생

 Q10. 다음 중 finally 블록에 대한 설명으로 틀린 것은?

- (A) 예외가 발생하지 않아도 실행된다.
- (B) try 블록에서 return이 있어도 finally는 실행된다.
- (C) finally 블록은 선택적으로 사용할 수 있다.
- (D) catch 블록보다 먼저 실행된다.

Answer: (D) catch 블록보다 먼저 실행된다.

Q11. 다음 코드의 출력 결과는?
class A {
    static int count = 0;
    A() {
        count++;
    }
}

public class Main {
    public static void main(String[] args) {
        new A();
        new A();
        System.out.println(A.count);
    }
}

Answer: 2

Q12. 다음 코드에서 오류가 발생하는 이유는?
abstract class Animal {
    abstract void sound();
}

class Dog extends Animal {
    // void sound(String name) { System.out.println("멍멍"); }
}

Answer: 오버라이딩된 메서드에 String name 이라 선언하였기 때문( 메서드에서 this.name = name;사용)
 */