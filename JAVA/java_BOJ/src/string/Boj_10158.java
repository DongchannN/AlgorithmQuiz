package string;

import java.util.Scanner;

public class Boj_10158 { // 시간 초과
    public void solution() {
        // x(t) = x(t % (2 * width)) => t를 초기위치 + t로 치환가능
        // y(t) = y(t % (2 * height))

        Scanner scanner = new Scanner(System.in);

        int width = scanner.nextInt();
        int height = scanner.nextInt();
        int curX = scanner.nextInt();
        int curY = scanner.nextInt();
        int time = scanner.nextInt();

//        int delX = 1;
//        int delY = 1;
//
//        int moveX = time % (2 * width);
//        int moveY = time % (2 * height);
//
//        while (moveX > 0) {
//            if (curX == width) delX = -1; // 방향 전환
//            else if(curX == 0) delX = 1;
//            curX += delX;
//            moveX--;
//        }
//
//        while (moveY > 0) {
//            if (curY == height) delY = -1; // 방향 전환
//            else if(curY == 0) delY = 1;
//            curY += delY;
//            moveY--;
//        }

        curX = (time + curX) % (2 * width);
        curY = (time + curY) % (2 * height);

        if (curX > width) {
            curX = 2 * width - curX;
        }

        if (curY > height) {
            curY = 2 * height - curY;
        }

        System.out.println(curX + " " + curY);
    }
}
