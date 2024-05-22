package bfs;

import java.io.*;
import java.util.*;

public class Boj_1005 {
    static List<Node>[] map;
    static Node[] nodeInfo;
    static int n, w;
    static int maxDist;
    static int[] maxDistBfs;
    static int[] visited;

    static class Node {
        int num;
        int delay;

        Node(int num, int delay) {
            this.num = num;
            this.delay = delay;
        }
    }

    static void getLongestDist(int now, int dist) {
        if (dist < visited[now -1])
            return ;
        visited[now -1] = dist;
        List<Node> nexts = map[now - 1];
        if (nexts.isEmpty()) {
            maxDist = Math.max(maxDist, dist);
            return ;
        }
        for (Node n : nexts) {
            getLongestDist(n.num, dist + n.delay);
        }
    }

    static void getLongestDistBFS() {
        Queue<Node> queue = new LinkedList<>();
        maxDistBfs = new int[n];
        Arrays.fill(maxDistBfs, 0);

        // 시작 노드를 큐에 추가
        queue.add(nodeInfo[w - 1]);
        maxDistBfs[w - 1] = nodeInfo[w - 1].delay;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node next : map[current.num - 1]) {
                if (maxDistBfs[next.num - 1] < maxDistBfs[current.num - 1] + next.delay) {
                    maxDistBfs[next.num - 1] = maxDistBfs[current.num - 1] + next.delay;
                    queue.add(next);
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            nodeInfo = new Node[n];
            map = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                map[i] = new ArrayList<>();
            }

            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nodeInfo[i] = new Node(i + 1, Integer.parseInt(input[i]));
            }
            for (int i = 0; i < k; i++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                map[y - 1].add(nodeInfo[x - 1]);
            }

            w = Integer.parseInt(br.readLine());

            // DFS -> 시간 초과
//            maxDist = 0;
//            visited = new int[n];
//            getLongestDist(w, nodeInfo[w - 1].delay);
//            System.out.println(maxDist);

            // BFS
            getLongestDistBFS();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, maxDistBfs[i]);
            }
            System.out.println(ans);
        }
    }
}
