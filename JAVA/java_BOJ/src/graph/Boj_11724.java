package graph;

import java.io.*;
import java.util.*;

public class Boj_11724 {

    static boolean[][] map;
    static boolean[] visited;
    static int n;

    void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int nextNode = queue.poll();
            visited[nextNode] = true;

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

        map = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] nextLine = br.readLine().split(" ");
            int node1 = Integer.parseInt(nextLine[0]);
            int node2 = Integer.parseInt(nextLine[1]);

            map[node1][node2] = true;
            map[node2][node1] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
