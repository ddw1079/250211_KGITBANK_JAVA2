package Day10;

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
    private String name;
    private int price;

    Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    void getBookInfo() {
        System.out.println("- 책 이름: " + this.name);
        System.out.println("- 책 가격: " + this.price);
    }
}

class Ebook extends Book {
    private String SecurityCode;

    Ebook(String name, int price, String SecurityCode) {
        super(name, price);
        this.SecurityCode = SecurityCode;
    }

    void getBookInfo() {
        super.getBookInfo();
        System.out.println("- 보안 키: " + SecurityCode);
    }
}

public class Inheritance_Practice {
    static final String HEADER_STR = "---- 책 관리 프로그램 ----";
    static final String MENU_STR_ARR[] = {
        "1. 책 등록",
        "2. 책 목록",
        "3. 종료",
    };

    static final void showMenu() {
        System.out.println(HEADER_STR);
        for (String str : MENU_STR_ARR) {
            System.out.println(str);
        }
        System.out.print("입력: ");
    };

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
        
        String name, secCodeString;
        int select, price, scInt, tempInt;
        
        do {
            clearConsole();
            showMenu();
            select = sc.nextInt();
            
            switch (select) {
                case 1:
                    System.out.println(HEADER_STR);
                    System.out.println("책 등록 메뉴");
                    System.out.println("등록할 책의 종류 번호를 입력하십시오: 1. 일반 책; 2. 전자 책");
                    System.out.print("입력: ");
                    scInt = sc.nextInt();
                    sc.nextLine();

                    if(scInt == 1) {
                        System.out.println("일반 책을 등록합니다.");
                        System.out.print("책 제목: ");
                        name = sc.nextLine();
                        System.out.print("책 가격: ");
                        price = sc.nextInt();
                        for (int i = 0; i < books.length; i++) {
                            if (books[i] == null) {
                                books[i] = new Book(name, price);
                                break;
                            }
                        }
                    } else if(scInt == 2) {
                        System.out.println("전자 책을 등록합니다.");
                        System.out.print("책 제목: ");
                        name = sc.nextLine();
                        System.out.print("책 가격: ");
                        price = sc.nextInt();
                        // 입력버퍼 초기화
                        sc.nextLine();
                        System.out.print("책 보안 키: ");
                        secCodeString = sc.nextLine();
                        for (int i = 0; i < ebooks.length; i++) {
                            if (ebooks[i] == null) {
                                ebooks[i] = new Ebook(name, price, secCodeString);
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println(HEADER_STR);
                    System.out.println("책 목록: ");
                    System.out.println("-- 일반 책 --");
                    // book 개수 체크용
                    tempInt = 0;
                    for (int i = 0; i < books.length; i++) {
                        if (books[i] != null) {
                            books[i].getBookInfo();
                            System.out.println();
                            tempInt++;
                        }
                    }
                    System.out.println("\n => 일반 책 개수: " + tempInt + " / " + books.length);
                    System.out.println("\n");
                    System.out.println("-- 전자 책 --");
                    // book 개수 체크용
                    tempInt = 0;
                    for (int i = 0; i < ebooks.length; i++) {
                        if (ebooks[i] != null) {
                            ebooks[i].getBookInfo();
                            tempInt++;
                        }
                    }
                    System.out.println("\n => 전자 책 개수: " + tempInt + " / " + books.length);
                    break;
                case 3:
                    System.out.println("책 관리 프로그램을 종료합니다.");
                    break;
                default:
                    break;
            }
            pauseSystem(sc);

        } while (select != 3);
        sc.close();
    }
}
