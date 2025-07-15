package org.example.chapter13;

/*
 * === 빌터(Builder) 패턴
 * : 소프트웨서 설계 패턴 중 하나
 * - 객체 생성 방법
 * - 복잡한 객체를 단계별로만들 때 사용
 * - 필드(속성) 가 많거나, 필드에 필수값과 선택값이 섞여 있을때 유용
 * 1. 사용목적
 *  : 생성자가 너무 많아질때
 *  : 코드가 복잡하고 읽기 어려울때
 *
 * 2. 장단점
 *  1) 장점: 가독성 향상, 유연성 증가, 확장성 용이
 *  2) 단점: 구현 복잡성 증가, 작은 객체 부적합
 *
 * 3. 동작원리
 *  1) 객체 생성 시 필요한 데이터를 저장하는 Builder 클래스를 생성
 *  2) Builder  클래스는 원하는 속성을 단계별로 설정할 수 있는 메서드를 제공
 *  3) build() 메서드 호출하여 객체 생성
 *
 * 4. 빌더 사용방법
 */
class Pizza {
    //필수사항

    private final String menu;
    private final String size;

    //선택사항
    private final boolean cheese;
    private final boolean mushroom;
    private final boolean pepperoni;


    /*
    public Pizza(String menu, String size) {
        this.menu = menu;
        this.size = size;
        this.cheese = false;
        this.mushroom = false;
        this.pepperoni = false;
    }
    public Pizza(String menu, String size, boolean cheese, boolean mushroom, boolean pepperoni) {
        this.menu = menu;
        this.size = size;
        this.cheese = cheese;
        this.mushroom = mushroom;
        this.pepperoni = pepperoni;
    }
     */

    //1) Builder 클래스 정의(Pizza 클래스 내부의 클래스)
    public static class Builder {
        //static : pizza 클래스가 인스턴스화 되지 않을 때 내부 Builder 클래스로 인스턴스화 진행
        // 외부클래스명.내부클래스명();
        //필수 필드
        private final String menu;
        private final String size;

        // 선택필드: 기본값 설정(선택하지 않으면 해당 값으로 출력)
        private boolean cheese = false;
        private boolean mushroom = false;
        private boolean pepperoni = false;

        //필수 값 초기화;
        public Builder(String menu, String size) {
            this.menu = menu;
            this.size = size;
        }

        //선택값 지정 메서드
        public Builder addCheese() {
            this.cheese = true;
            return this; // 해당 클래스 타입의 객체 그 자체
        }

        public Builder addMushroom() {
            this.mushroom = true;
            return this;
        }

        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        //Builder 객체를 생성하는 builder 메서드
        // : 인스턴스 메서드 - 인스턴스.메서드명()
        public Pizza build() {
            return new Pizza(this);
        }
    }

    private Pizza(Builder builder) {
        this.menu = builder.menu;
        this.size = builder.size;
        //  add~() 메서드 호줄 하지 않아도 기본값 false  지정
        this.cheese = builder.cheese;
        this.mushroom = builder.mushroom;
        this.pepperoni = builder.pepperoni;
    }

    @Override
    public String toString() {
        return "메뉴: " + menu
                + ", 사이즈: " + size
                + ", 치즈 선택: " + cheese
                + ", 버섯 선택: " + mushroom
                + ", 페페로니 선택: " + pepperoni;
    }
}


public class E_Builder {
    public static void main(String[] args) {
        // Pizza noBuilderPizza = new Pizza("파인애플 피자", "L", false, false, false);
        Pizza builderPizza = new Pizza.Builder("고구마피자", "M").build();

        Pizza optionalPizza1 = new Pizza.Builder("포테이토 피자", "s") // Builder 인스턴스 생성
                .addCheese() // Builder 인스턴스 메서드  - 반환 Builder
                .addMushroom()// Builder 인스턴스 메서드  - 반환 Builder
                .build();// Builder 인스턴스 메서드  - 반환 Pizza
        Pizza optionalPizza2 = new Pizza.Builder("쉬림프 피자", "L")
                .addPepperoni()
                .build();
        // cf) 메서드 체이닝
        //  : 메서드 호출 뒤 반환되는 데이터에 곧바로 추가 메서드를 호출
        //  - 객체를 연결고리 메서드(함수)를 지속적으로 호출

        System.out.println(builderPizza);
        System.out.println(optionalPizza1);
        System.out.println(optionalPizza2);
    }
}
