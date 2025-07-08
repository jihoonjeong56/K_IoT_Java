package org.example.chapter07.review;

class Employee {
    private final String EmployeeId;
    private String name;
    private String position;
    private int salary;

    Employee(String EmployeeId, String name, String position, int salary) {
        this.EmployeeId = EmployeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }


    //사원 정보 출력 메서드
    void displayInfo() {
        System.out.println("사원 ID: " + EmployeeId + ", 이름: " + name + ", 직급: " + position + ", 급여: " + salary);
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("이름을 '" + name + "' 으로 변경합니다.");
    }

    public void setPosition(String position) {
        this.position = position;
        System.out.println("직급을 '" + position + "' 으로 변경합니다.");
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            System.out.println("급여를 " + salary + "으로 변경을 시도합니다.");
        } else {
            System.out.println("급여를 " + salary + "으로 변경을 시도합니다.");
            this.salary = salary;
        }
    }
}
class Manager extends Employee{
    private final int teamSize;
    Manager(String EmployeeId, String name, String position, int salary, int teamSize) {
        super(EmployeeId, name, position, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
    }

    public int getTeamSize() {
        return teamSize;
    }
}

public class Practice_Test {
    public static void main(String[] args) {
        Employee employee = new Employee("E001", "조성민","대리",3500000);
        employee.displayInfo();
        employee.setName("조승범");
        employee.setSalary(-500000);
        employee.displayInfo();

        Manager manager = new Manager("M001","ㄷㄴㅇㄹ","매니저",3000000,5);
    }
}
