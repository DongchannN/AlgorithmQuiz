package twoPointer;

import java.io.*;
import java.util.*;

public class Boj_15831 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int w = Integer.parseInt(inputs[2]);

        char[] map = br.readLine().toCharArray();

        int blackNum = 0;
        int whiteNum = 0;
        if (map[0] == 'B') blackNum++;
        else whiteNum++;
        int ans = 0;
        if (whiteNum >= w && blackNum <= b)
            ans = Math.max(ans, whiteNum + blackNum);

        int p2 = 0;
        for (int p1 = 0; p1 < n; p1++) {
            while (p1 <= p2 && p2 < n - 1) {
                if (blackNum <= b || p1 == p2) {
                    p2++;
                    if (map[p2] == 'B') blackNum++;
                    else whiteNum++;
                    if (whiteNum >= w && blackNum <= b)
                        ans = Math.max(ans, whiteNum + blackNum);
                } else {
                    if (map[p1] == 'B') blackNum--;
                    else whiteNum--;
                    if (whiteNum >= w && blackNum <= b)
                        ans = Math.max(ans, whiteNum + blackNum);
                    break;
                }
            }
            if (p2 == n - 1 && p1 <= p2)
                if (whiteNum >= w && blackNum <= b)
                    ans = Math.max(ans, whiteNum + blackNum);
        }
        System.out.println(ans);
    }

    /**
     * solution() 의 투포인터 개념에서 while 문 안의 불필요한 if연산을 없애 개선하였음.
     * @throws IOException
     */
    public void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int w = Integer.parseInt(inputs[2]);

        char[] map = br.readLine().toCharArray();

        int blackNum = 0;
        int whiteNum = 0;
        int ans = 0;
        if (whiteNum >= w && blackNum <= b)
            ans = Math.max(ans, whiteNum + blackNum);

        int p2 = 0;
        for (int p1 = 0; p1 < n; p1++) {
            while (p2 < n) {
                if (blackNum == b && map[p2] == 'B') break;
                if (map[p2++] == 'W') whiteNum++;
                else blackNum++;
            }
            if (whiteNum >= w)
                ans = Math.max(ans, p2 - p1);
            if (map[p1] == 'B') blackNum--;
            else whiteNum--;
        }
        System.out.println(ans);
    }
}
