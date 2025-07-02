package org.example.chapter01;

import java.sql.SQLOutput;

public class H_Operator {
    public static void main(String[] args) {
        // === 연산자 (Operator) ===
        // : 프로그램에서 데이터를 조작하거나 계산

        System.out.println("===산술연산자===");
        //사칙연산(덧셈, 뺄셈, 곱셈, 나눗셈)
        int a = 10;
        int b = 20;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b); // 나눈결과의 몫
        System.out.println(a % b); // 나눈결과의 나머지

        System.out.println("===증감연산자===");
        // :변수의 값을 1 증가(++), 1 감소(--)시키는 연산자.
        int num = 10;
        //1)전위 증감 연산자.
        // : 값이 먼저 변경되고 나서 계산에 적용
        // : ++변수명, --변수명
        System.out.println("전위증감");
        System.out.println(++num);//11
        System.out.println(--num);//10
        System.out.println("------------");

        //2)후위 증감 연산자.
        // : 값이 계산된 이후 변경
        // : 변수명 ++, 변수명 --
        System.out.println("후위증감");
        System.out.println(num);//10
        System.out.println(num++);//10출력후 1증가
        System.out.println(num--);//11출력후 1감소
        System.out.println(num); //10

        num++;//11
        num++;//12
        ++num;//13
        --num;//12
        num--;//11
        num++;//12
        System.out.println(num);//12

        System.out.println("===할당연산자===");
        // : 변수의 값을 할당할 때 사용하는 연산자.
        //기본 연산자(=), 사칙연산과 결합된 연산(+=, -=, *=, /=, %=)
        num = 10;//대입연산자 -> 10 재할당
        //해당갑의 연산 후 다시 변수에 할당
        System.out.println(num += 3);// num + 3의 결과를 num 에 할당 num = num + 3
        System.out.println(num -= 3);// num = num - 3
        System.out.println(num *= 3);// num = num * 3
        System.out.println(num /= 3);// num = num / 3
        System.out.println(num %= 3);// num = num % 3

        System.out.println("===비교연산자===");
        // 좌항과 우항ㅇ을 비교한 결과를 논리(boolean) 값으로 반환
        //<,>, <=, >=, == !=
        System.out.println(5 > 3);//true
        System.out.println(5 < 3); //false
        System.out.println(5 >= 3);//true
        System.out.println(5 <= 3);//false
        System.out.println(5 == 3);//false
        System.out.println(5 != 3);//true

        System.out.println("===논리연산자.===");
        //논리값(boolean)을 연산

        //&(엔퍼센트), |(버티컬바 vertical bar)
        //1) 논리곱(AND, &&)
        // : 모든 값이 true면 true의 결과
        // : 하나의 값이 false면 false의 결과
        System.out.println("논리곱 AND");
        System.out.println(true && true && true); //true
        System.out.println(true && true && true && false && true && true); //false
        //2) 논리합(OR, ||)
        // : 하나라도 true면 true의 결과
        // : 둘다 false면 false의 결과
        System.out.println("논리합 OR");
        System.out.println(true || true); //true
        System.out.println(true || true || false || false || false); //true
        System.out.println(false || false|| false|| false|| false|| false|| false); //false

        //3)부정논리(!)
        // : 논리값을 전환
        // - 논리값 앞에!키워드를 사용하여 작성.
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println("부정논리");
        System.out.println(!bool1);
        System.out.println(!bool2);

        System.out.println( 3>2 && 1 ==1); //true
        System.out.println( 1 != 1);//false
        System.out.println( 3>=3 || 10<11 && !bool2);//true


        System.out.println("===조건 3항 연산자===");
        // 조건식(논리의 값이 반환) ? 조건식이 참인경우 반환 : 조건식이 거짓인경우 반환

        int age = 20;
        String drink = age > 19 ? "맥주" : "오렌지 주스";
        System.out.println(drink + "를 마십니다.");

        int x = 10, y = 2; //변수의 데이터 타입이 같은경우, 콤마로 구분가능
        System.out.println(x % y == 0 ? "2의 배수입니다." : "2의배수가 아닙니다.");

        System.out.println("===기타연산자===");
        //문자열 연결 연사자 +
        String result = "정" + "지훈";
        System.out.println(result);

        //cf)연산자의 우선순위
        // : (기본) 좌측 >> 우측
        //      그러나, 대입연산자의 경우 ㅇ우항에서 좌항의 대입이 이루어짐
        //      ()괄호 연산자는 우선순위를 가짐



    }
}
