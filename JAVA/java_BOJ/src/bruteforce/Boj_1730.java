package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1730 {
    /**
     * 움직일 수 있는 명령인지 check -> 움직일 수 있다면 지금 위치, 다음 위치 흔적 남김
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] cmdArr = br.readLine().toCharArray();

        boolean[][] isVisitedVer = new boolean[n][n];
        boolean[][] isVisitedHor = new boolean[n][n];

        int nowRow = 0;
        int nowCol = 0;
        for (char cmd : cmdArr) {
            if (cmd == 'D') {
                if (nowRow == n - 1) continue;
                isVisitedVer[nowRow][nowCol] = true;
                isVisitedVer[++nowRow][nowCol] = true;
            }
            else if (cmd == 'U') {
                if (nowRow == 0) continue;
                isVisitedVer[nowRow][nowCol] = true;
                isVisitedVer[--nowRow][nowCol] = true;
            }
            else if (cmd == 'L') {
                if (nowCol == 0) continue;
                isVisitedHor[nowRow][nowCol] = true;
                isVisitedHor[nowRow][--nowCol] = true;
            }
            else {
                if (nowCol == n - 1) continue;
                isVisitedHor[nowRow][nowCol] = true;
                isVisitedHor[nowRow][++nowCol] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            char ch;
            for (int j = 0; j < n; j++) {
                if (isVisitedVer[i][j] && isVisitedHor[i][j]) ch = '+';
                else if (isVisitedVer[i][j]) ch = '|';
                else if (isVisitedHor[i][j]) ch = '-';
                else ch = '.';

                System.out.printf("%c", ch);
            }
            System.out.println();
        }
    }
}