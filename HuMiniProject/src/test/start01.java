package test;

import java.util.Scanner;

// 주문 시스템을 구현하는 메인 클래스
public class start01 {
    public static void main(String[] args) {
        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner in = new Scanner(System.in);
        // 각 메뉴의 주문 수량을 저장하는 배열 (짜장면, 짬뽕, 볶음밥, 탕수육, 간짜장)
        int[] count = {0, 0, 0, 0, 0};
        // 각 메뉴의 가격을 저장하는 배열
        int[] price = {8000, 9000, 7000, 10000, 12000};
        // 선택된 메뉴 번호를 저장하는 배열 (최대 3개 주문)
        int[] num = {0, 0, 0};
        // 메뉴 출력 여부를 추적하는 배열 (중복 출력 방지용)
        int[] cnt = {0, 0, 0, 0, 0};
        
        // 메뉴 목록을 문자열 배열로 정의
        String[] menu = {"1.짜장면", "2.짬뽕", "3.볶음밥", "4.탕수육", "5.간짜장"};
        
        // 사용자에게 메뉴 선택 안내 메시지 출력
        System.out.println("메뉴를 숫자로 선택하세요 999를 입력시 종료됩니다");
        
        // 최대 3개의 주문을 받는 루프
        for (int i = 0; i < 3; i++) {
            // 메뉴 목록 출력
            System.out.println(menu[0] + "," + menu[1] + "," + menu[2] + "," + menu[3] + "," + menu[4]);
            // 사용자가 선택한 메뉴 번호 입력
            num[i] = in.nextInt();
            
            // 999 입력 시 주문 종료
            if (num[i] == 999) {
                num[i] = 0; // 종료 시 해당 주문 번호 초기화
                break;
            } else {
                // 수량 입력 안내 메시지 출력
                System.out.println("수량을 입력하세요.");
                // 입력된 메뉴의 수량을 해당 메뉴 인덱스에 누적
                count[num[i] - 1] += in.nextInt();
            }
        }
        
        // 주문 내역 출력 루프
        for (int i = 0; i < 3; i++) {
            // 선택된 메뉴가 유효한 경우 (num[i]-1 != -1)
            if (num[i] - 1 != -1) {
                // 이미 출력된 메뉴인지 확인 (cnt 배열로 중복 출력 방지)
                if (cnt[num[i] - 1] != 0) {
                    // 이미 출력된 경우 무시
                }
                // 주문 수량이 0이 아닌 경우 출력
                else if (count[num[i] - 1] != 0) {
                    // 메뉴, 수량, 단가, 총가격 출력
                    System.out.println("메뉴 : " + menu[num[i] - 1] + " | " +
                            "수량 : " + count[num[i] - 1] + " | 가격 : " + price[num[i] - 1] +
                            " | 총가격 : " + price[num[i] - 1] * count[num[i] - 1]);
                    // 해당 메뉴 출력 완료 표시
                    cnt[num[i] - 1]++;
                }
            }
        }
    }
}