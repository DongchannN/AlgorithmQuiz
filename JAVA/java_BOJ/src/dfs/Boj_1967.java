package dfs;

import java.util.*;

public class Boj_1967 {
    static List<Node> nodesArr[];
    static boolean visited[];

    static int ans;

    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int depth = scanner.nextInt();

        nodesArr = new ArrayList[depth+1];
        for (int i = 1; i < depth+1; i++) {
            nodesArr[i] = new ArrayList<Node>();
        }

        for (int i = 1; i < depth; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            int length = scanner.nextInt();

            nodesArr[parent].add(new Node(child, length));
            nodesArr[child].add(new Node(parent, length));
        }

        List<Integer> findArr = new ArrayList<>();
        for (int i = 1; i < depth + 1; i++) {
            if (nodesArr[i].size() == 1) {
                findArr.add(i);
            }
        }


        for (int i : findArr) {
            visited = new boolean[depth+1];
            visited[i] = true;
            searchDepth(i, 0);
        }

        System.out.println(ans);
    }

    public static void searchDepth(int num, int len) {
        for (Node node : nodesArr[num]) {
            if (!visited[node.nodeNum]) {
                visited[node.nodeNum] = true;
                searchDepth(node.nodeNum, len + node.len);
            }
        }

        ans = Math.max(ans, len);
    }


    public static class Node {
        int nodeNum;
        int len;

        Node(int nodeNum, int len) {
            this.nodeNum = nodeNum;
            this.len = len;
        }
    }
}

