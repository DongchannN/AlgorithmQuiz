package graph.dijkstra;

import java.io.*;
import java.util.*;

public class Boj_1753 {
    static int n, m, s;
    static List<Node>[] map;
    static int[] dists;
    static boolean[] visited;

    static class Node {
        int dest;
        int weight;

        Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static int getMinCost() {
        int min = Integer.MAX_VALUE;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (dists[i] < min) {
                min = dists[i];
                ret = i;
            }
        }
        return ret;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        s = Integer.parseInt(br.readLine()) - 1;
        dists = new int[n];
        visited = new boolean[n];
        Arrays.fill(dists, Integer.MAX_VALUE);
        map = new ArrayList[n];
        for (int i = 0; i < n; i++)
            map[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int src = Integer.parseInt(line[0]) - 1;
            int dest = Integer.parseInt(line[1]) - 1;
            int weight = Integer.parseInt(line[2]);
            map[src].add(new Node(dest, weight));
        }
        dists[s] = 0;
        for (int i = 0; i < n; i++) {
            int now = getMinCost();
            visited[now] = true;
            for (Node n : map[now]) {
                dists[n.dest] = Math.min(dists[now] + n.weight, dists[n.dest]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (dists[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dists[i]);
        }
    }
}
