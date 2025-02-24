package Day09;

// ---- Inherite (상속) ----
// 물려받는다는 의미. 클래스간의 관계를 나타낸다.
// 기존 클래스가 가지고 있는 기능(멤버) 를 다른 클래스에게 물려준다.
// 상속은 기본적으로 "모든 ~은 ~이다." 라는 관계가 성립된다.
// eg.)
//      Person, Worker, Student 라는 class가 있다고 가정할 때,
//         - 모든 Person 은 Worker 인가? 아니다. 그러면 Person은 Worker를 상속받지 않는 것이다.
//         - 모든 Worker 은 Person 인가? 그렇다. 그러면 Worker은 Person을 상속받고 있다고 보아도 될 것이다.
// 
// 이렇게 Person 처럼 상속을 주는 class 들을 "부모 클래스" 라고 한다
// 또한, Worker 처럼 부모 클래스에게 상속을 받는 class 들을 "자식 클래스" 라고 한다
// 

// 클래스를 상속해주려면 자식 클래스의 선언부에 "extends 부모 클래스명" 을 작성하면 된다.
// eg.) 
//      class Worker extends Person { ... }
// 

// ---- 상속 시의 생성자 ----
// 자식 클래스의 객체를 선언할 때, 부모 클래스의 생성자를 먼저 호출하고 이후 자식 클래스의 생성자를 호출함.
//  - Stack에 부모 클래스의 영역에 대한 공간을 먼저 할당하고 이후 그 공간 안에서 자식 클래스의 공간을 할당하기 때문.
// 

// ---- super 키워드 ----
// 부모 클래스를 참조하는 키워드
// 이름이 중복되는 부모 클래스의 멤버에 접근할 수 있음.
// 이름이 중복되지 않으면 super 를 생략해도 되지만, 명시적으로 작성하는 경우 있음.
// 사용법은 this 키워드와 비슷함.
// super 키워드 원형: super.멤버;
// 

// ---- super 메소드 ----
// 부모 클래스의 생성자를 호출할 때 사용하는 메소드
// 자동으로 호출할 수 있는 부모 클래스의 생성자가 있으면 생략해도 되지만
// 그렇지 않으면 명시적으로 호출해주어야 함.
// this 메소드처럼 명시 시 객체 공간 할당 규칙에 의하여 자식 클래스의 맨 위로 와야함.
// 

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("--- Person Constructor Invoked ---");
    }

    void eat (String food) {
        System.out.println(age + "세의 " + name + "는 " + food+"를 먹는다.");
    }
    
    void sleep () {
        System.out.println(age + "세의 " + name + "는 잠을 잔다.");
    }

}

class Worker extends Person{
    private int eid;

    Worker(String name, int age, int eid) {
        super(name, age);
        // super.name = name;
        // super.age = age;

        this.eid = eid;
        System.out.println("--- Worker Constructor Invoked ---");
    }

    void work () {
        System.out.println(eid + "는 일을 한다.");
    }
}

class Student extends Person {
    private int sid;

    Student(String name, int age, int sid) {
        super(name, age);
        // super.name = name;
        // super.age = age;

        this.sid = sid;
        System.out.println("--- Student Constructor Invoked ---");
    }

    void study () {
        System.out.println(sid + "는 공부를 한다.");
    }
    
}

public class Inheritance {
    public static void main(String[] args) {
        Person P1 = new Person("철수", 20);
        
        String food = "치킨";

        System.out.println("Person 의 객체: ");
        P1.eat(food);
        P1.sleep();
        System.out.println();


        Worker W1 = new Worker("영희", 19, 1111);
        System.out.println("Worker 의 객체: ");
        W1.eat(food);
        W1.sleep();
        W1.work();
        System.out.println();


        Student S1 = new Student("바둑이", 3, 2222);
        System.out.println("Student 의 객체: ");
        S1.eat(food);
        S1.sleep();
        S1.study();
        System.out.println();


    }
}
