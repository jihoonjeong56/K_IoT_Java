package org.example.chapter03;

public class C_Array {
    public static void main(String[] args) {
        // 다차원 배열
        // : 배열의 배열 (배열 내의 요소가 배열)
        // : 2,3,4,.........차 배열
        // >> 데이터를 테이블 형태로 구성할 때 유용
        // >> 게임보드, 데이터 분석, 그래프 등에 사용

        // == 다차원 배열의 선언 및 초기화
        // 2차원 배열 선언: 데이터타임[][] 배열명;
        // 2차원 배열 생성: new 데이터타입[행의개수][열의개수];

        int[][] matrix = new int[3][2];
        matrix[0][0] = 1;//1행 1열
        matrix[0][1] = 2;//1행 2열
        //matrix[0][2] = 3;//1행 3열 벗어난 범위에 의해 예외 발생 ArrayOutOfBoundException

        //선언과 동시에 초기화
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}};
        // 다차원배열 출력
        // : 각 행을 순회하고 해당 행 내부의 요소를 출력
        for (int[] row : matrix2) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
