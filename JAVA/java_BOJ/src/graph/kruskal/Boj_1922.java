package graph.kruskal;

import java.io.*;
import java.util.*;

public class Boj_1922 {
    static int n, m;
    static int[] parents;

    static class Connection {
        int node1;
        int node2;
        int weight;

        Connection(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }
    }
    static int find(int n) {
        if (parents[n] == n) return n;
        return find(parents[n]);
    }

    static int adv_find(int n) {
        if (parents[n] != n) parents[n] = find(parents[n]);
        return parents[n];
    }

    static void union(int n1, int n2) {
        n1 = adv_find(n1);
        n2 = adv_find(n2);

        if (n1 == n2) return ;
        if (n1 < n2) parents[n2] = n1;
        else parents[n1] = n2;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        Connection[] connections = new Connection[m];
        parents = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parents[i] = i;

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int n1 = Integer.parseInt(line[0]);
            int n2 = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            connections[i] = new Connection(n1, n2, w);
        }

        Arrays.sort(connections, (a, b) -> a.weight - b.weight);
        int cost = 0;
        int cnt = 0;
        for (Connection c : connections) {
            int p1 = adv_find(c.node1);
            int p2 = adv_find(c.node2);
            if (p1 == p2) continue;
            union(c.node1, c.node2);
            cost += c.weight;
            cnt++;
            if (cnt == n - 1) break;
        }

        System.out.println(cost);
    }
}
