package Day07;

import java.util.Scanner;

// // Q1) 직원을 고용 및 관리하는 프로그램을 작성해보세요.
//  직원은 최대 100명 까지 고용가능합니다.
//  직원에 대한 정보는 이름, 나이, 급여를 포함하고 있습니다.
//  직원의 인원, 선택값의 예외처리는 진행하지 않습니다.
// - 직원 관리 프로그램 - 
// 1. 직원 고용
// 2. 직원 목록
// 3. 총 인원, 고용 비용 계산

class Employee {
    private String name;
    private int age;
    private int salary;
    private static int employeeCount;
    private static int sumSalary;

    // Class Static
    static {
        System.out.println("Employee Management System Loading...");
        employeeCount = 0;
        sumSalary = 0;
    }

    // Constructor
    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        Employee.employeeCount++;
        Employee.sumSalary += salary;
    }

    // Getter
    public static int getEmployeeCount() {
        return Employee.employeeCount;
    }
    public static int getSumSalary() {
        return Employee.sumSalary;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public int getSalary() {
        return this.salary;
    }

}


public class StaticMember_Practice {
    static String headerString = "---- 직원 관리 프로그램 ----";
    static String[] menuString = {
        "1. 직원 고용",
        "2. 직원 목록",
        "3. 총 고용 비용",
        "4. 종료",
    };
    
    static void showMenu() {
        System.out.println(headerString);
        for (String string : menuString) {
            System.out.println(string);
        }
        System.out.print("입력: ");
    }

    static void clearConsole() {
        for (int i = 0 ; i < 40 ; i++){
            System.out.println();
        }
    }

    static void pauseSystem(Scanner sc) {
        System.out.println("Press Enter to continue...");
        sc.nextLine();
        sc.nextLine();
    }

    static void printMsg(String printMsg) {
        System.out.println(printMsg);
    }
    
    public static void main(String[] args) {
        Employee[] employees = new Employee[100];
        int select, age, salary;
        String name;
        Scanner sc = new Scanner(System.in);

        do {
            showMenu();
            select = sc.nextInt();

            switch (select) {
                case 1:
                    clearConsole();
                    System.out.println(headerString);
                    System.out.println("직원을 고용합니다.");
                    if(100<Employee.getEmployeeCount()) {
                        printMsg("고용 가능한 직원 수 한계에 도달하여 더 이상 고용할 수 없습니다.");
                        printMsg("메인 메뉴로 돌아갑니다.");
                        break;
                    }
                    
                    System.out.print("이름: ");
                    name = sc.next();
                    System.out.print("나이: ");
                    age = sc.nextInt();
                    System.out.print("급여: ");
                    salary = sc.nextInt();
                    
                    employees[Employee.getEmployeeCount()] = new Employee(name, age, salary);
                    break;

                case 2:
                    clearConsole();
                    System.out.println(headerString);
                    System.out.println("직원 리스트");
                    for (Employee employee : employees) {
                        if(employee == null) {
                            break;
                        }
                        System.out.println("이름: " + employee.getName());
                        System.out.println("나이: " + employee.getAge());
                        System.out.println("급여: " + employee.getSalary());
                        System.out.println();
                    }
                    break;

                case 3:
                    clearConsole();
                    System.out.println(headerString);
                    System.out.println("총 고용 비용 계산");
                    System.out.println("현재 총 " + Employee.getEmployeeCount() + "명 만큼 고용하였으며,");
                    System.out.println("총 고용 비용은 " + Employee.getSumSalary() + " 만원 입니다.");
                    break;

                case 4:
                    clearConsole();
                    System.out.println(headerString);
                    System.out.println("직원 관리 프로그램을 종료합니다.");
                    break;
                    
                default:
                    break;
            }
            pauseSystem(sc);        
        } while (select !=4);
        sc.close();
    }
}
