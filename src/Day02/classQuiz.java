import java.util.Scanner;

class TV {
	private int channel = 1;
	private int volume = 5;
	
	public void inputSetChannel(int _channel)
	{
		if (_channel >= 1 && _channel <= 999)
		{
			channel = _channel;
			System.out.println("채널을 " + channel + "(으)로 변경했습니다.");
		}
		else
			System.out.println("1 ~ 999 중 하나의 채널을 입력해주세요.");
	}
	
	public void channelUp()
	{
		if (channel >= 999)
			channel = 1;
		
		else
			channel++;

		System.out.println("채널을 올렸습니다.");
	}
	
	public void channelDown()
	{
		if (channel <= 1)
			channel = 999;
		
		else
			channel--;
		
		System.out.println("채널을 내렸습니다.");
	}
	
	public void volumeUp()
	{
		if (volume >= 100)
			System.out.println("볼륨을 더 이상 올릴 수 없습니다.");
		
		else
		{
			volume++;
			System.out.println("볼륨을 올렸습니다.");
		}
	}
	
	public void volumeDown()
	{
		if (volume <= 0)
			System.out.println("볼륨을 더 이상 내릴 수 없습니다.");
		
		else
		{
			volume--;
			System.out.println("볼륨을 내렸습니다.");
		}
	}
	
	public int getChannel()
	{
		return channel;
	}
	
	public void showInfo()
	{
		System.out.println("현재 채널은 " + channel + "번 채널이며 볼륨은 " + volume + "입니다.");
	}
}

public class classQuiz {
	static void clearConsole()
	{
		for(int i = 0; i < 40; i++)
		{
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		TV tv = new TV();
		int select, channel;
		
		while (true)
		{
			clearConsole();
			System.out.println("-------- TV 설정 프로그램 --------");
			System.out.println("1. 채널 입력");
			System.out.println("2. 채널 올림");
			System.out.println("3. 채널 내림");
			System.out.println("4. 볼륨 증가");
			System.out.println("5. 볼륨 감소");
			System.out.println("6. 현재 정보");
			System.out.print("입력: ");
			select = scanner.nextInt();
			System.out.println();
			
			switch(select)
			{
			case 1:
				clearConsole();
				System.out.println("-------- TV 설정 프로그램 --------");
				System.out.println("현재 채널: " + tv.getChannel());
				System.out.print("채널 입력: ");
				channel = scanner.nextInt();
				
				tv.inputSetChannel(channel);
				
				break;
			case 2:
				tv.channelUp();
				break;
			case 3:
				tv.channelDown();
				break;
			case 4:
				tv.volumeUp();
				break;
			case 5:
				tv.volumeDown();
				break;
			case 6:
				tv.showInfo();
				break;
			}
			System.out.println("Press Enter to continue....");
			scanner.nextLine();
			scanner.nextLine();
		}
	}
}
