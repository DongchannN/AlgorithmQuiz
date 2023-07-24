package string;

import java.util.Scanner;

public class Boj_10158 { // 시간 초과
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        int nowX = scanner.nextInt();
        int nowY = scanner.nextInt();

        int time = scanner.nextInt();

        int beforeX = 1;
        int beforeY = 1;

//        System.out.println("first : " + nowX + " " + nowY);
        nowX += beforeX;
        nowY += beforeY;

//        System.out.println("second : " + nowX + " " + nowY);
        int nextX = 1;
        int nextY = 1;

        for (int i = 1; i < time; i++) {
            if (beforeX == 1 && beforeY == 1) {
                if (nowX == width && nowY == height) {
                    beforeX = -1;
                    beforeY = -1;
                } else if (nowY == height) {
                    beforeX = 1;
                    beforeY = -1;
                } else if (nowX == width) {
                    beforeX = -1;
                    beforeY = 1;
                }
            } else if (beforeX == 1 && beforeY == -1) {
                if (nowX == width && nowY == 0) {
                    beforeX = -1;
                    beforeY = 1;
                } else if (nowY == 0) {
                    beforeX = 1;
                    beforeY = 1;
                } else if (nowX == width) {
                    beforeX = -1;
                    beforeY = -1;
                }
            } else if (beforeX == -1 && beforeY == -1) {
                if (nowX == 0 && nowY == 0) {
                    beforeX = 1;
                    beforeY = 1;
                } else if (nowY == 0) {
                    beforeX = -1;
                    beforeY = 1;
                } else if (nowX == 0) {
                    beforeX = 1;
                    beforeY = -1;
                }
            } else if (beforeX == -1 && beforeY == 1) {
                if (nowX == 0 && nowY == height) {
                    beforeX = 1;
                    beforeY = -1;
                } else if (nowY == height) {
                    beforeX = -1;
                    beforeY = -1;
                } else if (nowX == 0) {
                    beforeX = 1;
                    beforeY = 1;
                }
            }
            nowX += beforeX;
            nowY += beforeY;
//            System.out.println("next : " + nowX + " " + nowY);
        }

        System.out.println(nowX + " " + nowY);
    }
}
