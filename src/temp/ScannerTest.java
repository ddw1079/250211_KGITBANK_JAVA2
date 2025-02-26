package temp;

import java.util.Scanner;

// ---- Scanner nextInt() ----
// Scanner의 nextInt() 는 숫자가 입력될때까지 입력받고 입력받으면 숫자 앞의 버퍼는 삭제함.
// 이후 개행은 삭제하지 않아 다음에 nextLine() 을 사용할 때는 개행을 삭제해주어야함.
// 

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("입력: ");
        sc.nextLine();

        sc.close();
    }
}
