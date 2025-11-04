# ☕ K_IoT_Java

IoT 개발자를 위한 Java 프로그래밍 학습 저장소입니다.

## 📚 프로젝트 개요

이 저장소는 Java 기초부터 실전 프로젝트까지 체계적으로 학습할 수 있도록 구성된 교육용 프로젝트입니다. 16개의 챕터를 통해 Java의 핵심 개념을 단계별로 익히고, 실무에서 활용할 수 있는 프로젝트를 구현합니다.

## 🛠️ 기술 스택

- **언어**: Java 17
- **빌드 도구**: Gradle
- **IDE**: IntelliJ IDEA
- **라이브러리**: 
  - Lombok 1.18.38
  - JUnit 5.10.0

## 📂 프로젝트 구조

```
k1_iot_java/
├── src/main/java/org/example/
│   ├── chapter01/      # Java 기초
│   ├── chapter02/      # 제어문
│   ├── chapter03/      # 배열
│   ├── chapter04/      # 객체지향 기초
│   ├── chapter05/      # 메서드
│   ├── chapter06/      # 생성자와 상속
│   ├── chapter07/      # 접근제어자와 캡슐화
│   ├── chapter08/      # 추상화와 인터페이스
│   ├── chapter09/      # 예외처리와 Java API
│   ├── chapter10/      # 컬렉션 프레임워크
│   ├── chapter11/      # OOP 심화
│   ├── chapter12/      # MVC 패턴
│   ├── chapter13/      # 제네릭과 디자인 패턴
│   ├── chapter14/      # 람다와 스트림
│   ├── chapter15/      # 스트림 API 심화
│   ├── chapter16/      # Wrapper 클래스와 Enum
│   ├── test0710/       # 이론 및 OOP 구현 테스트
│   ├── test0717/       # 도서 관리 시스템 테스트
│   └── z_project/      # 최종 프로젝트
├── build.gradle
└── README.md
```

## 🎯 학습 챕터

### Chapter 01: Java 기초
- Hello World & 프로그램 실행 구조
- 변수와 데이터 타입
- 형 변환
- 입출력 (Scanner)
- 연산자

### Chapter 02: 제어문
- 조건문 (if, switch)
- 반복문 (for, while)
- 제어문 실습 문제

### Chapter 03: 배열
- 1차원 배열
- 2차원 배열
- 배열 활용 실습

### Chapter 04: 객체지향 프로그래밍 기초
- 클래스와 객체
- 필드(Field)
- 객체 생성과 활용

### Chapter 05: 메서드
- 메서드 정의와 호출
- 매개변수와 반환값
- 메서드 오버로딩

### Chapter 06: 생성자와 상속
- 생성자 (Constructor)
- 상속 (Inheritance)
- 메서드 오버라이딩
- **실습**: 학생 관리 시스템 (StudentManagementApp)

### Chapter 07: 접근제어자와 다형성
- 접근 제어자 (Modifier)
- 캡슐화 (Encapsulation)
- final 키워드
- 다형성 (Polymorphism)
- **실습**: 동물 관리 앱, 주문 시스템

### Chapter 08: 추상화와 인터페이스
- 추상 클래스 (Abstract Class)
- 인터페이스 (Interface)
- 인터페이스 활용

### Chapter 09: 예외처리와 Java API
- 예외 처리 (try-catch, throws)
- 사용자 정의 예외
- Java.lang 패키지
- Java.util 패키지
- Java.time 패키지
- **실습**: 사용자 관리 시스템 (예외처리 적용)

### Chapter 10: 컬렉션 프레임워크
- List (ArrayList, LinkedList)
- Set (HashSet, TreeSet)
- Map (HashMap, TreeMap)
- **실습**: 
  - 도서관 재고 관리 시스템
  - 가전제품/가구 재고 시스템

### Chapter 11: 객체지향 설계 원칙
- OOP 설계 원칙 (SOLID)
- 결합도와 응집도

### Chapter 12: MVC 패턴
- MVC 아키텍처 이해
- Model-View-Controller 구조
- **실습**: 
  - 도서 관리 시스템 (MVC)
  - 학생 관리 시스템 (MVC + DTO)

### Chapter 13: 제네릭과 디자인 패턴
- 제네릭 (Generics)
- 싱글톤 패턴 (Singleton)
- 빌더 패턴 (Builder)
- Lombok 활용
- **실습**: 도서 관리 시스템 (전체 아키텍처 적용)

### Chapter 14: 함수형 프로그래밍
- 내부 클래스 (Inner Class)
- 익명 클래스 (Anonymous Class)
- 람다 표현식 (Lambda)
- 메서드 참조 (Method Reference)
- 스트림 API (Stream)

### Chapter 15: 스트림 API 심화
- 정렬 (Comparator, Comparable)
- 스트림 수집 (Collectors)
- 배열과 리스트 변환
- Optional 클래스
- **실습**: 
  - 회원가입 유효성 검사
  - 게시판 시스템 (CRUD)

### Chapter 16: 고급 타입
- Wrapper 클래스
- Enum 타입
- 날짜 및 시간 API
- **실습**: 도서 카테고리 관리

## 🚀 최종 프로젝트

### 1. PHR (Personal Health Record) 솔루션
**개인 건강 기록 관리 시스템**

- **주요 기능**:
  - 환자 정보 관리 (CRUD)
  - 건강 기록 관리 (CRUD + 필터링)
  - 진단명 기반 검색 및 집계

- **기술 구현**:
  - MVC 아키텍처
  - DTO 패턴
  - Repository 패턴
  - 입력 유효성 검사
  - 예외 처리

- **프로젝트 구조**:
  ```
  phr_solution/
  ├── controller/
  ├── service/
  ├── repository/
  ├── entity/
  ├── dto/
  ├── handler/
  └── util/
  ```

### 2. 온라인 예약 시스템
**사용자 예약 관리 시스템**

- **주요 기능**:
  - 사용자 관리 (회원가입, 로그인, 로그아웃)
  - 예약 관리 (등록, 조회, 취소)
  - 인증 및 권한 관리

- **기술 구현**:
  - MVC 패턴
  - 서비스 레이어 분리
  - 세션 관리
  - 데이터 영속성

## 📖 학습 테스트

### test0710: Java 기초 이론 테스트
- Java 기초 용어 정리
- 이론 문제 풀이
- OOP 구현 실습 문제 (Q1-Q4)

### test0717: 도서 관리 시스템 테스트
- 예외 처리 실습
- 사용자 정의 예외 구현
- Java API 활용 (날짜 처리)

## 🎓 학습 목표 및 성과

- ✅ Java 핵심 문법 완벽 이해
- ✅ 객체지향 프로그래밍 원칙 (SOLID) 적용
- ✅ 디자인 패턴 (MVC, Singleton, Builder) 활용
- ✅ 컬렉션 프레임워크 마스터
- ✅ 함수형 프로그래밍 (람다, 스트림) 활용
- ✅ 예외 처리 및 유효성 검사
- ✅ 실전 프로젝트 아키텍처 설계 능력

## 💡 주요 특징

### 1. 체계적인 학습 구조
- 16개 챕터를 통한 단계별 학습
- 각 챕터별 실습 과제 포함
- 이론과 실습의 균형있는 구성

### 2. 실무 중심 프로젝트
- MVC 패턴 기반 아키텍처
- Repository 패턴 적용
- DTO를 통한 계층간 데이터 전달
- 예외 처리 및 유효성 검사

### 3. 최신 Java 기능 활용
- Java 17 사용
- 람다 표현식
- 스트림 API
- Lombok을 통한 보일러플레이트 코드 감소

## 🏃 실행 방법

### 개별 챕터 실행
1. IntelliJ IDEA에서 프로젝트 열기
2. 원하는 챕터의 파일로 이동
3. main 메서드가 있는 클래스 실행

### 프로젝트 실행
1. PHR 솔루션 실행:
   ```
   z_project/phr_solution/App.java 실행
   ```

2. 예약 시스템 실행:
   ```
   z_project/user_reservation/Main.java 실행
   ```

### Gradle 빌드
```bash
./gradlew build
```

## 📝 코드 컨벤션

- 클래스명: PascalCase
- 메서드/변수명: camelCase
- 상수: UPPER_SNAKE_CASE
- 패키지명: 소문자
- 주석: 한글로 상세하게 작성

## 🔍 참고사항

- 모든 코드는 학습 목적으로 작성되었습니다
- 주석은 한글로 작성되어 이해를 돕습니다
- 각 챕터는 독립적으로 실행 가능합니다
- 프로젝트는 점진적으로 복잡도가 증가합니다

## 📚 학습 순서 추천

1. **기초 단계** (Chapter 01-06): Java 문법과 객체지향 기초
2. **중급 단계** (Chapter 07-11): OOP 심화와 설계 원칙
3. **고급 단계** (Chapter 12-16): 아키텍처 패턴과 함수형 프로그래밍
4. **프로젝트 단계** (z_project): 실전 프로젝트 구현

## 🎯 다음 학습 단계

- Spring Framework 학습
- Spring Boot를 활용한 웹 애플리케이션 개발
- 데이터베이스 연동 (JDBC, JPA)
- RESTful API 설계 및 구현

---

**참고**: 이 저장소는 K-Digital Training IoT 개발자 과정의 Java 학습 자료입니다.
