package bfs;

import java.io.*;
import java.util.*;

public class Boj_1325 {
    static List<Integer>[] map;
    static int[] ans;
    static boolean[] visited;

    void dfs(int node) {
        List<Integer> computers = map[node];
        visited[node] = true;

        for (int i = 0; i < computers.size(); i++) {
            int src = computers.get(i);
            if (!visited[src]) {
                ans[src]++;
                dfs(src);
            }
        }
    }

    void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            List<Integer> computers = map[now];
            for (int i = 0; i < computers.size(); i++) {
                if (visited[computers.get(i)]) continue;
                ans[computers.get(i)]++;
                visited[computers.get(i)] = true;
                q.offer(computers.get(i));
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        ans = new int[n + 1];
        map = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
            ans[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int dest = Integer.parseInt(line[0]);
            int src = Integer.parseInt(line[1]);
            map[dest].add(src);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++)
            max = Math.max(max, ans[i]);

        for (int i = 1; i <= n; i++) {
            if (max == ans[i])
                System.out.printf("%d ", i);
        }
    }
}
