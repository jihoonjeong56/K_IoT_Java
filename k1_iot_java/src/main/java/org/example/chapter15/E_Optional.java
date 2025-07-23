package org.example.chapter15;

import java.util.Optional;

/*
    =====Optional 클래스====
    : 값이 존재할 수도 있고, 없을 수도 있는 객체를 감싸는 컨테이너(자바 8 이후)
    - null 값을 다룰때 사용 하는 NullPointerException(NPE) 방지
    - null 체크를 명시적으로 안전하게 처리
    +) 함수형 프로그래밍 스타일 지원

 */
class Person {
    String name;
}

public class E_Optional {
    static String findNameById(int id) {
        return null; // 실제 DB 나 Map 에서 검색한다 가정 >> 못찾을 경우 null 반환
    }

    public static void main(String[] args) {
        //cf) NPE :null 참조된 객체에 접근할 때 발생하는 예외
        String name = null;
        //System.out.println(name.length());
        Person p = null;
        //System.out.println(p.name);
        String[] arr = new String[3];
        arr[0] = "abc";
        //System.out.println(arr[1].toUpperCase());
        String result = findNameById(123);
        //System.out.println(result.toUpperCase());

        //1. Optional 클래스
        //: null 이 아닌 값을 포함하거나, 값이 없는 상태를 나타낼 수 있음
        // - 값을 명시적으로 검사하고 처리하는 방식
        // 2. Optional 생성 방법
        // 1) Optional.of(T value): null이 아닌 값을 감쌈(null 전달시 NPE 발생)
        //Optional<String> optional0 = Optional.of(null); - NPE 발생
        Optional<String> optional1 = Optional.of("Hello Optional");
        //2) Optional.ofNullable(T value) : null 여부 상관없이 Optional 생성(null 일경우 빈 Optional)
        Optional<String> optional2 = Optional.ofNullable(null);
        //3) Optional.empty(): 비어있는 Optional을 생성(명시적으로 "값 없음"표현)
        Optional<String> optional3 = Optional.empty();

        //3. Optional 값 확인 메서드
        //1) isPresent(): 값이 존재하면 true, 존재하지 않으면 false
        //2) isEmpty(): 값이 존재하면 false, 존재하지 않을경우 true
        System.out.println(optional1.isPresent());
        System.out.println(optional1.isEmpty());

        System.out.println(optional2.isPresent());
        System.out.println(optional2.isEmpty());

        System.out.println(optional3.isPresent());
        System.out.println(optional3.isEmpty());

        //4. Optional값 추출 메서드
        // .get()
        // >> 값이 없는 상태(null)에서 호출 시 예외 발생
        System.out.println(optional1.get());
        //System.out.println(optional2.get()); -> NoSuchElementException 발생(가져올 값이 없다)

        //5. Optional 기본 값 처리
        //      >> 값을 확인하고 존재하면 반환, 존재하지 않으면(빈Optional) 경우에 따라 값을 반환 || 예외발생
        // 1) .orElse(T other) : 값이 없을경우 기본값 (other) 반환
        // 2) .orElseGet(Supplier<T>) : 값이 없을경우 함수형 인터페이스로 값을 생성하여 반환
        // 3) .orElseThrow(Supplier<Throwable>) : 값이 없을경우 예외 발생

        //cf) Supplier 공급하다. : T 타입의 값을 생성하여 반환
        System.out.println(optional2.orElse("기본값 반환"));
        System.out.println(optional2.orElseGet(() -> "값을 생성하여 반환"));

        try{
            //cf) Throwable >> Exception(예외), Error(오류)
            optional3.orElseThrow(() -> new Error("값이 없을 경우 예외 발생"));// 런타임
            //optional3.orElseThrow(()-> new Exception("예외발생"));// 컴파일
        }catch (Error e){
            System.out.println("예외가 발생했습니다.: "+ e.getMessage());
        }
        //cf) Optional 사용 시 주의 사항
        // 1) 필드에 사용 하지 않음
        // 2) 메서드 매개변수로 사용안함 -> 반환값으로 사용(메서드 호출 결과가 null 일수 있는 경우에만
        // 3) 값이 반드시 존재해야하는 경우 사용하지 않는다 >> null 방지에 대한 필숟값은 직접 값을 반환하고 null 여부 확인


    }
}
