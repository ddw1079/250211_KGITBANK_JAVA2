package Day05;
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
class Aircon {
    private String location;
    private int temper, windpower;
    
    Aircon(String location) {
        this.location = location;
        this.temper = 20;
        this.windpower = 1;
        System.out.println("에어컨을 " + this.location + " 에 추가했습니다.");
        System.out.println("기본 온도: " + this.temper + ", 기본 세기: " + this.windpower);
    };


    // Getter
    public String getLocation() {
        return this.location;
    }

    public int getTemper() {
        return this.temper;
    }

    public int getWindpower() {
        return this.windpower;
    }


    // Setter
    public void setTemper(int temper) {
        this.temper = temper;   
    }
    
    public void setWindpower(int windpower) {
        this.windpower = windpower;
    }

    public void increaseTemper() {
        if (this.temper < 30) {
            this.temper++;
            System.out.println("온도를 올렸습니다.");
            System.out.println("현재 온도: " + this.temper);            
        } else {
            System.out.println("온도를 더 올릴 수 없습니다.");
            System.out.println("현재 온도: " + this.temper);
        }
    }
    public void decreaseTemper() {
        if (18 < this.temper) {
            this.temper--;
            System.out.println("온도를 내렸습니다.");
            System.out.println("현재 온도: " + this.temper);
        } else {
            System.out.println("온도를 더 내릴 수 없습니다.");
            System.out.println("현재 온도: " + this.temper);
        }
    }
    public void increaseWindpower() {
        if (this.windpower < 3) {
            this.windpower++;
            System.out.println("바람세기를 올렸습니다.");
            System.out.println("현재 바람세기: " + this.windpower);
        } else {
            System.out.println("바람세기를 더 올릴 수 없습니다.");
            System.out.println("현재 바람세기: " + this.windpower);
        }
    }
    public void decreaseWindpower() {
        if (1 < this.windpower) {
            this.windpower--;
            System.out.println("바람세기를 내렸습니다.");
            System.out.println("현재 바람세기: " + this.windpower);
        } else {
            System.out.println("바람세기를 더 내릴 수 없습니다.");
            System.out.println("현재 바람세기: " + this.windpower);

        }
    }
}


public class QuizAnswer {
    static void clearConsole() {
        for (int i = 0 ; i < 40 ; i++){
            System.out.println();
        }
    }

    static void getAirconList(Aircon[] aircons) {
        int index = 1;
        System.out.print("에어컨 목록: \n");
        for (Aircon aircon : aircons) {
            if(aircon != null) {
                System.out.println(index + ". " + aircon.getLocation());
            } else {
                System.out.println(index + ". ----");
            }
            index++;
        }
    }

    static void pauseSystem(Scanner sc) {
        System.out.println("Press Enter to continue...");
        sc.nextLine();
        sc.nextLine();
    }

    static boolean checkAirconDataValid(int temper, int windpower) {
        if (temper < 18||30 < temper||windpower < 1||3 < windpower) {
            if (temper < 18) {
                System.out.println("입력한 온도가 너무 낮습니다.");
            }
            if (30 < temper) {
                System.out.println("입력한 온도가 너무 높습니다.");
            }
            if (windpower < 1) {
                System.out.println("입력한 바람세기가 너무 낮습니다.");
            }
            if (3 < windpower) {
                System.out.println("입력한 바람세기가 너무 낮습니다.");
            }
            
            return false;
        } else{
            return true;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aircon[] aircons = new Aircon[3];
        int select, deviceCount = 0, temper, windpower, intLocation;
        String location;
        do {
            System.out.println();
            System.out.println("-- 에어컨 설정 프로그램 --");
            System.out.println("1. 에어컨 추가");
            System.out.println("2. 에어컨 설정");
            System.out.println("3. 에어컨 정보");
            System.out.println("4. 나가기");
            System.out.print("enter: ");
            select = sc.nextInt();

            switch (select) {
                case 1:
                    clearConsole();
                    System.out.println("-- 에어컨 설정 프로그램 --");
                    System.out.print("어디에 에어컨을 설치하시겠습니까? :");
                    location = sc.next();

                    aircons[deviceCount] = new Aircon(location);
                    deviceCount++;

                    pauseSystem(sc);
                    break;
                case 2:
                    clearConsole();
                    System.out.println("-- 에어컨 설정 프로그램 --");
                                      

                    getAirconList(aircons);

                    System.out.print("설정할 에어컨 Index 입력 :");
                    intLocation = sc.nextInt();
                    
                    System.out.println("-- 에어컨 설정 프로그램 --");
                    System.out.println(intLocation + ". " + aircons[intLocation-1].getLocation() + " 에어컨을 조정합니다.\n");
                    System.out.println("1. increase temperature");
                    System.out.println("2. decrease temperature");
                    System.out.println("3. increase windpower");
                    System.out.println("4. decrease windpower");
                    System.out.println("5. Temperature, Windpower Manual Setting");
                    System.out.println("6. exit");
                    System.out.print("enter: ");
                    switch (sc.nextInt()) {
                        case 1:
                            aircons[intLocation-1].increaseTemper();
                            break;
                        case 2:
                            aircons[intLocation-1].decreaseTemper();
                            break;
                        case 3:
                            aircons[intLocation-1].increaseWindpower();
                            break;
                        case 4:
                            aircons[intLocation-1].decreaseWindpower();
                            break;
                        case 5:
                            System.out.print("온도 :");
                            temper = sc.nextInt();
                            System.out.print("세기 :");
                            windpower = sc.nextInt();
        
                            if (checkAirconDataValid(temper, windpower)) {
                                aircons[intLocation-1].setTemper(temper);
                                aircons[intLocation-1].setWindpower(windpower);
                                System.out.println(
                                    intLocation +". " + aircons[intLocation-1].getLocation() + " 에어컨을 " + 
                                    "온도: " + aircons[intLocation-1].getTemper() + " | " +
                                    "바람세기 : " + aircons[intLocation-1].getWindpower() + 
                                    " 로 설정하였습니다.");
                            } else{
                                System.out.println("입력하신 정보가 맞지 않습니다. 메인 메뉴로 돌아갑니다.");
                            }
                            break;
                        case 6:
                            System.out.println("메인메뉴로 돌아갑니다.");
                            break;
                        default:
                            break;
                    }
                    pauseSystem(sc);
                    break;
                case 3:
                    clearConsole();
                    System.out.println("-- 에어컨 설정 프로그램 --");

                    getAirconList(aircons);
                    
                    System.out.print("정보를 확인할 에어컨 위치 :");
                    intLocation = sc.nextInt();
                    clearConsole();
                    
                    System.out.println("에어컨 "+ intLocation + "번. " + aircons[intLocation-1].getLocation() + " 현재 상태");
                    System.out.println("온도: " + aircons[intLocation-1].getTemper());                
                    System.out.println("세기: " + aircons[intLocation-1].getWindpower());     
                    pauseSystem(sc);
                    break;
                case 4:
                    clearConsole();
                    System.out.println("-- 에어컨 설정 프로그램 --");
                    System.out.println("에어컨 설정 프로그램을 종료합니다.");
                    break;
            
                default:
                    break;
            }
        } while (select != 4);
        sc.close();
    }
}
