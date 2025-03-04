package Day14;

import java.util.Scanner;

// Q1. 직원 관리하는 프로그램을 작성해보세요.
// - 사원, 매니저는 총 10명까지 고용할 수 있습니다.
// - 사원에 대한 정보는 이름, 나이, 부서를 포함하고 있습니다.
// - 매니저에 대한 정보는 이름, 나이, 부서, 담당프로젝트를 포함하고 있습니다.
// - 사원의 인원 수, 메뉴 선택 값에 대한 예외 처리는 진행하지 않습니다.
// 

// //
// 1. 직원 고용
// 직원의 직책을 입력해주세요
// 1. 사원, 2 매니저

// 이름: 
// 나이: 
// 부서:
// (매니저만) 담당 프로젝트: 

// //
// 2. 직원 목록
// 목록을 확인할 직급을 선택해주세요
// 1. 모든 직급, 2 사원, 3 매니저

// 각 직급에 대한 정보를 나열

// //
// 3. 업무 지시
// 직원 나열
// idx. 이름(직급)

// (사원) 몇 번 직원에게 업무를 지시하겠습니까?
// 이름 이 부서 의 업무를 봅니다.

// (매니저) 어떤 업무를 지시하겠습니까?
// 1. 일반 업무 2. 회의 소집
// (회의 소집) (부서 전체 이름 나열) 가 소집되었습니다.

// //
// 4. 종료
//  - 종료합니다.

// 부모 객체
class Employee {
    private String name, depart;
    private int age;

    private static int employeeCount;

    Employee(String name, int age, String depart) {
        this.name = name;
        this.age = age;
        this.depart = depart;
        employeeCount++;
    }

    public String getEmployeeName() {
        return name;
    }

    public void showInfo() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("부서: " + depart);
    }

    public void doWork() {
        System.out.println(name + " 이 " + depart + " 의 업무를 봅니다.");
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public String getDeparture() {
        return depart;
    }
}

// 자식 객체
class Manager extends Employee {
    private String prjName;
    // private static int managerCount;

    Manager(String name, int age, String depart, String prjName) {
        super(name, age, depart);
        this.prjName = prjName;
        // managerCount++;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("담당 프로젝트: " + prjName);
    }

    // public static int getManagerCount() {
    // return managerCount;
    // }
}

// ------------ 메인 클래스 ------------
public class Polymphic_Practice {
    static void clearConsole() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    };

    static void pauseSystem(Scanner sc) {
        System.out.println("Press Enter to Continue...");
        sc.nextLine();
        sc.nextLine();
    }

    static final String MAIN_HEADER = "---- 직원 관리 프로젝트 ----";
    static final String[] MAIN_MENU = {
            "1. 직원 고용",
            "2. 직원 목록",
            "3. 업무 지시",
            "4. 종료",
    };

    // ------------ 메인 루틴 ------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[10]; // 부모 클래스로 명시. 나중에 자식 객체를 선언해야함.

        String name, depart, prjName, scString;
        int select, age, scInt;

        do {
            clearConsole();
            System.out.println(MAIN_HEADER);
            for (String str : MAIN_MENU) {
                System.out.println(str);
            }
            System.out.print(" - 입력: ");
            select = sc.nextInt();

            switch (select) {
                // 1. 직원 고용 메뉴
                case 1:
                    clearConsole();
                    System.out.println(MAIN_HEADER);
                    System.out.println(" - 1. 직원 고용 메뉴");
                    System.out.println("직원의 직책을 입력해주세요.");
                    System.out.println("(1. 사원, 2. 매니저)");
                    System.out.print(" - 입력: ");

                    select = sc.nextInt();
                    System.out.println();

                    switch (select) {
                        // 1-1. 평사원 고용
                        case 1:
                            System.out.println("사원을 고용합니다. ");
                            System.out.println("현재 사원 수: " + Employee.getEmployeeCount());
                            System.out.print(" - 이름: ");
                            name = sc.next();
                            System.out.print(" - 나이: ");
                            age = sc.nextInt();
                            System.out.print(" - 부서: ");
                            depart = sc.next();

                            employees[Employee.getEmployeeCount()] = new Employee(name, age, depart);
                            break;
                        // 1-2. 매니저 고용
                        case 2:
                            System.out.println("매니저를 고용합니다. ");
                            System.out.print(" - 이름: ");
                            name = sc.next();
                            System.out.print(" - 나이: ");
                            age = sc.nextInt();
                            System.out.print(" - 부서: ");
                            depart = sc.next();
                            System.out.print(" - 담당 프로젝트: ");
                            prjName = sc.next();
                            employees[Employee.getEmployeeCount()] = new Manager(name, age, depart, prjName);
                            break;

                        default:
                            System.out.println(" - 잘못 입력하였습니다. 메인 메뉴로 돌아갑니다.");
                            break;
                    }
                    select = -1; // select 값 초기화
                    break;
                // 2. 직원 목록 메뉴
                case 2:
                    System.out.println(" - 2. 직원 목록 메뉴");
                    System.out.println("목록을 확인할 직급을 선택해주세요: ");
                    System.out.println("1. 모든 직급, 2. 사원, 3. 매니저");
                    System.out.print(" - 입력: ");
                    select = sc.nextInt();
                    switch (select) {
                        // 2-1. 사원 전체 목록
                        case 1:
                            System.out.println("---- 매니저 목록 ----");
                            for (int i = 0; i < Employee.getEmployeeCount(); i++) {
                                if (employees[i] instanceof Manager) {
                                    employees[i].showInfo();
                                    System.out.println();

                                }
                            }
                            System.out.println();
                            System.out.println("---- 사원 목록 ----");
                            for (int i = 0; i < Employee.getEmployeeCount(); i++) {
                                if (!(employees[i] instanceof Manager)) {
                                    employees[i].showInfo();
                                    System.out.println();
                                }
                            }
                            break;
                        // 2-2. 평사원 목록
                        case 2:
                            for (int i = 0; i < Employee.getEmployeeCount(); i++) {
                                if (!(employees[i] instanceof Manager)) {
                                    employees[i].showInfo();
                                    System.out.println();
                                }
                            }

                            break;
                        // 2-3. 매니저 목록
                        case 3:
                            for (int i = 0; i < Employee.getEmployeeCount(); i++) {
                                if (employees[i] instanceof Manager) {
                                    employees[i].showInfo();
                                    System.out.println();
                                }
                            }
                            break;
                        default:
                        System.out.println(" - 잘못 입력하였습니다. 메인 메뉴로 돌아갑니다.");
                            break;
                    }
                    select = -1; // select 값 초기화
                    break;

                case 3:
                    System.out.println(" - 3. 업무 지시 메뉴");
                    System.out.println("업무를 지시할 직원을 선택하십시오.");
                    for (int i = 0; i < Employee.getEmployeeCount(); i++) {
                        String rank = (employees[i] instanceof Manager) ? "(매니저)" : "(사원)";
                        System.out.println((i + 1) + ". " + employees[i].getEmployeeName() + " " + rank);

                        employees[i].getEmployeeName();
                    }
                    System.out.print(" - 입력: ");
                    select = sc.nextInt();
                    if (employees[select] instanceof Manager) {
                        // 매니저일 경우
                        System.out.println("어떤 업무를 지시하시겠습니까?");
                        System.out.println("(1. 일반 업무, 2. 회의 소집)");
                        System.out.print(" - 입력: ");
                        scInt = sc.nextInt();
                        switch (scInt) {
                            case 1:
                                employees[select].doWork();
                                break;
                            case 2:
                                for (int i = 0; i < Employee.getEmployeeCount(); i++) {
                                    if (employees[i].getDeparture() == employees[select].getDeparture()) {
                                        System.out.print(employees[i].getEmployeeName() + " ");
                                    }
                                }
                                System.out.print("을 회의에 소집했습니다.\n");
                                break;
                            default:
                            System.out.println(" - 잘못 입력하였습니다. 메인 메뉴로 돌아갑니다.");
                                break;
                        }
                    } else {
                        // 평사원일 경우
                        employees[select].doWork();
                    }
                    select = -1; // select 값 초기화
                    break;

                case 4:
                    System.out.println();
                    System.out.println(" - 4. 종료");
                    System.out.println(" -- 직원 관리 프로그램을 종료합니다. --");
                    break;
                default:
                    break;
            }

            pauseSystem(sc);
            // 종료 루틴
            if (select == 4) {
                sc.close();
            }
        } while (select != 4);
    }
}
