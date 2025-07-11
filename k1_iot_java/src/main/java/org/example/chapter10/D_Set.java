package org.example.chapter10;

/*
    ===Set 인터페이스 ====
    : 중복 안됌, 순서 없음
    - 중복된 요소를 포함하지 않는 객체의 집합
    - 객체가 저장 순서를 가지지 않음(삽입된 순서가 유지되지 않음)
    - null 요소 포함 가능

    cf) List: 중복 가능, 순서 있음, null 요소 포함 및 중복 가능

    == 종료 ==
    1. HashSet
       : 가장 많이 사용되는 Set 구현체
       - 빠른 데이터 접근, 삽입 지원
       - 정렬 또는 순서 보장안됨

    2. LinkedHashSet
        : HashSet + 순서 가짐 (HashSet의 기능 확장)
        - 중복은 안되지만 순서는 있음

    3. TreeSet
        : 데이터가 자동 정렬, 중복 제거 + 정렬된 순서 유지가 필요한 경우
        - 중복은 안되지만 순서는 지펴짐
 */

import java.util.HashSet;
import java.util.Set;

public class D_Set {
    public static void main(String[] args) {
        // == Set 컬렉션의 주요 메서드 ==
        // add(), remove(), contains(), size(), isEmpty()

        Set<String> students = new HashSet<>();
        students.add("d");
        students.add("b");
        students.add("a");
        students.add("c");

        System.out.println(students);

        students.add("a");
        boolean result = students.remove("d");
        System.out.println(result);
        System.out.println(students);

        boolean falseResult = students.remove("h");
        System.out.println(falseResult);

        System.out.println(students.size());

        System.out.println(students.contains("b"));
        System.out.println(students.contains("a"));
        System.out.println(students.contains("d"));

        System.out.println(students.isEmpty());
        students.clear();
        System.out.println(students.isEmpty());




    }
}
