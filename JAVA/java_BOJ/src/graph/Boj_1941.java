package graph;

import java.io.*;
import java.util.*;

public class Boj_1941 {
    char[]map = new char[25];
    boolean[] visited = new boolean[7];
    int[] members = new int[7];

    int ans = 0;


    boolean isNearBy(int a, int b) {
        int sub = Math.abs(a - b);
        int bigger = Math.max(a, b);

        if (sub == 1 && bigger % 5 != 0) return true;
        if (sub == 5) return true;
        return false;
    }

    int isConnected(int idx) {
        int cnt = 1;
        visited[idx] = true;
        int member = members[idx];
        for (int i = 1; i < 7; i++) {
            int other = members[i];
            if (!visited[i] && isNearBy(member, other)) {
                cnt += isConnected(i);
            }
        }
        return cnt;
    }
    void selectMembers(int depth, int idx) {
        if (depth == 7) {
            int sCnt = 0;
            for (int i = 0; i < 7; i++)
                if (map[members[i]] == 'S') sCnt++;
            if (sCnt < 4) return ;
            Arrays.fill(visited, false);
            if (isConnected(0) == 7)
                ans++;
            return ;
        }
        if (idx == 25) {
            return;
        }

        members[depth] = idx;
        selectMembers(depth + 1, idx + 1);
        members[depth] = 0;
        selectMembers(depth, idx + 1);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 5; j++)
                map[(i * 5) + j] = input[j];
        }

        selectMembers(0, 0);
        System.out.println(ans);
    }
}
