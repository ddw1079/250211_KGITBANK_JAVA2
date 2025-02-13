package Day04;
//////////////
// // Q2) 에어컨을 추가 및 설정할 수 있는 프로그램을 작성해보세요.
// * 에어컨의 최대 개수는 3개입니다.
// * 에어컨의 설정 온도는 18~30, 바람 세기는 1~3의 값을 갖습니다.
// * 에어컨의 개수, 선택값의 예외처리는 진행하지 않습니다.

import java.util.Scanner;

// -- 에어컨 설정 프로그램 --
// 1. 에어컨 추가
// 2. 에어컨 설정
// 3. 에어컨 정보
// 4. 종료

// -- 에어컨 설정
// 온도, 바람 세기 증감, 뒤로


class Air_con {
    private String aircon_name;
    private int temper;
    private int wind;

    // Constructor
    Air_con(String aircon_name) {
        this.aircon_name = aircon_name;
        this.temper = 20;
        this.wind = 1;
        System.out.println(this.aircon_name + " 에어컨 추가됨.");
    }
    // Air_con(String aircon_name, int temper, int wind) {
    //     this.aircon_name = aircon_name;
    //     this.temper = temper;
    //     this.wind = wind;
    // }
    
    // Getter
    public String getAirconName() {
        return this.aircon_name;
    }
    public int getTemper() {
        return this.temper;
    }
    public int getWind() {
        return this.wind;
    }

    // Setter
    public void setAirconName(String aircon_name) {
        this.aircon_name = aircon_name;
    }
    public void setTemper(int temper){ 
        this.temper = temper;
    }
    public void setWind(int wind){ 
        this.wind = wind;
    }
}

public class Constructor_Example {
    public static void main(String[] args) {
        // 기본 선언
        Air_con[] aircon = new Air_con[3];

        Scanner sc = new Scanner(System.in);
        String scString;
        int scInt;
        int select=1;
        String[] Arr_menu = {
            "1. 에어컨 추가",
            "2. 에어컨 설정",
            "3. 에어컨 정보",
            "4. 에어컨 삭제",
            "0. 종료"
        };


        while(select!=0) {
            // 에어컨 설정 메인메뉴
            boolean isAirconEmpty = true;
            for (Air_con iteAir_con : aircon ) {
                if(iteAir_con!=null) {
                    isAirconEmpty = false;
                }
            }
            int index;
            // boolean isAirconEmpty = (aircon.length>0?false:true);
            System.out.println("isAirconEmpty?:" + isAirconEmpty);
            System.out.println("---- 에어컨 설정 프로그램 메인메뉴 ----");
            for (String string : Arr_menu) {
                System.out.println(string);
            }
            System.out.println();

            System.out.printf("메뉴 선택:");
            scInt = sc.nextInt();
            switch (scInt) {
                // 1. 에어컨 추가
                case 1:
                    index = 0;
                    for(int i = 0; i<3; i++) {
                        if (aircon[i] != null) {
                            index++;
                        }
                    }
                    System.out.println("1. 에어컨 추가 메뉴 진입");
                    System.out.println("현재 에어컨 목록:");
                    if (isAirconEmpty) {
                        for(int i = 0; i<3; i++) {
                            System.out.printf("\t%d, %s\n", i+1, " ---- ");
                        }
                    } else {
                        for(int i = 0; i<3; i++) {
                            if(aircon[i]!=null) {
                                System.out.printf("\t%d, %s\n", i+1, aircon[i].getAirconName());
                            } else {
                                System.out.printf("\t%d, %s\n", i+1, " ---- ");
                            }
                        }
                    }
                    if(index > 2) {
                        System.out.println("에어컨 목록이 가득 차 있으므로 더 추가할 수 없습니다.");
                        System.out.println("메인 메뉴로 돌아갑니다.");
                        break;
                    }
                    
                    // System.out.println("aircon index: " + index+1);
                    System.out.print((index+1) + " 번에 에어컨을 추가합니다.");
                    System.out.print("추가할 에어컨 이름:");
                    scString = sc.next();
                    aircon[index] = new Air_con(scString);
                    break;
                // 2. 에어컨 설정
                case 2:
                    index = 0;
                    System.out.println("2. 에어컨 설정 메뉴 진입");
                    System.out.println("현재 에어컨 목록:");
                    if (isAirconEmpty) {
                        for(int i = 0; i<3; i++) {
                            System.out.printf("\t%d, %s\n", i+1, " ---- ");
                        }
                        break;
                    } else {
                        for(int i = 0; i<3; i++) {
                            if(aircon[i]!=null) {
                                System.out.printf("\t%d, %s\n", i+1, aircon[i].getAirconName());
                            } else {
                                System.out.printf("\t%d, %s\n", i+1, " ---- ");
                            }
                        }
                        System.out.printf("\t0. 뒤로가기");
                        
                    }
                    System.out.println();
                    System.out.printf("몇 번 에어컨을 설정하시겠습니까?:");
                    System.out.println();
                    scInt = sc.nextInt();
                    index = scInt;
                    if(index == 0) {
                        System.out.println("---- ---- ---- ----");
                        System.out.println("---- ---- ---- ----");
                        break;
                    }
                    
                    System.out.println((index) + ", "+ aircon[index-1].getAirconName() + " 의 에어컨을 설정합니다.");
                    System.out.print("설정할 에어컨 온도: ");
                    scInt = sc.nextInt();
                    if (18 <= scInt && scInt <= 30) {
                        aircon[index-1].setTemper(scInt);
                    } else {
                        System.out.print("입력한 온도가 범위를 넘어섰습니다. 온도 범위: 18~30 ");
                        System.out.print("메인 화면으로 넘어갑니다.");
                        break;
                    }
                    System.out.print("설정할 에어컨 세기: ");
                    scInt = sc.nextInt();
                    if (1 <= scInt && scInt <= 3) {
                        aircon[index-1].setWind(scInt);
                    } else {
                        System.out.print("입력한 에어컨 세기가 범위를 넘어섰습니다. 세기 범위: 1~3");
                        System.out.print("메인 화면으로 넘어갑니다.");
                        break;
                    }
                    System.out.println();
                    System.out.println("온도: " + aircon[index-1].getTemper() + " | 세기: " + aircon[index-1].getWind() + " 로 설정하였습니다.");
                    System.out.print("메인 화면으로 넘어갑니다.");

                    break;
                // 3. 에어컨 정보
                case 3:
                    index = 0;
                    System.out.println("3. 에어컨 정보 메뉴 진입");
                    System.out.println("현재 에어컨 목록:");
                    if (isAirconEmpty) {
                        for(int i = 0; i<3; i++) {
                            System.out.printf("\t%d, %s\n", i+1, " ---- ");
                        }
                        break;
                    } else {
                        for(int i = 0; i<3; i++) {
                            if(aircon[i]!=null) {
                                System.out.printf("\t%d, %s\n", i+1, aircon[i].getAirconName());
                            } else {
                                System.out.printf("\t%d, %s\n", i+1, " ---- ");
                            }
                        }
                        System.out.printf("\t0. 뒤로가기");
                        
                    }
                    System.out.println();
                    System.out.printf("몇 번 에어컨을 확인하시겠습니까?:");
                    System.out.println();
                    scInt = sc.nextInt();
                    index = scInt;
                    if(index == 0) {
                        System.out.println("---- ---- ---- ----");
                        System.out.println("---- ---- ---- ----");
                        break;
                    }
                    
                    System.out.println((index) + ", "+ aircon[index-1].getAirconName() + " 에어컨 정보.");

                    System.out.println("온도: " + aircon[index-1].getTemper() + " | 세기: " + aircon[index-1].getWind() + " 입니다.");
                    System.out.print("메인 화면으로 넘어갑니다.");
                    break;
                // 4. 에어컨 삭제
                case 4:
                    
                    break;
                // 0. 종료
                case 0:
                    System.out.println("---- 에어컨 설정 프로그램을 종료합니다.");
                    select = 0;
                    break;
                default:
                    System.out.println("잘못된 값을 입력받았습니다. 다시 시도해주십시오.");
                    break;
            }
        }
    }
}
