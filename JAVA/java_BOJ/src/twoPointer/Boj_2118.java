package twoPointer;

import java.io.*;
import java.util.*;

public class Boj_2118 {
    int convertDistance(int distance, int totalDistance) {
        return distance > totalDistance / 2 ? totalDistance - distance : distance;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] map = new int[n];
        int totalDistance = 0;
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(br.readLine());
            totalDistance += map[i];
        }

        int sum = map[0];
        int ans = convertDistance(sum, totalDistance);
        int p2 = 0;
        for (int p1 = 0; p1 < n; p1++) {
            while (p1 <= p2 && p2 < n - 1) {
                if (sum <= totalDistance / 2) ans = convertDistance(Math.max(ans, sum), totalDistance);
                if (sum <= totalDistance / 2) {
                    p2++;
                    sum += map[p2];
                } else break;
            }
            if (p2 == n - 1) {
                if (sum <= totalDistance / 2)
                    ans = convertDistance(Math.max(ans, sum), totalDistance);
            }
            sum -= map[p1];
        }
        System.out.println(ans);
    }

    /**
     * solution() 개선
     * convertDistance() 와 같은 메서드 필요 없이 코드 수정.
     * @throws IOException
     */
    public void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] map = new int[n];
        int totalDistance = 0;
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(br.readLine());
            totalDistance += map[i];
        }

        int ans = 0;
        int p2 = 0;
        int distClockWise = 0;
        int disCounterClockWise = totalDistance;
        for (int p1 = 0; p1 < n; p1++) {
            while (distClockWise < disCounterClockWise) {
                distClockWise += map[p2];
                disCounterClockWise -= map[p2];
                p2 = (p2 + 1) % n; // 시계방향으로 p2 이동, 인덱스 초과 시 n의 나머지 연산.
            }
            ans = Math.max(ans, disCounterClockWise);

            distClockWise -= map[p1];
            disCounterClockWise += map[p1];
        }
    }
}
