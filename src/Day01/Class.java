import java.util.Scanner;

//---- class ----
// 특정한 용도를 수행하기 위해 변수와 함수를 모아둔 타입
// 객체: 클래스를 기반으로 생성된 공간
// 객체는 Attribute(속성) + Method(동작)
// 속성은 멤버 변수(필드)가 동작은 멤버 함수(메소드)로 구성된다.
// 객체 선언 원형: 클래스명 객체명 = new 클래스명();
// 객체 안에 멤버에 접근할 때는 .(도트 연산자)를 사용해서 접근할 수 있다.
// 			ex)	Data d = new Data();
//				d.data1 = 10;
// 
// class 정의 원형:
// 		class 클래스명 {
// 			멤버;
// 		}

//---- 접근 제어 지시자 ----
// 멤버에 접근할 수 있는 사용자를 지정해주는 개념
// public: 공개 멤버로 외부에서도 접근 가능
// private: 비공개 멤버로 같은 클래스 내부에서만 접근 가능

//---- setter ----
// 멤버 변수의 값을 설정해주는 역할의 메소드를 의미한다.
// setter의 반환형은 기본적으로 void로 사용이 된다.
// setter의 매개 변수는 설정할 필드와 같은 자료형을 사용해야 된다.
// setter의 이름은 set뒤에 설정할 멤버 변수의 이름 혹은 직관적인 단어를 붙여준다.
// 			ex)	void setColor(String _color)
// 필드의 값을 설정해주는 역할을 하기 때문에 적절한 예외처리를 같이 진행해줄 수 있다.

//---- getter ----
// 필드의 값을 가져오는 역할의 메소드를 의미한다.
// getter의 반환형은 반환해줄 필드의 자료형과 일치해야 된다.
// getter의 이름은 get 뒤에 반환할 필드의 이름 혹은 직관적인 단어를 붙여준다.
// 			ex)	String getColor()
// 				{	return color;	}
// 
// 

//class Data {
//	int data1;
//	int data2;
//}

class Car {
	private String color = "Red";
	private int maxspeed = 140;
	private int gear = 3;
	
	public void setColor(String _color)
	{
		if (_color == "Red" || _color == "Black" || _color == "White" || _color == "Gray")
			color = _color;
		
		else
		{
			System.out.println("Red, Black, White, Gray 중 하나를 선택해주세요.");
			color = "Red";
		}
	}
	
	public void setMaxspeed(int _maxspeed)
	{
		if (_maxspeed > 190)
		{
			System.out.println("최대 속력이 시속 190km/h를 초과할 수 없습니다.");
			maxspeed = 180;
		}
		else if (_maxspeed < 100)
		{
			System.out.println("최대 속력이 시속 100km/h 미만일 수 없습니다.");
			maxspeed = 180;
		}
		else
			maxspeed = _maxspeed;
	}
	
	public void setGear(int _gear)
	{
		gear = _gear;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public int getMaxspeed()
	{
		return maxspeed;
	}
	
	public int getGear()
	{
		return gear;
	}
	
	public void showInfo()
	{
		System.out.println("색상: " + color);
		System.out.println("최대 속력: " + maxspeed);
		System.out.println("기어: " + gear);
	}
}

public class Class {
	static void clearConsole()
	{
		for(int i = 0; i < 40; i++)
		{
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
//		Data d = new Data();
//		
//		d.data1 = 10;
//		d.data2 = 20;
//		
//		System.out.println("출력: " + d.data1 + " " + d.data2);
		
//		Car Avante = new Car();
//		
//		Avante.setColor("Gray");
//		Avante.setMaxspeed(170);
//		Avante.setGear(4);
//		
//		System.out.println("색상: " + Avante.getColor());
//		System.out.println("최대 속력: " + Avante.getMaxspeed());
//		System.out.println("기어: " + Avante.getGear());
		
//		Avante.showInfo();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("ABCD");
		
		clearConsole();
		System.out.println("Press Enter to continue...");
//		scanner.nextLine();
		scanner.nextLine();
		
		System.out.println("EFGH");
	}
}





