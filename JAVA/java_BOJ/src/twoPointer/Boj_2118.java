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
}
