package twoPointer;

import java.io.*;
import java.util.*;

public class Boj_16472 {
    int checkAndCountElement(int[] arr, int allowed) {
        int elementAmount = 0;
        int sum = 0;
        for (int i : arr) {
            if (i != 0) {
                elementAmount++;
                sum += i;
            }
            if (elementAmount > allowed) return -1;
        }
        return sum;
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int[] counts = new int[26];
        Arrays.fill(counts, 0);

        int ans = 0;
        int p2 = 0;
        counts[arr[0] - 'a']++;
        for (int p1 = 0; p1 < arr.length; p1++) {
            while (p1 <= p2 && p2 < arr.length - 1) {
                int cnt = checkAndCountElement(counts, n);
                if (cnt == -1) {
                    break;
                } else {
                    ans = Math.max(ans, cnt);
                    p2++;
                    counts[arr[p2] - 'a']++;
                }
            }
            if (p2 == arr.length - 1 && p1 <= p2) {
                int cnt = checkAndCountElement(counts, n);
                if (cnt != -1)
                    ans = Math.max(ans, cnt);
            }
            counts[arr[p1] - 'a']--;
        }
        System.out.println(ans);
    }
}
