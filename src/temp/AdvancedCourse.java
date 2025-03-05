package temp;

import java.util.Scanner;

// ---- Scanner nextInt() ----
//  Scanner의 nextInt() 는 숫자가 입력될때까지 입력받고 입력받으면 숫자 앞의 버퍼는 삭제함.
//  이후 개행은 삭제하지 않아 다음에 nextLine() 을 사용할 때는 개행을 삭제해주어야함.
// 

// ---- String 비교 시에 == 비교 연산자가 아닌 String 객체 내부의 .equals() 메소드를 사용해야 하는 이유? ----
//  기본적으로 String은 객체 형태이다.
//  예시로, String a = new String("a") 로 선언했다면 a는 String 객체의 참조 변수가 되고, 그 객체 내부에 "a" 값이 저장되는 것이다!
//  또한, String b = scanner.next() 로 선언했다면 b는 String 객체의 참조 변수가 되고, 스캐너가 입력 버퍼에서 객체 내부로 "a" 값을 저장하는 것이다!
//  이에 String a 와 String b 는 다른 공간의 참조값을 가지고 있기에 == 비교 연산으로는 항상 false 값이 나온다.
//  따라서 String 비교를 하기 위해서는 String 객체 내부의 메소드 .equals() 를 사용해야 한다.
//  
//  - 하지만! a 와 b 에 각각 "" 큰따옴표 로 묶이는 string 리터럴 상수를 넣는다면 이야기는 달라진다.
//    리터럴 상수는 메모리 공간 내부에 별도로 상수만을 위한 공간이 존재하며, 또한 선언 시에 그 공간을 가리키도록 한다.
//    예시로, a = "a"; 라고 선언하였으면 String a 는 상수 메모리 공간 내에 "a" 를 생성하여 가리킨다.
//    b = "a"; 로 선언했다면 String b 또한 상수 메모리 공간 내의 "a" 를 찾아서 가리키므로 결과적으로 a == b 가 성립된다.
// 

public class AdvancedCourse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = new String("abc");
        String b = "abc";
        // System.out.print("a 입력: ");
        // a = sc.next();
        // System.out.print("b 입력: ");
        // b = sc.next();

        // 다르다고 나오는 이유: String a 는 객체로써 선언이 되었고, String b 는 리터럴 상수로써 상수 공간 내의 "abc"를 가리키기 때문
        // scanner 로 입력을 받으면 입력 버퍼에서 객체로 바로 쏴주기 때문에 .equals() 를 사용해야함.
        if (a == b) {
            System.out.println(a + " 와 " + b + " 는 같다!");
        } else {
            System.out.println(a + " 와 " + b + " 는 다르다!");
        }

        // System.out.println("a: " + a);
        // System.out.println("b: " + b);

        sc.close();
    }
}
