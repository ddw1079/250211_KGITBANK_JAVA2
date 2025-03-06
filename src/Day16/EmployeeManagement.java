package Day16;

import java.util.Scanner;

// // Day14\Polymphic_Practice 정답
// 

// 부모 클래스 Employee
class Employee {
    // field
    private String name, department;
    private int age;
    private static int ecnt;

    // Constructor
    Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
        ecnt++;
    }

    public static int getEcnt() {
        return ecnt;
    }

    public void showInfo() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("부서: " + department);
    }

    public String showName() {
        return name + "(사원)";
    }

    public String getName() {
        return name;
    }

    public void work() {
        System.out.println(name + " 이/가 " + department + " 의 업무를 봅니다.");
    }
}

// 자식 클래스 Manager - Employee 상속
class Manager extends Employee {
    // field
    private String project;

    // Constructor
    Manager(String name, int age, String department, String project) {
        super(name, age, department);
        this.project = project;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("담당 프로젝트: " + project);
    }

    public String showName() {
        return super.getName() + "(매니저)";
    }

    public void createCommitee() {

    }
}

// Main Class
public class EmployeeManagement {
    static void clearConsole() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    };

    static void pauseSystem(Scanner sc) {
        System.out.println("계속하려면 아무 키나 누르십시오...");
        sc.nextLine();
        sc.nextLine();
    }

    // Main Routine
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employee = new Employee[10];
        int select, eselect, rank, age;
        String name, department, project;
        while (true) {
            clearConsole();
            System.out.println("---- 직원 관리 프로그램 ----");
            System.out.println("1. 직원 고용");
            System.out.println("2. 직원 목록");
            System.out.println("3. 업무 지시");
            System.out.println("4. 종료");
            System.out.print(" - 입력: ");
            select = sc.nextInt();

            switch (select) {
                case 1:
                    clearConsole();
                    System.out.println("---- 직원 관리 프로그램 ----");
                    System.out.println("직원의 직책을 입력해주세요.");
                    System.out.println("(1. 사원, 2. 매니저)");
                    System.out.print(" - 입력: ");
                    rank = sc.nextInt();

                    System.out.print("이름 입력: ");
                    name = sc.next();
                    System.out.print("나이 입력: ");
                    age = sc.nextInt();
                    System.out.print("부서 입력: ");
                    department = sc.next();

                    switch (rank) {
                        case 1:
                            employee[Employee.getEcnt()] = new Employee(name, age, department);
                            System.out.println("직원을 고용했습니다.");
                            break;
                        case 2:
                            System.out.print("담당 프로젝트 입력: ");
                            project = sc.next();

                            employee[Employee.getEcnt()] = new Manager(name, age, department, project);
                            System.out.println("매니저를 고용했습니다.");
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    clearConsole();
                    System.out.println("---- 직원 관리 프로그램 ----");
                    System.out.println("목록을 확인할 직급을 선택해주세요.");
                    System.out.println("1. 모든 직급, 2. 사원, 3. 매니저");
                    System.out.print("입력: ");
                    rank = sc.nextInt();

                    switch (rank) {
                        case 1:
                            System.out.println("---- 모든 직원 목록 ----");
                            for (int i = 0; i < Employee.getEcnt(); i++) {
                                employee[i].showInfo();
                                System.out.println();
                            }
                            break;
                        case 2:
                            System.out.println("---- 일반 사원 목록 ----");
                            for (int i = 0; i < Employee.getEcnt(); i++) {
                                if (!(employee[i] instanceof Manager)) {
                                    employee[i].showInfo();
                                    System.out.println();
                                }
                            }
                            break;
                        case 3:
                            System.out.println("---- 매니저 목록 ----");
                            for (int i = 0; i < Employee.getEcnt(); i++) {
                                if (employee[i] instanceof Manager) {
                                    employee[i].showInfo();
                                    System.out.println();
                                }
                            }
                            break;
                        default:

                            break;
                    }
                    break;
                case 3:
                    clearConsole();
                    System.out.println("---- 직원 관리 프로그램 ----");
                    System.out.println("업무를 지시할 직원을 선택하십시오.");
                    for (int i = 0; i < Employee.getEcnt(); i++) {
                        System.out.println((i + 1) + ". " + employee[i].showName());
                    }
                    System.out.print(" - 입력: ");
                    eselect = sc.nextInt();

                    if(employee[--eselect] instanceof Manager) {
                        // Manager 일때
                        
                    } else {
                        // Employee 일때

                    }
                    break;
                case 4:

                    break;
                default:
                    break;
            }

            pauseSystem(sc);
        }

    }
}