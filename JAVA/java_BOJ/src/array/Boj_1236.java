package array;

import java.util.Scanner;

public class Boj_1236 {
    public void solution() {
        // 경비원이 있는 행, 열은 안전지대
        // 안전지대가 아닌 행, 열 개수를 구함
        // 행, 열 개수 중 큰 값이 정답
        Scanner scanner = new Scanner(System.in);

        int height = scanner.nextInt();
        int width = scanner.nextInt();
        char[][] map = new char[height][width];

        for (int i = 0; i < height; i++) {
            map[i] = scanner.next().toCharArray();
        }

        int safeRowCnt = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 'X') {
                    safeRowCnt++;
                    break;
                }
            }
        }

        int safeColCnt = 0;
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                if (map[i][j] == 'X') {
                    safeColCnt++;
                    break;
                }
            }
        }

        int notSafeRowCnt = height - safeRowCnt;
        int notSafeColCnt = width - safeColCnt;

//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                if (checkRow(map, i, j) == 0 && checkCol(map, i, j) == 0) {
//                    map[i][j] = 'X';
//                    cnt++;
//                    break;
//                }
//            }
//        }
//
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                if (checkRow(map, i, j) == 0) {
//                    map[i][j] = 'X';
//                    cnt++;
//                    break;
//                }
//            }
//        }
//
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                if (checkCol(map, i, j) == 0) {
//                    map[i][j] = 'X';
//                    cnt++;
//                    break;
//                }
//            }
//        }
        System.out.println(Math.max(notSafeColCnt, notSafeRowCnt));
    }

//    private int checkCol(char[][] map, int i, int j) {
//        int check = 0;
//
//        for (int x = 0; x < map[i].length; x++) {
//            if (map[i][x] == 'X') {
//                check = 1;
//                break;
//            }
//        }
//        return check;
//    }
//
//    private int checkRow(char[][] map, int i, int j) {
//        int check = 0;
//
//        for (int y = 0; y < map.length; y++) {
//            if (map[y][j] == 'X') {
//                check = 1;
//                break;
//            }
//        }
//        return check;
//    }
}
