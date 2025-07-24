package org.example.user_reservation.repository;

import lombok.ToString;
import org.example.user_reservation.entity.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@ToString
public class ReservationRepository {
    private final List<Reservation> reservations = new ArrayList<>();

    //예약 등록 (Create)
    // : DB에 새로운 예약을 저장
    // : 요청값 = 예약 정보, 응답 = 없음
    public void save(Reservation reservation) {
            reservations.add(reservation);
    }

    // 조회 (Read)
    // : 단건예약에 대한 조회(reservationId를 사용)
    // : 용청값 = 예약 고유번호, 응답 = 예약 정보

    public Optional<Reservation> findById(Long reservationId) {
        return reservations.stream()
                .filter(res ->res.getReservationId().equals(reservationId))
                .findFirst(); // 검색된 조건에 일치하는 요소중 제일 첫 번째 요소를  Optional로 반환
    }

    // : 예약자 정보와 일치하는 예약을 조회 (userId를 사용)
    // : 요청값 = 사용자 id, 응답 = 예약 정보 리스트
    public List<Reservation> findByUserId(String userId) {
        return reservations.stream()
                // 해당 예약자의 리스트 중 예약이 유효한 목록만 확인
                .filter(res-> res.getUserId().equals(userId) && res.isActive())
                .toList();
    }
    // 취소 (Update)
    // : (현재 프로젝트에서는 DB 없이 객체 내부의 상태만 변경) - 취소 자체의 로직은 없음(현재 프로젝트 한정)

}
