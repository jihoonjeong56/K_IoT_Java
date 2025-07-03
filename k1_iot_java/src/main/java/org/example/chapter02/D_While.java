package org.example.chapter02;

import java.util.Scanner;

public class D_While {
    public static void main(String[] args) {
        //===while문===
        //:반복 횟수가 정해져 있지 않을 때 사용
        //-조건을 검사하고 해당 조건이 true인 경우 코드 블록을(반복적) 실행
        //  :if문의 반복 형태
        /*
            while (조건식) {
                조건이 참인경우 실행
            }

            >>for문의 초기화식과 증감식이 조건문과 분리된 형태
                : for(초기화식; 조건식; 증감식){}
         */
        //cf) for 문으로 1부터 5까지 출력하는 문장을 작성(초기화는 1)
        System.out.println("for문 출력");
        for(int i = 1; i < 6; i++){
            System.out.print(i + " ");
        }

        //while 문으로 1부터 5까지 출력
        System.out.println("\nwhile문 출력");
        //초기화식
        int a = 1;
        while(a < 6){
            System.out.print(a + " ");
            a++;
        }
        System.out.println();
        // ==예제 (break, continue)
        //0부터 20까지의 정수중에 홀수만 출력
        //1) break;
        //  반복문 내에서 break; 키워드를 만나면 반복문 탈출
        //2)continue;
        //  반복문 내에서 continue; 키워드를 만나면 아래의 코드를 무시하고 다시 '조건검사'로 돌아간다.
        System.out.println("while문 홀수 출력 예제");
        int num = 0;
        while(true){//if 문 & while 문의 조건식은 결과값이 논리형(boolean)
            //while문의 조건식을  true값으로 고정하는 경우 종료시점(break)을 개발자가 직접 명시하지 않으면 무한루프 발생.
            //프로그램의 과부하 방지를 위해 지양
            if(num % 2 == 0){
                //짝수
                num++;//홀수를 위한 작업
                continue;//조건식으로 돌아감
            }
            //홀수만 해당내용 실행
            System.out.println(num);
            num++;
            if(num == 20) break;
        }
        //===do-while문===
        //  while문과의 차이점 - 코드가 반드시 한 번은 실행
        //  while문과의 공통점 - 초기화식& 증감식 분리
        System.out.println("do-while문 출력");
        /*
            do{

            }while(조건식);
         */
        int doNum = 1;
        do {
            System.out.println(doNum);
            doNum++;
        } while(doNum <= 5);

        //===while VS do-while
        //  1)while
        //  조건 검사 시점 - 실행 전 검사
        //  최소 실행 X
        //  2)do-while
        //  조건 검사 시점 - 실행 후 검사
        //  최소 실행 횟수 = 1번(고)
        //  ==예제==
        //  사용자의 입력을 받아서 1~10사이의 숫자가 입력될 때까지 반복
        //  do-while 문으로 작성
        Scanner sc = new Scanner(System.in);
        int inputNum ;
        do{
            System.out.println("1~10사이의 숫자 입력");
            inputNum = sc.nextInt();
        }while(inputNum < 1 || inputNum > 10); // 1부터 10사이인 경우 반복문 종료
        System.out.println("올바른 숫자: " + inputNum);

        // cf) while 문은 반복 전에 조건을 검사하기 때문에, 초기 입력 코드를 반복문 밖에 따로 작성
        System.out.println("1~10  사이의 숫자 입력");
        inputNum = sc.nextInt();
        while(inputNum < 1 || inputNum > 10){   //조건 검사 전 입력을 받기 위한 코드 중복 발생
            System.out.println("다시 입력");
            inputNum = sc.nextInt();
        }
        System.out.println("올바른 숫자: " + inputNum);

        //===예제


    }
}
