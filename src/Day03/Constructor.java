// -- 생성자 --
// 특정 클래스의 객체가 선언될 때 자동으로 호출되는 메소드
// 일반적으로 필드의 기본값 또는 사용자 제공 값으로 초기화하는 용도로 사용된다.
// 생성자 특징:
// 1. 클래스와 같은 이름을 지닌다.
// 2. 리턴하지도 않고 반환형도 선언하지 않는다.
// 3. 매개변수를 가질 수 있으며, 오버로딩(같은 이름의 함수를 다른 형태로 선언) 하는 것이 가능

// -- Default 생성자 --
// 객체가 선언되기 위해서는 반드시 하나의 생성자가 호출되어야 하며,
// 생성자가 정의되지 않은 객체에도 기본적으로 생략된 생성자가 존재함. 이를 Default 생성자 라고 함.
// 생성자가 하나라도 정의되었다면 Default 생성자는 사라짐.

package Day03;

class Data {
    private int data1;
    private int data2;
    
    Data() {
        System.out.println("Constructor Called!");
        data1 = 10;
        data2 = 20;
    }

    Data(int data1, int data2) {
        System.out.println("Constructor Called!");
        this.data1 = data1;
        this.data2 = data2;
    }
    
    public void printData() {
        System.out.println("data1: " + data1);
        System.out.println("data2: " + data2);
    }
}

class Data2 {
    // Default 생성자
    // Data2() {}
    private int data;
    Data2(int data) {
        this.data = data;
    }
}

public class Constructor {
    public static void main(String[] args) {
        Data d1 = new Data();
        d1.printData();

        Data d2 = new Data(1111, 2222);
        d2.printData();

        // Data2 d3 = new Data2(); <--- !오류! Data2에는 생성자가 정의되었기 때문에 오류 발생
    }
}