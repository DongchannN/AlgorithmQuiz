package dfs;

import java.io.*;
import java.util.*;

public class Boj_10451 {
    boolean[] visited;
    int[] arr;

    void dfs(int idx) {
        if (visited[idx]) return;

        visited[idx] = true;
        int nextIdx = arr[idx];
        dfs(nextIdx);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] strArr = br.readLine().split(" ");

            visited = new boolean[n + 1];
            arr = new int[n + 1];
            for (int i = 1; i <= n; i++)
                arr[i] = Integer.parseInt(strArr[i - 1]);

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
