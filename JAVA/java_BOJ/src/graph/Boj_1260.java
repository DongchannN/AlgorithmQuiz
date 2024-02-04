package graph;

import java.io.*;
import java.util.*;

public class Boj_1260 {

    boolean[][] map;
    boolean[] visited;
    int n;

    void dfs(int node) {
        visited[node] = true;
        System.out.printf("%d ", node);

        for (int i = 1; i <= n; i++) {
            if (map[node][i] && !visited[i])
                dfs(i);
        }
    }

    void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int nextNode = queue.poll();
            visited[nextNode] = true;
            System.out.printf("%d ", nextNode);

            for (int i = 1; i <= n; i++) {
                if (map[nextNode][i] && !visited[i] && !queue.contains(i))
                    queue.offer(i);
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");
        n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int v = Integer.parseInt(line1[2]);

        map = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] nextLine = br.readLine().split(" ");
            int node1 = Integer.parseInt(nextLine[0]);
            int node2 = Integer.parseInt(nextLine[1]);

            map[node1][node2] = true;
            map[node2][node1] = true;
        }

        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);
        System.out.println();
    }
}
