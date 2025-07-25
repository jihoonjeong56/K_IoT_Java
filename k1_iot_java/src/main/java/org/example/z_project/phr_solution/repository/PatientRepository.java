package org.example.z_project.phr_solution.repository;

import org.example.z_project.phr_solution.entity.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientRepository { // 싱글톤 패턴 구현
    List<Patient> patients = new ArrayList<>();
    private static final PatientRepository instance = new PatientRepository();

    private PatientRepository(){}

    public static PatientRepository getInstance(){
        return instance;
    }

    public void save(Patient patient) {
        // 생성 create, 수정 update 가 같은 save 메서드 사용
        Optional<Patient> existing = findById(patient.getId());
        //existing.ifPresent(value-> this.delete(value));
        existing.ifPresent(this::delete); //this는 해당 클래스의 값들을 다시 받는다
        //전달받은 환자의 id가 존재하는 경우 삭제

        patients.add(patient);
    }

    public List<Patient> findAll() {
        return new ArrayList<>(patients); // 새로운 주소값에 담아 읽기전용
    }

    public Optional<Patient> findById(Long id) {
        return patients.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst();
    }

    public void delete(Patient patient) {
        patients.remove(patient);
    }
}
