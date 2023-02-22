package dfs;

import java.util.*;
public class Boj_1240 {
    static List<Node> arr[];
    static int ans;

    static boolean[] visited;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        arr = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++) {
            arr[i] = new ArrayList<Node>();
        }

        for (int i = 1; i < n; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            int len = scanner.nextInt();

            arr[node1].add(new Node(node2, len));
            arr[node2].add(new Node(node1, len));
        }

        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int stop = scanner.nextInt();

            visited = new boolean[n + 1];
            visited[start] = true;
            findPath(start, 0, stop);
            System.out.println(ans);
        }
    }

    private void findPath(int startNode, int len, int stopNode) {
        if (startNode == stopNode) {
            ans = len;
            return;
        }
        for (Node node : arr[startNode]) {
            if(!visited[node.to]){
                visited[node.to] = true;
                findPath(node.to, len + node.len, stopNode);
            }
        }
    }

    static class Node {
        int to;
        int len;

        Node(int to, int len) {
            this.to = to;
            this.len = len;
        }
    }

}
