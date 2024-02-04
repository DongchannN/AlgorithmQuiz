package graph;

import java.io.*;
import java.util.*;

public class Boj_2606 {
    static List<Integer>[] map;
    static boolean[] visited;
    static int n;
    static int cnt = 0;

    void dfs(int node) {
        visited[node] = true;
        cnt++;

        for (int nextNode : map[node]) {
            if (!visited[nextNode])
                dfs(nextNode);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        map = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            map[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int node1 = Integer.parseInt(line[0]);
            int node2 = Integer.parseInt(line[1]);

            map[node1].add(node2);
            map[node2].add(node1);
        }

        dfs(1);
        System.out.println(cnt - 1);
    }
}
