package Day06;

// -- .this 키워드 --
// 자신을 포함한 클래스의 객체를 나타내는 키워드.
// this 키워드로 자신의 객체 내부 멤버들을 사용할 수 있음
// 이때, 사용자가 작성하지 않으면 컴파일러가 자동으로 추가함(생략가능).

// this() 메소드
// 자신이 속한 클래스 내부의 다른 생성자 호출
// 매개변수를 갖는 생성자를 호출할 대는 똑같이 인수값을 작성해주면 됨.

// 내부에 다른 생성자를 작성할 예정이라면 반드시 맨 위에 선언하여 준비가 완료된 이후에 추후 코드를 작성해야함.

class Data {
    private int data1;
    private int data2;
    private int data3;

    // Data() {
    //     data1 = 10;
    //     data2 = 20;
    //     data3 = 30;
    // }

    // Data(int data1) {
    //     this.data1 = data1;
    //     data2 = 20;
    //     data3 = 30;
    // }

    // Data(int data1, int data2) {
    //     this.data1 = data1;
    //     this.data2 = data2;
    //     data3 = 30;
    // }
    
    Data() {
        System.out.println("- 첫번째 생성자 호출");

        data1 = 10;
        data2 = 20;
        data3 = 30;
    }
    Data(int data1) {
        // System.out.println("-- 두번째 생성자 호출"); <-- 오류 발생함. 아래 선언한 다른 생성자가 호출되기 전에 코드를 실행하려고 함
        this();
        this.data1 = data1;
        System.out.println("-- 두번째 생성자 호출");
    }
    Data(int data1, int data2) {
        this(data1);
        this.data2 = data2;
        System.out.println("--- 세번째 생성자 호출");
    }


    public void printData() {
        System.out.println("data1: " + data1);
        System.out.println("data2: " + data2);
        System.out.println("data3: " + data3);
    }
    
}

public class thisKeyword {
    public static void main(String[] args) {
        Data d = new Data();
        d.printData();
        System.out.println();
        d = new Data(100);
        d.printData();
        System.out.println();
        d = new Data(1000, 2000);
        d.printData();
    }
}
