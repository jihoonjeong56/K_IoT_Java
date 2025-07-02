package org.example.chapter02;

import java.util.Scanner;

public class B_Switch {
    public static void main(String[] args) {
        //===switch 조건문===
        // :특정 변수의 값에 따라 실행할 코드 블록의 범위를 결정
        // :비교할 변수와 case 값을 비교하여 같음 값일 경우 해당 블록부터 끝까지 실행
        //  +) break 키워드에서 switch 문이 종료
        /*
            switch(조건변수){
                case 조건1:
                    실행문장;
                case 조건2:
                    실행문장;
                case 조건3:
                    실행문장;
                ....
                default:
                    case 조건식이 끝난 뒤 작성
                      >> 어느 case 에도 일치하지 않을 경우 실행
            }
            >> full-through 상태
                :case 영역 내에서 break 키워드 없이 끝까지 실행되는 경우
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("Chapter를 선택하시오: ");
        int chapter = sc.nextInt();

        switch (chapter) {
            case 1:
                System.out.println("자바 기본문법");
                break;// 해당 case의 실행이 끝나면 switch 문을 빠져나옴(break문 뒤에 문장 작성 x)
            //System.out.println();
            case 2:
                System.out.println("자바 제어문 - 조건문/반복문");
                break;
            case 3:
                System.out.println("자바 배열");
                break;
            default:
                System.out.println("유효한 chapter가 아닙니다.");

        }
        sc.nextLine();//개행문자 처리
        System.out.println("과일의 이름일 입력해 주세요");
        String fruit = sc.nextLine();

        switch (fruit) {
            case "banana":
                System.out.println("노란색");
                break;
            case "apple":
                System.out.println("빨간색");
                break;
            case "grape":
                System.out.println("보라색");
                break;
            default:
                System.out.println("유효한 과일이 아닙니다.");
        }

        sc.close();

        //=== if VS switch===
        //1. if문
        //- 사용 대상 : 범위 조건, 불리언
        // - 조건개수 : 복잡한 조건, 논리식 가능
        // - 사용 예시 : 점수, 나이, 범위 체크
        // >>조건이 다양하거나 논리식이 필요할 경우
        int score = 85;
        if (score >= 85){
            System.out.println("우수한 성적");
        } else if (score>= 70) {
            System.out.println("평범한 성적");
        } else {
            System.out.println("좀더 노력해");
        }

        //2. switch문
        // - 사용 대상 : 정해진 값 비교
        // - 조건 개수  : 하나의 변수만 다수 값과 비교
        // - 사용 예시 : 메뉴선택, 문자열 선택 등
        // >>정확히 일치하는 값 비교할 경우

        String grade = "B";
        switch (grade){
            case "A": case "B":
                System.out.println("우수한 성적");
                break;
            case "C": case "D":
                System.out.println("평범한 성적");
                break;
            default:
                System.out.println("노력하세요");
        }


    }
}
