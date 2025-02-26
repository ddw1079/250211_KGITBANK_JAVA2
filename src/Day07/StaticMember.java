package Day07;

//  ---- 기본적인 객체 선언 방식 ----
//      |     Stack       |                 Heap                 |       Method      |
// -----|-----------------------------------------------------------------------------
// main |      p1         |  name("철수"),age(24),popularity(++)  |                   |
//      |      p2         |  name("영희"),age(23),popularity(++)  |                   |
// 객체 멤버 이름이 Stack 에 선언되고 그 멤버들이 Heap 에 저장된다.
// 

//  ---- Static 필드 ----
//  static 필드는 일반 필드와는 다르게 그 클래스의 객체 모두가 공용으로 사용한다. 
//  이 static 필드는 객체 선언과는 상관없이 Method 영역에 공간을 할당 받아두고 각 객체가 공용으로 접근하게 된다.
//  클래스 이름을 통해 접근할 수 있다.
//          eg.) Person.popularity;
// 
//      |     Stack       |                 Heap                 |       Method      |
// -----|-----------------------------------------------------------------------------
// main |      p1         |  name("철수"),age(24),popularity-->   |static popularity()|
//      |      p2         |  name("영희"),age(23),popularity-┘    |                   |
// 
//  - 물론 객체의 이름으로도 접근할 수 있지만 이러한 방법을 사용할 경우 static-warning 경고 발생함.
//  = 객체의 이름으로 접근해서 사용해도 문제는 없지만, 이러한 방법을 사용할 경우 객체가 선언되지 않은 경우(Null)에는 사용할 수 없고,
//    또한 코드의 일관성을 해칠 수 있음. 
//  ∴ 따라서 객체의 이름으로 접근하는 방법은 지양되어야 함.
//     보통의 경우에는 Private로 묶여있어 Getter나 Setter 를 거쳐 사용하는 방식을 사용함.
// 

// ---- Static 메소드 ----
// 일반 메소드와는 다르게 클래스에 속해있는 메소드. static 필드에 접근할 때 사용하는 메소드.
// static 메소드를 정의할 때는 메소드 반환형 앞에 static 키워드를 작성한다.
// static 필드와 마찬가지로 클래스를 통해 접근 가능.
//          eg.) Person.getPopularity();
// static 메소드는 객체가 아닌 클래스를 이용해 호출하기 때문에 static 필드에만 접근할 수 있다.
// 

// ---- Static 초기화 블록 ----
// static 필드를 초기화 할 때 사용하는 문법.
// 일반 객체는 생성자로 초기화 할 수 있지만... 클래스로 인해 호출되는 static 필드는?
// 클래스의 생성자 라고 이해하면 될 것.
// 이 코드는 처음 클래스가 로딩되는 시점에서 단 한번 실행됨.
// static 초기화 블록 원형:
//      static {
//          실행할 코드;
//      }
// 

class Person {
    private String name;
    private int age;
    private static int popularity = 2;

    static {
        System.out.println("static 초기화 블록 실행");
        popularity = 6;
    }
    
    public static int getPopularity() {
        // System.out.println("name: " + this.name);    // <-- static 메소드에서는 사용 불가능
        // System.out.println("age: " + age);           // <-┘ 
        return popularity;
        }
    
        Person(String name, int age) {
            // this.popularity += 5; // <-- 이렇게도 접근이 되지만 static-access warning 발생.
            this.name = name;
            this.age = age;
            popularity++;
        }
    
        void printData() {
            System.out.println("name: " + name);
            System.out.println("age: " + age);
        }

        // Getter
        public int _getPopularity() {
            return popularity;
        }
    }
        
    public class StaticMember {
        @SuppressWarnings("unused")
        public static void main(String[] args) {
            
            Person p1 = new Person("철수", 24);
            Person p2 = new Person("영희", 23);
            Person p3 = new Person("바둑이", 3);

            
    
            System.out.println("현재 인원: " + Person.getPopularity());
            // System.out.println("현재 인원: " + p1._getPopularity()); // <-- 이 접근법도 가능하긴 하지만 static-access warning 발생.
            //                                                         //  └- 코드의 일관성을 위해서라도 이러한 방법은 지양되어야 함.
    }
}
