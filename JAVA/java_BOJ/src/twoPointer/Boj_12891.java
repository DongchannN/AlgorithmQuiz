package twoPointer;

import java.io.*;
import java.util.*;

public class Boj_12891 {
    int convertToIdx(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        if (c == 'T') return 3;
        return -1;
    }

    boolean checkCanBePassword(int[] nowInfo, int[] needs) {
        for (int i = 0; i < 4; i++) {
            if (nowInfo[i] - needs[i] < 0) return false;
        }
        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int len = Integer.parseInt(input[1]);

        char[] arr = br.readLine().toCharArray();
        int[] needs = new int[4];
        String[] stringNeeds = br.readLine().split(" ");
        for (int i = 0; i < 4; i++)
            needs[i] = Integer.parseInt(stringNeeds[i]);
        int[] nowInfo = new int[4];
        Arrays.fill(nowInfo, 0);

        int ans = 0;
        int p1 = 0;
        int p2 = len - 1;
        for (int i = p1; i <= p2; i++) {
            if (arr[i] == 'A') nowInfo[0]++;
            else if (arr[i] == 'C') nowInfo[1]++;
            else if (arr[i] == 'G') nowInfo[2]++;
            else if (arr[i] == 'T') nowInfo[3]++;
        }
        if (checkCanBePassword(nowInfo, needs)) ans++;

        for (int i = p1; i <= n - 1 - len; i++) {
            p1++;
            p2++;
            int i1 = convertToIdx(arr[p1 - 1]);
            int i2 = convertToIdx(arr[p2]);
            nowInfo[i1]--;
            nowInfo[i2]++;
            if (checkCanBePassword(nowInfo, needs)) ans++;
        }

        System.out.println(ans);
    }
}
