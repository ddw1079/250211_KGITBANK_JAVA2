package Day12;

// ---- 다형적 표현 (Polymphic Expression) ----
// 다형: 특정 상황에 따라 다른 모양을 띔.
// 상속을 사용하면 클래스를 다른 타입으로 선언할 수 있는 개념.
// 즉, 부모 클래스를 선언할 때 자식 클래스의 타입으로 공간을 할당 받을 수 있다.
// 하지만 자식 클래스의 타입으로 공간을 할당했음에도 불구하고 자식 클래스의 메소드는 사용할 수 없다!
// 
// 
// 
// 

class A {
    A() {
        System.out.println("A Constructor Invoked....");
    }
}

class B extends A {
    B() {
        System.out.println("B Constructor Invoked....!");
    }

    public void show() {
        System.out.println("B Class Method show() just called...!!!!");
    }
}

public class Polymphic {
    public static void main(String[] args) {
        A a = new B();
        // a.show(); // <-- 이렇게는 사용할 수 없다! (The method show() is undefined for the type A)
        // B b = new B();
    }
}
