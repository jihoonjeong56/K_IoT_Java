package org.example.chapter14;


// ==직원관리 시스템==//

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 직원 데이터 정의
@AllArgsConstructor
@Getter
@ToString
class Employee {
    private String department; //부서
    private String name;// 이름
    private int salary;//급여
}

public class K_Practice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("IT", "이승아", 300),
                new Employee("HR", "조승범", 500),
                new Employee("IT", "김준일", 400),
                new Employee("OP", "전예찬", 350),
                new Employee("HR", "윤대휘", 380)
        );

        // 1. 급여가 400 이상인 직원 '필터링'
        // : filter() - 조건을 검사해서 true인 요소만을 다시 반환
        List<Employee> filteredEmployee = employees.stream()
                .filter(employee -> employee.getSalary() >= 400)
                .toList();
        System.out.println("급여가 400 이상인 직원");
        filteredEmployee.forEach(System.out::println);

        // 2. IT 부서 직원의 이름만 추출
        // 1) 부서(department)가 'IT'인 직원을 필터링 - filter
        // 2) 부서가 'IT'인 직원 목록을 전체 순회하여 이름만 추출 - map
        List<String> employeesName = employees.stream()
                .filter(employee -> "IT".equals(employee.getDepartment()))
                .map(Employee::getName)
                .collect(Collectors.toList());
        //.toList();
        System.out.println("부서가 IT인 직원 이름만 추출");
        employeesName.forEach(System.out::println);

        // 3. 특정 부서(HR) 직원 중 이름에 '조'가 포함된 직원 필터링
        // 1) 부서가 'HR'인 직원을 필터링 >> equals
        // 2) 위의 목록 중 이름에 '조'가 포함된 직원을 필터링 >> contains
        List<Employee> employeeDepart = employees.stream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .filter(employee -> employee.getName().contains("조"))
                .collect(Collectors.toList());
        //.toList();
        System.out.println("'HR' 부서중 이름에  '조'가 포함된 직원");
        employeeDepart.forEach(System.out::println);


        // 4. 부서별 직원 그룹화
        // Collectors 클래스 - groupingBy
        System.out.println("부서별 직원 그룹화");
        Map<String, List<Employee>> groupedByDepart = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDepart.forEach(((string, employees1) -> {
            System.out.println(string + " | " + employees1);
        }));
        for (Map.Entry<String, List<Employee>> entry : groupedByDepart.entrySet()) {
            String department = entry.getKey();
            List<Employee> employeeInDept = entry.getValue();

            System.out.println(department + ": ");
            for (Employee employee : employeeInDept) {
                System.out.print(employee.getName() + " ");
            }
            System.out.println();


        }
        // 5. 부서별 평균 급여 계산
        // Collector 클래스 - groupingBy, averaging 타입: 해당 타입의 평균을 계산(averagingInt(각 직원의 급여 전달))
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
        System.out.println(avgSalaryByDept);


    }
}
