package org.example.chapter10;

// === Map 인터페이스===
// : 키(key)와 값(value)의 쌍으로 요소를 저장하는 데이터 구조
// - 키는 고유한 데이터를 가빈(중복키 허용 안됨)
// - 동일한 키이ㅔ 서로 다른 값 전달 시기존 값이 새로운 값으로 덮어씌워짐
//EX) name:"이승아", name: "이도경" (불가능, nome:"이도경"만 존개)

// cf) 서로 다른 키에 동일한 값은 가능
// EX) name:"개구리", nickname: "개구리"

//+) 키의 유일성과 값의 중복성 보장
//      >> 순서보장은 안된다. (예외는 있다)
// - 키를 기반으로 빠른 검색 가능

// == Map 인터페이스 종료(구현체)
// 1. HashMap
//      : 가장 많이 사용, 기와 값이 null 허용
//      - 빠른 겁색 삽입 성능 제공
//      -순서 유지 안됨

// 2. LinkedHashMap
//      : HashMap + 삽입 순서 유지
//      - 삽입 순서가 중요하고 빠른 검색이 필요할 때 사용

// 3. TreeMap
//      : 키에 따라 자동 정렬 기능 보장
//      - 키에 null 허용 안됨

import java.util.*;

public class E_Map {
    public static void main(String[] args) {
        // == Map 인터페이스 메서드 ==
        //Map<키 타입, 값타입> 인스턴스명 = new Map종류<>();
        Map<String, Integer> studentAges = new HashMap<>();

        // 1. put(키, 값): 키와 값을 Map에 추가
        studentAges.put("홍길동", 20);
        studentAges.put("허준", 25);
        studentAges.put("전우치", 30);

        System.out.println(studentAges); // 중괄호 내에 키=값의 쌍이 콤마로 구분되어 나열
        //    >> 삽입 순서 보장 안됨

        System.out.println(studentAges.get("전우치")); // 저장된 키의 값을 반환
        studentAges.remove("허준"); // 지정된 키의 값을 삭제 후 반환
        System.out.println(studentAges);

        System.out.println(studentAges.containsKey("a"));
        System.out.println(studentAges.containsValue(34));

        System.out.println(studentAges.containsKey("전우치"));
        System.out.println(studentAges.containsValue(20));

        System.out.println(studentAges.size());

        // keySet(): Map의 키들을 Set 으로 반환
        System.out.println(studentAges.keySet());

        // values(): Map의 값들을 컬렉션 타입으로 반환
        Collection<Integer> listAges = studentAges.values();
        System.out.println(listAges);

        // cf) Collection 타입은 하위 인터페이스로 변환 가능
        List<Integer> changeList = new ArrayList<>(listAges);
        System.out.println(changeList);

        //entrySet() : Map의 키와 값을 Set 으로 변환
        System.out.println(studentAges.entrySet()); // Set의 구조체로 변경




    }
}













