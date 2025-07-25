package org.example.z_project.phr_solution.service.implement;

import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientDetailResponseDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientListResponseDto;
import org.example.z_project.phr_solution.entity.Patient;
import org.example.z_project.phr_solution.repository.PatientRepository;
import org.example.z_project.phr_solution.service.PatientService;

import java.util.List;
import java.util.stream.Collectors;

public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private static long currentId = 1; // 환자 고유 번호 id 관리 변수

    public PatientServiceImpl() {
        this.patientRepository = PatientRepository.getInstance(); // 싱글톤 패턴 사용 | 구현은 P.repository 에서
    }

    //ID 생성 로직
    private Long generateId() {
        return currentId++;
    }

    @Override
    public void registerPatient(PatientCreateRequestDto dto) {
        //환자 등록 기능
        //1) 요청, 응답 : 요청값 필요 응답은 필요에 따라 결정
        //2) 요청값이 있을 경우 데이터 검증
        //                  Ex) 해당 환자 정보가 이미 저장되어있는지 확인 || 잘못된 이름, 나이 성별인지 확인
        Patient patient = new Patient(
                generateId(), dto.getName(), dto.getAge(), dto.getGender()
        );
        patientRepository.save(patient);
    }

    @Override
    public List<PatientListResponseDto> listAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientListResponseDto> responseDtos = patients.stream()
                                                                    //테스트를 위해 patient.getId() 임의 삽입
                .map(patient -> new PatientListResponseDto(patient.getId(),patient.getName(), patient.getGender()))
                .collect(Collectors.toList());
        //.toList();
        return responseDtos;
    }

    @Override
    public PatientDetailResponseDto getPatientById(Long id) {
        PatientDetailResponseDto data = null;

        try {
            /*
            Optional<Patient> optionalPatient = patientRepository.findById(id);
            if(optionalPatient.isEmpty()){
                //해당 id의 환자정보가 없는경우
                new IllegalArgumentException("해당 id의 환자를 조회할 수 없습니다. "+ id);
            }
            Patient patient = optionalPatient.get();
             */

            Patient patient = patientRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 id의 환자를 조회할 수 없습니다. " + id));
            data = new PatientDetailResponseDto(patient.getId(), patient.getName(), patient.getAge());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return data;
    }

    @Override
    public void updatePatient(Long id, PatientUpdateRequestDto dto) {
        try {
            Patient patient = patientRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 id의 환자를 조회할 수 없습니다. " + id));
            patient.setName(dto.getName());
            patient.setAge(dto.getAge());

            patientRepository.save(patient);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deletePatient(Long id) {
        try {
            Patient patient = patientRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 id의 환자를 조회할 수 없습니다. " + id));

            patientRepository.delete(patient);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
