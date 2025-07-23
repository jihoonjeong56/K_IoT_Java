package org.example.chapter15;

/*
    === 스트림 API
    1. 스트림 생성: .stream()
    2. 중간(가공) 절차
            - map(Function: 입력값을 받아 특정 연산 후 반환)
            - filter(Predicate: 입력값을 받아 조건을 검사)
            - sorted(Comparator: 입력값에 대한 비교)
    3. 최종(결과)절차
            - collect
            - forEach
    === 자바의 정렬===
    1. 정렬
    : 데이터를 특정 기준(순서)에 따라 나열
    ex) 오름차순 (1, ㄱ, ㅏ, a), 내림차순(큰수, ㅎ, ㅣ, z), 문자열 길이 순 정렬(a, aa, aaa)

    2. 배열(Arrays 클래스) 정렬
    : Arrays 클래스의 정적 메서드(.sort()) 사용
    >>오름차순 정렬만 지원, 내림차순 정렬 - Collections 클래스 사용 .reverseOrder() 정적 메서드를 사용

    3. 리스트(List 인터페이스) 정렬
    : Collections.sort() || List 인터페이스의 sort() 메서드 사용



 */

import java.util.*;

public class A_Sort {
    public static void main(String[] args) {
        //1. 배열 정렬
        // == 오름차순 ==
        System.out.println("====배열 정렬 오름차순====");
        int[] numbers = {2, 4, 56, 6, 8, 34, 5, 3};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers)); //[2, 3, 4, 5, 6, 8, 34, 56]

        // == 내림차순 ==
        //: Collections.reverseOrder()
        // >> Comparator<T>를 반혼하는 메서드(객체 타입간의 비교 - 기본 데이터 타입 비교 안함)
        System.out.println("====배열 정렬 내림차순====");
        Integer[] nums = {1, 7, 90, 2, 5, 7, 89};
        Arrays.sort(nums, Collections.reverseOrder());
        System.out.println(Arrays.toString(nums)); //[90, 89, 7, 7, 5, 2, 1]


        //2. List 정렬
        //== 오름차순 ==
        System.out.println("====List 정렬 오름차순====");
        List<Integer> list = new ArrayList<>(List.of(4, 1, 6, 7, 9));
        //Collections.sort(list);
        list.sort(null);
        //cf) List.sort()는 내부적으로 Comparator을 전달받음
        //      >> 비교기준을 정해주는 클래스
        //1) null
        //  : 기본정렬(오름차순) - String, Integer, Double 등의 단일 데이터가 Comparable을 이미 구현함
        //2) Comparator
        //  : 지정한 Comparator 기준으로 정렬
        //      ex) 데이터의 변환( 문자열 >> 길이) , list.sort(Comparator.reverseOrder())
        List<String> listA = new ArrayList<>(List.of("aaa","aaaa","aa","a","aaaaaaaa"));
        listA.sort(Comparator.comparingInt(String::length));
        System.out.println(listA);

        System.out.println(list);
        // 내림차순
        System.out.println("====List 정렬 내림차순====");
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        System.out.println("====List 정렬 Comparator - 오름차순====");
        //=== Comparator 클래스 사용
        // : 사용자 정의 기준 정렬
        List<String> names = new ArrayList<>(List.of("Tom", "Jerry", "Pororo", "Loopy"));
        //문자열 길이 기준 정렬
        // : 전체 순회 > 각 이름의 길이를 반환 > 오름차순 정렬
        //names.sort(Comparator.comparingInt(name->name.length()));
        names.sort(Comparator.comparingInt(String::length));
        System.out.println(names);
        //Comparator 두 개의 객체를 비교하는 로직을 담는 인터페이스
        //      >> 어떤 기준으로 정렬할지 개발자가 결정


        //3. 스트림  API 사용 정렬
        //: 정렬된 결과를 새로운 컬렉션으로 반환
        System.out.println("==== 스트림 API 사용 정렬 오름차순====");
        List<Integer> listNumber = new ArrayList<>(List.of(7, 4, 1, 8, 3));
        List<Integer> sortedNumber = listNumber.stream()
                .sorted()
                .toList();
        System.out.println("오름차순 정렬: " + sortedNumber);//[1, 3, 4, 7, 8]
        //sortedNumber.forEach(System.out::println);
        System.out.println("원본 정렬: " + listNumber); //[7, 4, 1, 8, 3]
        //스트림 API를 사용한 정렬시, 원본 데이터에 대한 불변성이 유지됨, 새로 정렬된 리스트를 반환
        System.out.println("==== 스트림 API 사용 정렬 내림차순====");
        List<Integer> sortedReverseNumber = listNumber.stream()
                .sorted((a, b) -> b - a)
                .toList();
        //정렬식(내림차순)
        //(a, b) -> b - a
        // : a와 b 는 리스트 안의 두개의 요소(순차적으로 담김)
        // >> 두 요소를 비교한 결과를 반환
        //      - 반환값이 양수: b가 a보다 앞에옴
        //      - 반환값이 0: 순서변경 없음(두 수가 같음)
        //      - 반환값이 음수: a가 b보다 앞에옴
        // 오름차순(a, b) -> a - b
        System.out.println(sortedReverseNumber);
        List<String> charNames = new ArrayList<>(List.of("Tom", "Jerry", "Pororo", "Loopy"));
        //캐릭터 이름의 길이를 오름차순 정렬
        System.out.println("==== 스트림 API 사용 정렬 - 캐릭터이름의 길리를 오름차순 정렬====");
        List<String> sortedChar = charNames.stream()
                //.sorted((n1,n2)->n1.length()-n2.length())//오름차순
                .sorted((n1, n2) -> n2.length() - n1.length())//내림차순
                .toList();
        System.out.println(sortedChar);


    }
}
