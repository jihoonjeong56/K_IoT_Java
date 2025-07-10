package org.example.test0710.자바OOP구현문제;

interface Playble {
    default void play(){
        System.out.println("악기의 소리는 각기 다릅니다.");
    }
}
class Piano implements Playble {
    String name;
    @Override
    public void play() {
        System.out.println("도레미파솔~");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Guitar implements Playble{
    String name;

    @Override
    public void play() {
        System.out.println("G코드 ~ F코드, 기법: 아르페지오");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Piano piano = new Piano();
        Guitar guitar = new Guitar();
        piano.setName("피아노");
        System.out.println(piano.name);
        piano.play();

        guitar.setName("통기타");
        System.out.println(guitar.name);
        guitar.play();



    }
}
