package recursion.tree;

import java.io.*;
import java.util.*;

public class Boj_11725 {
    static List<Integer>[] treeMap;
    static int[] ans;
    static boolean[] visited;

    void findParentNode(int nowNode) {
        List<Integer> nowNodeMap = treeMap[nowNode];
        visited[nowNode] = true;

        for (int i : nowNodeMap) {
            if (!visited[i]) {
                ans[i] = nowNode;
                findParentNode(i);
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        treeMap = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++)
            treeMap[i] = new ArrayList<>();
        ans = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            treeMap[a].add(b);
            treeMap[b].add(a);
        }

        findParentNode(1);
        for (int i = 2; i <= n; i++)
            System.out.println(ans[i]);
    }
}
