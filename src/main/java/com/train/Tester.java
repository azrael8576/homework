package com.train;

import java.util.Scanner;

/**
 * Created by AlexHe on 2018-12-27.
 * Describe 假設只有台北到高雄的票，單程票價1000元，來回票為2000元再打九折
 * ，		請設計 Tester.java與TestKotlin.kt ，讓它執行後完成以下規範 :
 *
 * 		1. 詢問使用者要購買張數，如下:
 * 		Please enter number of tickets:
 * 		2. 取得使用者輸入的張數後，再詢問幾張來回票，如下:
 * 		How many round-trip tickets:
 * 		3. 最後印出本次的張數、來回票數與總金額，如下:
 * 		Total tickets: 5
 * 		Round-trip: 3
 * 		Total: 7400
 */

public class Tester {
    private static Ticket ticket;
    private static boolean leave = false;
    public static void main(String[] args) {
        System.out.println("\n*********Java*********\n");
        while (true){
            inputTicket();
            if (leave == true){
                System.out.println("leave!!");
                break;
            }
            System.out.println("Total tickets: " + ticket.getTotal());
            System.out.println("Round-trip: " + ticket.getRoundTrip());
            System.out.println("Total: " + ticket.totalAmout());
            System.out.println("-----------------------------");
        }
    }

    //確認是否leave
    private static void inputTicket() {
        int total;
        int roundTrip = 0;
        if (leave == false){
            System.out.println("Please enter number of tickets:");
            total = checkNumber();
            if (total == -1) {leave = true;}
            while (leave == false) {
                System.out.println("How many round-trip tickets:");
                roundTrip = checkNumber();
                if (roundTrip == -1) {leave = true;}
                if (roundTrip <= total){
                    ticket = new Ticket(total,roundTrip);
                    break;
                }
                else System.out.println("Error,please enter again.");
            }
        }
    }

    //確認是否大於-1且為數字
    private static int checkNumber() {
        int number;
        while (true){
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number < -1) System.out.println("Error,please enter again.");
                else break;
            }
            else System.out.println("Error,please enter a number.");
        }
        return number;
    }
}
