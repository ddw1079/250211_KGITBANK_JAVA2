package Day13;

// ---- 다형적 표현 (Polymphic Expression) ----
// 다형: 특정 상황에 따라 다른 모양을 띔.
// 상속을 사용하면 클래스를 다른 타입으로 선언할 수 있는 개념.
// 즉, 부모 클래스를 선언할 때 자식 클래스의 타입으로 공간을 할당 받을 수 있다.
//      eg.) Vehicle vehicle = new Car();
// 하지만 자식 클래스의 타입으로 공간을 할당했음에도 불구하고 자식 클래스의 메소드는 사용할 수 없다!
// 

// |   stack   |           Heap
// |---------------------------------------
// |  vehicle  | |brand, maxSpeed                       <-- Vehicle 클래스로 vehicle 객체를 선언하였을 때
// |  vehicle1 | |brand, maxSpeed| carType              <-- Vehicle 클래스로 자식 클래스인 Car 객체를 선언하였을 때.
// |           |                                            Car 객체의 CarType 까지 공간을 할당받았지만... 
// |           |                                            Vehicle 클래스 외부에 존재하여 사용할 수 없다. 
// |  vehicle2 | |brand, maxSpeed| carType| btryLevel   <-- Vehicle 클래스로 손자 클래스인 ElectricCar 객체를 선언하였을 때.
// |           | 
// 

// ---- 업 캐스팅, 다운 캐스팅 ----
// 부모 클래스와 자식 클래스 간의 형 변환 과정
// 업 캐스팅: 자식 클래스 -> 부모 클래스로의 형 변환
//           따로 캐스팅을 명시해주지 않아도 되며, 오류도 발생하지 않음.
// |   stack   |           Heap
// |---------------------------------------
// |  vehicle3 | -------┐                       <-- 업캐스팅 시 자식 클래스에 이미 할당된 부모 클래스를 가리키기 때문에
// |           |        ∀                          그래서 크게 문제될 건 없음. 
// |    car    | ||brand, maxSpeed|| carType 
// 

// 다운 캐스팅: 부모 클래스 -> 자식 클래스로의 형 변환
//             
// |   stack   |           Heap
// |---------------------------------------
// |  vehicle3 | |brand, maxSpeed| carType      <-- 다운캐스팅 시 자식 클래스와 같은 공간을 할당하도록 만들어야 함.     
// |           |                                    
// |    car    |                                <-- 다운캐스팅 시 자식 클래스로 형 변환 함을 작성해주어야 함!


class Vehicle {
    private String brand;
    private int maxSpeed;

    Vehicle(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public void showInfo() {
        System.out.println("현재 이동 수단의 브랜드는 " + brand + " 이며");
        System.out.println("최고 속력은 " + maxSpeed + "km/h 입니다");
    }

}

class Car extends Vehicle {
    // private String brand;
    // private int maxSpeed;
    private String carType;

    Car(String brand, int maxSpeed, String carType) {
        super(brand, maxSpeed);
        this.carType = carType;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("또한, 현재 차량 타입은 " + carType + "입니다.");
    }

    public void showCarInfo() {
        super.showInfo();
        System.out.println("또한, 현재 차량 타입은 " + carType + "입니다.");
    }
}

class ElectricCar extends Car {
    // private String brand;
    // private int maxSpeed;
    // private int carType;
    private int batteryLevel;

    ElectricCar(String brand, int maxSpeed, String carType, int batteryLevel) {
        super(brand, maxSpeed, carType);
        this.batteryLevel = batteryLevel;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("그리고, 현재 배터리 잔량은 " + batteryLevel + "입니다.");
    }

    public void showElecCarInfo() {
        super.showInfo();
        System.out.println("그리고, 현재 배터리 잔량은 " + batteryLevel + "입니다.");
    }
}

public class Polymphic02 {
    // @SuppressWarnings("unused")
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Hyundai", 190);
        Vehicle vehicle1 = new Car("Hyundai", 190, "Sedan");
        Vehicle vehicle2 = new ElectricCar("Hyundai", 190, "Sedan", 70);

        // vehicle.showCarInfo(); // <-- 오류 발생! showCarInfo() 는 Vehicle 클래스에 선언되어있지 않음
        // vehicle.showInfo(); // <-- 하지만 showInfo() 는 선언되어있음.
        // vehicle1.showInfo();
        // vehicle2.showInfo();

        // 업캐스팅
        Vehicle vehicle3;
        Car car = new Car("Hyundai", 190, "Sedan");

        vehicle3 = car; // <-- vehicle3 = (Vehicle) car 과 같음. 업캐스팅은 명시해주지 않아도 자동으로 진행되며 별도의 다른 문제는 발생하지 않음.
        vehicle3.showInfo();

        // 다운캐스팅
        Vehicle vehicle4 = new Vehicle("Hyundai", 190);
        Car car2;

        // vehicle4.showInfo();

        // car2 = vehicle4; // <--오류 발생! Vehicle 클래스는 자식 클래스인 Car 만큼의 공간이 할당되지 않았음.

        Vehicle vehicle5 = new Car("Hyundai", 190, "Sedan");
        Car car3;
        ElectricCar eCar;
        // vehicle5.showInfo();

        // car3 = vehicle5;               // <-- 오류 발생! Vehicle 클래스인 vehicle5 는 Car 클래스와 맞지 않음.
        car3 = (Car)vehicle5;             //
        // eCar = (ElectricCar) vehicle5; // <-- 오류 발생! ElectricCar 만큼의 공간이 vehicle5에 할당되어있지 않음.
    }
}
