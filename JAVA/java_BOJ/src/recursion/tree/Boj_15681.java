package recursion.tree;

import java.io.*;
import java.util.*;

public class Boj_15681 {
    static List<Integer>[] tree;
    static boolean[] visited;

    static int[] count;

    int countSubTreeNode(int nowNode) {
        if (count[nowNode] != 0) return count[nowNode];
        visited[nowNode] = true;
        List<Integer> nextNodes = tree[nowNode];

        int cnt = 1;
        for (int next : nextNodes) {
            if (!visited[next])
                cnt += countSubTreeNode(next);
        }
        count[nowNode] = cnt;
        return cnt;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int r = Integer.parseInt(inputs[1]);
        int q = Integer.parseInt(inputs[2]);

        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        count = new int[n + 1];

        for (int i = 0; i <= n; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            String[] nodeInfo = br.readLine().split(" ");
            int node1 = Integer.parseInt(nodeInfo[0]);
            int node2 = Integer.parseInt(nodeInfo[1]);
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        countSubTreeNode(r);

        for (int i = 0; i < q; i++) {
            int subTreeRoot = Integer.parseInt(br.readLine());
            System.out.println(count[subTreeRoot]);
        }
    }
}
