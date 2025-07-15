package org.example.chapter13;

/*
    ==빌더로 게임 캐릭터 생성
    1) 필수: 이름(String) 분류(String)
    2) 선택: 스킬(String) 아이템(String)
 */
class GameCharacter {
    //필수 사항
    private final String name;
    private final String sort;
    //선택사항
    private final String skill;
    private final String item;

    public static class Builder {
        private final String name;
        private final String sort;
        //선택사항
        private String skill = "기본공격";
        private String item = "없음";

        public Builder(String name, String sort) {
            this.name = name;
            this.sort = sort;
        }

        public Builder skill(String skill) {
            this.skill = skill;
            return this;
        }

        public Builder item(String item) {
            this.item = item;
            return this;
        }

        public GameCharacter build() {
            return new GameCharacter(this);
        }

    }

    public GameCharacter(Builder builder) {
        this.name = builder.name;
        this.sort = builder.sort;
        this.skill = builder.skill;
        this.item = builder.item;
    }

    @Override // 출력을 위한 오버라이딩
    public String toString() {
        return "이름: " + name
                + ", 종족: " + sort
                + ", 스킬: " + skill
                + ", 장비: " + item;
    }
}

public class F_Builder {
    public static void main(String[] args) {
        GameCharacter pororo = new GameCharacter.Builder("뽀로로", "펭귄")
                .skill("크롱놀리기").item("안경").build();
        GameCharacter loopy = new GameCharacter.Builder("루피", "비버")
                .skill("정색").item("잔망루피").build();

        System.out.println(pororo);
        System.out.println(loopy);
    }
}
