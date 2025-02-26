package Day11;

import java.util.Scanner;

// Q1) 책을 관리하는 프로그램을 작성해보세요
//  - 책, 전자 책은 각 10권까지 등록할 수 있습니다.
//  - 책에 대한 정보는 책 이름, 가격을 포함하고 있습니다.
//  - 전자 책에 대한 정보는 책 이름, 가격, 보안 키를 포함하고 있습니다.
//  - 책의 권 수, 메뉴 선택 값에 대한 예외 처리는 진행하지 않습니다.
// 

// ---- 예시 ----
// -- 책 관리 프로그램 --
//  - 1. 책 등록
//  - 2. 책 목록
// 
// 1. 책 등록
// 어떤 유형의 책을 등록하시겠습니까? 1. 일반 책/ 2. 전자 책
//  - 일반 책
//       - 책 이름, 가격
//  - 전자 책
//       - 책 이름, 가격 보안 키(랜덤 스트링)
// 
// 2. 책 목록
// ---- 일반 책 ----
// 일반 책 목록 및 세부정보
// ---- 전자 책 ----
// 전자 책 목록 및 세부정보
//

class Book {
    Book(String name, int price) {
        this.name = name;
        this.price = price;
        bCnt++;
    }

    private String name;
    private int price;
    private static int bCnt;

    public static int getBcnt() {
        return bCnt;
    }

    void showBookInfo() {
        System.out.println("책 이름: " + name);
        System.out.println("책 가격: " + price);
    }
}

class Ebook extends Book {
    // private String name;
    // private int price;
    private String key;
    private static int bCnt;

    Ebook(String name, int price, String key) {
        super(name, price);
        this.key = key;
        bCnt++;
    }

    public static int getBcnt() {
        return bCnt;
    }

    void showBookInfo() {
        super.showBookInfo();
        System.out.println("보안 키: " + key);
    }
}

public class BookManagementProgram {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[10];
        Ebook[] ebooks = new Ebook[10];
        int select;
        String name, key;
        int price;
        do {
            clearConsole();
            System.out.println("---- Book Management System ----");
            System.out.println("1. register book");
            System.out.println("2. list book");
            System.out.print("Enter: ");
            select = sc.nextInt();

            switch (select) {
                case 1:
                    System.out.println("Select Book Type to Regist");
                    System.out.println("(1. Book | 2. E-Book)");
                    System.out.print("Enter: ");

                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println();
                            System.out.println(" - 1. Book Register Page | Enter Book Info -");
                            System.out.print(" - Book Name: ");
                            name = sc.next();
                            System.out.print(" - Book Price: ");
                            price = sc.nextInt();

                            books[Book.getBcnt() - Ebook.getBcnt()] = new Book(name, price);

                            System.out.println("Book Register Complete");
                            System.out.println("------------------------");
                            break;

                        case 2:
                            System.out.println();
                            System.out.println(" - 2. E-Book Register Page | Enter E-Book Info -");
                            System.out.print(" - E-Book Name: ");
                            name = sc.next();
                            System.out.print(" - E-Book Price: ");
                            price = sc.nextInt();
                            System.out.print(" - E-Book Key: ");
                            key = sc.next();

                            ebooks[Ebook.getBcnt()] = new Ebook(name, price, key);
                            System.out.println("E-Book Register Complete");
                            System.out.println("------------------------");

                            break;
                        default:
                            break;
                    }

                    break;
                case 2:
                    System.out.println("책의 총 권수: " + Book.getBcnt());
                    System.out.println("---- 일반 책 ----");
                    for (int i = 0; i < (Book.getBcnt() - Ebook.getBcnt()); i++) {
                        books[i].showBookInfo();
                        System.out.println();
                    }
                    System.out.println("---- 전자 책 ----");
                    for (int i = 0; i < Ebook.getBcnt(); i++) {
                        ebooks[i].showBookInfo();
                        System.out.println();
                    }
                    break;
                case 3:
                    sc.close();
                    break;
                default:
                    break;
            }
            pauseSystem(sc);
        } while (select != 3);
    }
}
