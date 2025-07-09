package org.example.chapter09;

//===java.time 패키지
//IST-8601 표준을 기반으로 설계
// : YYYY-MM-DD-Thh:mm:ss:sssZ 형식
// - import 문을 사용하여 클래스를 명시


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JavaTime {
    public static void main(String[] args) {
        // 1) 날짜
        LocalDate today = LocalDate.now(); //LocalDate(날짜- 연도,월, 일)
        // now(): 현재 날짜 반환
        System.out.println(today);
        LocalDate yesterday = LocalDate.of(2025,7,8);
        // of(): 년도, 월 일을 제공하면 국제 표기법 상 표현으로 반환
        System.out.println(yesterday);

        LocalDate tomorrow = today.plusDays(1);
        LocalDate oneMonthsAgo = today.minusMonths(1);
        // .plus(Year, Months, Days): n년후, n달 후 , n일후
        // .minus(동일) : N년/달/일 전
        System.out.println(tomorrow);
        System.out.println(oneMonthsAgo);

        // 2) 시간
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime lunchTime = LocalTime.of(12,50); //of(시, 분) || (시, 분, 초)가능
        System.out.println(lunchTime);

        //.plus(Hours, Minutes, Seconds)
        //.minus(Hours, Minutes, Seconds)

        // 3) 날짜 & 시간
        // .now(), .of(), .plus(), .minus()
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println(nowDateTime);

        //cf) get 메서드
        // : getYear(), getMonth(), getDayOfMonth(): 날짜 정보 반환
        // : getHours(), getMinute(), getSecond(): 시간 정보 반환

        System.out.println(today.getYear());
        System.out.println(today.getMonth()); // - 키워드 반환 (영단어)
        System.out.println(today.getDayOfMonth());

        // cf) 날짜/ 시간 포맷팅
        // formatting - 원하는 형식으로 출력
        LocalDateTime example = LocalDateTime.now();
        System.out.println(example);

        //DateTimeFormatter: LocalDateTime의 날짜/ 시간 데이터를 원하는 패턴으로 변경
        // .ofPattern (원하고자 하는 패턴을 문자열로 전다.)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");

        // cf) 포맷 기호 - 대소문자 구분
        // y(연도), M(월), d (일) / H(시), h(시), m(분), s(초)
        // - H는 24시간
        // - h는 12시간

        //변경할 날짜/시간 데이터.format(원하는 포멧 형식)
        System.out.println(example.format(formatter));




    }
}
