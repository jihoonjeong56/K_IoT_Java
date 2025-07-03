package org.example.chapter02;

import java.util.Scanner;

public class E_Practice {
    public static void main(String[] args) {
        //===1===//
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력해 주세요");
        int score = sc.nextInt();
        if(score < 0 || score > 100) {
            System.out.println("다시 입력해 주세요");
            score = sc.nextInt();
        }
        if(score >= 90) System.out.println("A");
        else if(score >= 80) System.out.println("B");
        else if(score >= 70) System.out.println("C");
        else if(score >= 60) System.out.println("D");
        else System.out.println("F");

        //===2===//
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        /*
        for(int i=0; i<5; i++){
            for(int j = 0; j<i+1; j++){
                System.out.print("*");
            }
            for(int k = 0; k<5-i; k++){
                System.out.print(" ");
            }
            System.out.println();
        }
         */
        /*//예제 2-2
            *
           **
          ***
         ****
        *****
        행은 1부터 5까지 반복 i<rows;(조건)
         */
        //공백은 4부터 감소 : rows -i(조건)
        //별은 1부터 5까지 증가 : 행을 초과하지 않도록 반복
        int rows = 5;//출력할 줄 수
        for(int i = 1; i<=rows; i++){
            for(int j = 1; j <= rows-i; j++){ //공백 반복, i:1부터 5까지 반복
                System.out.print(" ");
            }
            for(int k = 1; k<=i; k++){  //별의 반복
                System.out.print("*");
            }
            System.out.println();
        }
       /*
        for(int i=0; i<5; i++){
            for(int k = 0; k<5-i; k++){
                System.out.print(" ");k66
            }
            for(int j = 0; j<i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        */


    }
}
