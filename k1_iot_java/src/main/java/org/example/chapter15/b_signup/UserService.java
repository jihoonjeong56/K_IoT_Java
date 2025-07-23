package org.example.chapter15.b_signup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    public static User signUp(UserSignupRequestDto dto) {
        User user = null;
        try {
            // 회원 데이터 유효성 검증
            // 비밀 번호와비밀번호 확인 값의 일치 유무 검증
            String password = dto.getPassword();
            String passwordCheck = dto.getPasswordCheck();
            if (!password.equals(passwordCheck)) {
                //일치하지 않는 경우 예외 발생
                throw new Exception("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            }
            Long id = 1L;// 데이터베이스 역할을 대신
            Date nowDate = new Date(); // 회원가입하는 시점을 저장

            user = User.builder()
                    .id(id)
                    .username(dto.getUsername())
                    .password(password)
                    .name(dto.getName())
                    .email(dto.getEmail())
                    .phone(dto.getPhone())
                    .nickname(dto.getNickname())
                    .signUpDate(nowDate)
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public static void main(String[] args) {
        // 1) 사용자로 부터 요청값을 받음(userSignUpRequestDto 형식)
        // 2) 요청값 검증
        // 3) User 형식으로 데이터 저장
        //4) User 타입 반환
        UserSignupRequestDto dto1 = new UserSignupRequestDto(
                "qwe123","qwe123123","qwe123123","이승아"
                ,"qwer123@asdfasdf","010-1111-2222","asdfasdf"
        );
        User user1 = signUp(dto1);
        System.out.println(user1.getSignUpDate());
        UserSignupRequestDto dto2 = new UserSignupRequestDto(
                "qwe1233","qwe3123123","qwe3123123","이3승아"
                ,"qwer1233@asdfasdf","010-1111-3333","asdfas3df"
        );
        User user2 = signUp(dto2);
        System.out.println(user2.getSignUpDate());

        List<User> userList = null   ;
        List<UserSignupRequestDto> dtos = new ArrayList<>();
        dtos.add(dto1);
        dtos.add(dto2);

        userList = dtos.stream()
                .map(UserService::signUp)
                .collect(Collectors.toList());
        userList.forEach(System.out::println);

    }
}
