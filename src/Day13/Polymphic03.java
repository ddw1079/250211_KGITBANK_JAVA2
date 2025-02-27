package Day13;

// ---- instanceof ----
// 객체가 해당 클래스로 변환이 가능한지 확인하여 true|false 반환.
// instanceof 의 원형: 변환할 대상 instanceof 변환할 클래스
// 

// ---- 오버라이딩(Overriding) ----
// override: 우선시하다.    overriding: 우선시 되는
// 부모 클래스의 메소드를 자식 클래스가 재정의 하는 개념
// 부모와 자식 클래스에 같은 이름의 메소드가 존재할 때, "어디에 공간이 할당되었는지" 에 따라 그 클래스의 메소드가 실행된다.
// 

// |   stack   |           Heap
// |---------------------------------------
// |  Vehicle  | new Vehicle    {showInfo()}  <-- Vehicle 클래스의 공간을 할당하여 Vehicle 내부의 showInfo 메소드를 사용함
// |  Vehicle  | new Car        {showInfo()}  <-- Car 클래스의 공간을 할당하여 Car 내부의 showInfo 메소드를 사용함
// |  Vehicle  | new ElectricCar{showInfo()}  <-- ElectricCar 클래스의 공간을 할당하여 ElectricCar 내부의 showInfo 메소드를 사용함
// 
// Overriding 기능을 사용하려면 메소드 이름, 반환형, 매개변수가 동일해야 한다.
// 또한, Overriding 할 메소드는 부모 클래스에 반드시 존재해야 한다.
// 

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


public class Polymphic03 {
    // @SuppressWarnings("unused")
    public static void main(String[] args) {
        Vehicle vehicle = new Car("Hyundai", 190, "Sedan");
        Car car;
        ElectricCar eCar;

        // ---- instanceof ----
        // 객체가 해당 클래스로 변환이 가능한지 확인하여 true|false 반환.
        // instanceof 의 원형: 변환할 대상 instanceof 변환할 클래스
        if (vehicle instanceof Car) {
            System.out.println("vehicle 객체는 Car 클래스로 변환이 가능합니다");
        } else {
            System.out.println("vehicle 객체는 Car 클래스로 변환이 불가능합니다");
        }

        if (vehicle instanceof ElectricCar) {
            System.out.println("vehicle 객체는 ElectricCar 클래스로 변환이 가능합니다");
        } else {
            System.out.println("vehicle 객체는 ElectricCar 클래스로 변환이 불가능합니다");
        }
        
        // Overriding
        Vehicle vehicle1 = new ElectricCar("Hyundai", 190, "Sedan", 90);
        vehicle1.showInfo();
    }
}
