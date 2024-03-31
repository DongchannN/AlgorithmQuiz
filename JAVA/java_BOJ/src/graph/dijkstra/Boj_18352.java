package graph.dijkstra;

import java.io.*;
import java.util.*;

public class Boj_18352 {
    List<Integer>[] map;
    boolean[] visited;
    int[] dp;
    int n, m, k, x;

    int getMinCostNode() {
        int minCost = Integer.MAX_VALUE;
        int minNode = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && dp[i] < minCost) {
                minCost = dp[i];
                minNode = i;
            }
        }
        return minNode;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);
        x = Integer.parseInt(line[3]);

        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        visited = new boolean[n + 1];
        map = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++)
            map[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int node1 = Integer.parseInt(line[0]);
            int node2 = Integer.parseInt(line[1]);
            map[node1].add(node2);
        }

        // 우선순위 큐를 적용하는 경우.
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(x);
        dp[x] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : map[now]) {
                int newCost = dp[now] + 1;
                if (dp[next] > newCost) {
                    dp[next] = newCost;
                    q.offer(next);
                }
            }
        }

        // 우선 순위 큐를 적용하지 않는 경우.
//        for (int i = 1; i <= n; i++) {
//            int minNode = getMinCostNode();
//            for (int next : map[minNode]) {
//                int newCost = dp[i] + 1;
//                if (dp[next] > newCost)
//                    dp[next] = newCost;
//            }
//            visited[minNode] = true;
//        }

        boolean exist = false;
        for (int i = 1; i <= n; i++) {
            if (dp[i] == k) {
                exist = true;
                System.out.println(i);
            }
        }
        if (!exist) System.out.println("-1");
    }
}
