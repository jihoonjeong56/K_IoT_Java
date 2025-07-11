package org.example.chapter10;

// === 이벤트 관리 시스템 ===
// : 이벤트 참가자 명단  & 대기열 관리를 위한 시스템
// - 참가자는 사전 등록된 명단을 통해 이벤트 참가(ArrayList)
// - 명단이 가득 찰 경우 대기열 추가(LinkedList), 참가자가 대기열의 다음 사람이 추가

// 1. 이벤트 참가자 명단 관리: 사전 등록, 당일 추가 참가자 등록 안됨
// : ArrayList(목록 추가/삭제 안하고 참가자 조회만 가능)

// 2. 대기열 관리
// : 이벤트의 한정된 좌석, 좌석이 모두 차면 추가 참가자는 대기열에 등록
// : LinkedList(목록 추가 삭제 함, but 조회 안함)

import java.util.ArrayList;
import java.util.LinkedList;

class EventManagement {
    //필드
    ArrayList<String> participantList = new ArrayList<>();
    LinkedList<String> waitingQueue = new LinkedList<>();

    // 메서드
    void addParticipant(String name) {
        participantList.add(name);
    }

    void addToWaitingQueue(String name) {
        waitingQueue.add(name);
    }

    void leaveParticipant(String name) {
        //대기열 인원이 존재해야만 대기열 인원을 참가자 명단에 추가 가능
        if (waitingQueue.size() > 0) {
            String newParticipant = waitingQueue.remove(0);
            addParticipant(newParticipant);
        }
    }
    boolean checkParticipant(String name){
        return participantList.contains(name);
    }
}

public class C_ListPractice{
    public static void main(String[] args) {
        EventManagement eventManagement = new EventManagement();

        eventManagement.addParticipant("a");
        eventManagement.addParticipant("b");
        eventManagement.addParticipant("c");
        eventManagement.addParticipant("d");
        eventManagement.addParticipant("e");

        eventManagement.addToWaitingQueue("A");
        eventManagement.addToWaitingQueue("B");
        eventManagement.addToWaitingQueue("C");
        eventManagement.addToWaitingQueue("D");

        System.out.println(eventManagement.participantList);
        System.out.println(eventManagement.waitingQueue);

        eventManagement.addToWaitingQueue("F");
        eventManagement.addToWaitingQueue("G");

        eventManagement.leaveParticipant("a");
        eventManagement.leaveParticipant("b");
        eventManagement.leaveParticipant("c");

        System.out.println(eventManagement.participantList);
        System.out.println(eventManagement.waitingQueue);

        System.out.println(eventManagement.checkParticipant("A"));
        System.out.println(eventManagement.checkParticipant("D"));
    }
}
