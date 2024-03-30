package graph;

import java.io.*;
import java.util.*;

public class Boj_1717 {
    static int n, m;
    static int[] parents;

    static int find(int node) {
        if (parents[node] == node) return node;
        return find(parents[node]);
    }

    // 경로 압축
    static int adv_find(int node) {
        if (parents[node] != node) parents[node] = find(parents[node]);
        return parents[node];
    }

    static void union(int node1, int node2) {
        node1 = adv_find(node1);
        node2 = adv_find(node2);

        if (node1 == node2) return ;

        if (node1 < node2) {
            parents[node2] = node1;
        } else {
            parents[node1] = node2;
        }
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            parents[i] = i;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int type = Integer.parseInt(line[0]);
            int node1 = Integer.parseInt(line[1]);
            int node2 = Integer.parseInt(line[2]);
            if (type == 0) {
                union(node1, node2);
                continue ;
            }
            int root1 = adv_find(node1);
            int root2 = adv_find(node2);
            if (root1 == root2) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb.toString());
    }
}
