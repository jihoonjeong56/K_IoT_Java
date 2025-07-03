package org.example.chapter02;

//===반복문(loop)===
// : 특정조건을 만족할 때까지 동일한 작업 반복
// - for(~동안), while(~동안), do-while


public class C_For {
    public static void main(String[] args) {
        /*
            for문
             : 특정 조건이 만족 될 때까지 코드블록을 반복 실행
             >> 횟수를 지정
             >>반복해야 할 횟수가 있을 때

             for(초기화식; 조건식; 증감식) {
                조건이 만족될 때까지 실행할 코드 블록
             }
             1. 초기화식
                : 반복을 시작할 때 사용할 변수를 초기화(반복에 사용할 변수)
             2. 조건식
                : 반복이 실행될 조건을 정의하는 부분(해당 조건이 참인 동안 반복문이 실행)
             3. 증감식
                : 반복문의 각 실행이 끝나고 변수의 값을 증감하는 분분(매 반복시 실행)
         */
        for(int num = 1; num<=5; num++) {
            System.out.print(num); //12345
        }
        System.out.println();
        //==예제1==
        //:for 반복문 사용하여 1부터 10까지 숫자중 짝수만 출력
        for (int i=1; i<=10; i++){
            if(i % 2 == 0 )
                System.out.print(i+ " "); // 2 4 6 8 10
        }
        //==예제2==
        //:구구단 (3)단
        System.out.println();
        System.out.println("3단");
        int num = 3;
        for(int i = 1; i <= 9; i++){

            System.out.println(num+ " x " + i +" = " + num * i);
        }
        //cf) for문 횟수 지정 방법
        //1) 초기화를 0으로 설정
        // : int i = 0; i < n; i++
        // >> n번 반복

        //2) 초기화를 1로 설정
        // : int i = 1; i <= n; i++
        // >> n번 반복

        //cf) 중첩 for문
        // : for 문 내에 다른 for 문 작성

        // === 예제===
        // : 구구단 전체 출력하는 코드
        //>> 2~9단
        //>> 각 단의 내부에서는 1~9까지 숫자 반복
        for(int i = 0; i < 8; i++){
        //2단부터 9단까지 반복
            System.out.println("[" + ( i + 2 ) + "단]");
            for(int j = 0; j < 9; j++){
                System.out.println(( i + 2 ) + " X " + ( j + 1 ) + " = " + ( i + 2 ) * ( j + 1 ));
            }
        }
        //int i = 0;// for 문과 다른 영역(scope)
        //int i = 1; 동일한 영역 내애ㅔ서 같은 이름의 변수 선언 불가.




    }
}
