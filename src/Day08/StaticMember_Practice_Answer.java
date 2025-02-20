package Day08;

import java.util.Scanner;

class Employee {
    private String name;
    private int age, salary;

    private static int ecnt, totalSalary;

    static {
        ecnt = 0;
        totalSalary = 0;
    }

    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        ecnt++;
        totalSalary += salary;
        System.out.println(name + "직원을 고용했습니다. ");
    }

    public static int getEcnt() {
        return ecnt;
    }

    public static int getTotalSalary() {
        return totalSalary;
    }

    public void employeeInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

public class StaticMember_Practice_Answer {
    static void clearConsole() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    static void pauseSystem(Scanner sc) {
        System.out.println("Press Enter to Continue...");
        sc.nextLine();
        sc.nextLine();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[100];
        int select;

        String name;
        int age, salary;
        do {
            System.out.println("--Employees Management Program--");
            System.out.println("1. Hire Employee");
            System.out.println("2. List Employee");
            System.out.println("3. Employee Salary Sum");
            System.out.print("Enter: ");
            select = sc.nextInt();

            switch (select) {
                case 1:
                    clearConsole();
                    System.out.println("--Employees Management Program--");
                    System.out.print("Employee Name: ");
                    name = sc.next();
                    System.out.print("Employee Age: ");
                    age = sc.nextInt();
                    System.out.print("Employee Salary: ");
                    salary = sc.nextInt();

                    employees[Employee.getEcnt()] = new Employee(name, age, salary);
                    pauseSystem(sc);
                    break;
                case 2:
                    clearConsole();
                    System.out.println("--Employees Management Program--");
                    System.out.println("직원 목록: ");
                    for (int i = 0; i < Employee.getEcnt(); i++) {
                        employees[i].employeeInfo();
                    }
                    break;
                case 3:
                    clearConsole();
                    System.out.println("--Employees Management Program--");
                    System.out.println("You Now have " + Employee.getEcnt() + " employees,");
                    System.out.println("and your Total Cost of Salary is ￦" + Employee.getTotalSalary() + "0K.");

                    break;

                default:
                    break;
            }
        } while (true);

        // sc.close();
    }
}
