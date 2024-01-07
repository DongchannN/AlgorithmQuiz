package binarySearch;

import java.io.*;
import java.util.Arrays;

public class Boj_2110 {
    int countModem(int[] map, int distance) {
        int cnt = 1;
        int before = map[0];
        for (int i = 1; i < map.length; i++) {
            if (map[i] - before >= distance) {
                before = map[i];
                cnt++;
            }
        }
        return cnt;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);

        int[] map = new int[n];
        for (int i = 0; i < n; i++)
            map[i] = Integer.parseInt(br.readLine());

        Arrays.sort(map);
        int start = 0;
        int last = map[map.length - 1] - map[0];
        int ans = 0;
        while (start <= last) {
            int mid = (start + last) / 2;
            if (countModem(map, mid) < c) {
                last = mid - 1;
            } else {
                start = mid + 1;
                ans = Math.max(ans, mid);
            }
        }
        System.out.println(ans);
    }
}
