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

}

class Ebook extends Book {
    // private String name;
    // private int price;
    private String key;

}

public class BookManagementProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[10];
        Ebook[] ebooks = new Ebook[10];
        int select;

        System.out.println("---- 책 관리 프로그램 ----");
        System.out.println("1. register book");
        System.out.println("2. list book");
        System.out.print("Enter: ");
        select = sc.nextInt();

        switch (select) {
            case 1:
                System.out.println("어떤 유형의 책을 등록하시겠습니까?");
                System.out.println("(1. 책 | 2. 전자책)");
                System.out.print("Enter: ");

                switch (sc.nextInt()) {
                    case 1:
                        
                        break;
                
                    case 2:

                        break;
                    default:
                        break;
                }

                break;
            case 2:

                break;
            default:
                break;
        }
    }
}
