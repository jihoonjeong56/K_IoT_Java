package org.example.z_project.user_reservation.controller;

import org.example.z_project.user_reservation.dto.ReservationResponseDto;
import org.example.z_project.user_reservation.dto.UserLoginRequestDto;
import org.example.z_project.user_reservation.dto.UserRegisterRequestDto;
import org.example.z_project.user_reservation.service.ReservationService;
import org.example.z_project.user_reservation.service.UserService;
import org.example.z_project.user_reservation.service.impliment.ReservationServiceImpl;
import org.example.z_project.user_reservation.service.impliment.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ReservationController {
    private final UserService userService;
    public final ReservationService reservationService;

    public ReservationController() {
        this.userService = new UserServiceImpl();
        this.reservationService = new ReservationServiceImpl(userService);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = getChoice(sc);

            if (!processChoice(choice, sc)) {
                break; // processChoice의 반환이 false인 경우 무한루프 종료(7>> false)
            }

        }
    }

    public void displayMenu() {
        System.out.println("1. 사용자 등록(회원가입) | 2. 로그인 | 3. 로그아웃");
        System.out.println("4. 예약 등록 | 5. 예약 확인 | 6. 예약 취소 ");
        System.out.println("7. 종료");
        System.out.print("선택 >>");
    }

    private int getChoice(Scanner sc) {
        while (!sc.hasNextInt()) {
            //hasNextInt() : 입력값이 int 면 true 그렇지 않으면 false
            //입력값이 정수가 아닌 경우
            System.out.println("숫자를 입력해 주세요");
            sc.next();
        }
        return sc.nextInt();
    }

    private boolean processChoice(int choice, Scanner sc) {
        sc.nextLine(); // 정수값 입력 받고 남은 버퍼 처리

        switch (choice) {
            case 1:
                userService.registerUser(
                        new UserRegisterRequestDto(
                                input(sc, "사용자 Id"),
                                input(sc, "사용자 비밀번호"),
                                input(sc, "사용자 비밀번호 확인"),
                                input(sc, "사용자 이름"),
                                input(sc, "사용자 이메일")));
                break;
            case 2:
                userService.login(
                        new UserLoginRequestDto(
                                input(sc, "사용자 Id"),
                                input(sc, "사용자 비밀번호")));
                break;
            case 3:
                userService.logout();
                break;
            case 4:
                reservationService.createReservation(input(sc, "사용자 ID"));
                break;
            case 5:
                List<ReservationResponseDto> results = reservationService.getReservationByUserId(
                        input(sc, "사용자 Id"));
                results.forEach(System.out::println);
                break;
            case 6:
                String reservationId = input(sc, "예약 Id");
                try {
                    Long id = Long.parseLong(reservationId);
                    reservationService.cancelReservation(id);
                }catch (NumberFormatException e){
                    System.out.println("예약 Id는 숫자여야 함니다. 다시 시도해 주세요");
                }
                break;
            case 7:
                System.out.println("프로그램을 종료합니다.");
                return false;
            default:
                System.out.println("잘못된 선택 입니다. 유효한 기능을 선택하세요(1~7)");
        }
        return true;
    }

    private String input(Scanner sc, String prompt) {
        System.out.print(prompt + ": ");
        return sc.nextLine();
    }
}
