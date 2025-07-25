package org.example.z_project.phr_solution.handler;

import org.example.z_project.phr_solution.dto.health_record.request.RecordCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner sc = new Scanner(System.in);

    public static int getChoice() {
        while (!sc.hasNextInt()) {
            System.out.println("숫자을 입력해주세요");
            sc.nextLine();
        }
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public static String getInput(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("입력값을 비워둘 수 없습니다.");
        }
    }

    public static Long getIdInput() {
        while (true) {
            String input = getInput("id를 입력하세요");
            try {
                return Long.parseLong(input);

            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다.");
            }
        }
    }

    //요청
    //1) 환자 정보
    // - 생성
    public static PatientCreateRequestDto createPatientRequest() {
        PatientCreateRequestDto dto = null;
        try {
            String name = getInput("환자이름을 입력해 주세요");
            int age = Integer.parseInt(getInput(" 환자 나이를 입력해 주세요"));
            String gender = getInput("환자 성별을 입력해 주세요");
            dto = new PatientCreateRequestDto(name, age, gender);

        } catch (NumberFormatException e) {
            System.out.println("환자나이는 숫자 값을 입력해야 합니다." + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dto;
    }

    // - 수정
    public static PatientUpdateRequestDto updatePatientRequestDto() {
        PatientUpdateRequestDto dto = null;
        try {
            String name = getInput("환자이름을 입력해 주세요");
            int age = Integer.parseInt(getInput(" 환자 나이를 입력해 주세요"));
            dto = new PatientUpdateRequestDto(name, age);
        } catch (NumberFormatException e) {
            System.out.println("환자나이는 숫자 값을 입력해야 합니다." + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dto;
    }

    //2)건강 기록 정보 생성
    public static RecordCreateRequestDto createRecordRequest(){
        RecordCreateRequestDto dto = null;
        try {
            long patientId = getIdInput();
            String dateOfVisit = getInput("방문날짜를 입력하세요(예: 0000-00-00)");
            //문자열 포멧이 DateTime과 다를경우?
            String diagnosis = getInput("진단명을 입력하세요");
            String treatment = getInput("처방 내용을 입력하세요");
            dto = new RecordCreateRequestDto(patientId, dateOfVisit,diagnosis, treatment);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dto;
    }
    public static void closeScanner() {
        sc.close();
    }
}
