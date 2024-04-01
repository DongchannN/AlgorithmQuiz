package graph.dijkstra;

import java.io.*;
import java.util.*;

public class Boj_1446 {

    List<Node>[] map = new ArrayList[10001];
    int[] dp = new int[10001];
    int n, d;

    static class Node {
        int num;
        int cost;

        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        d = Integer.parseInt(line[1]);
        for (int i = 0; i <= 10000; i++) {
            map[i] = new ArrayList<>();
            dp[i] = i;
        }
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            int dist = Integer.parseInt(line[2]);
            map[start].add(new Node(end, dist));
        }

        // 다익스트라 코드 부분.
        for (int i = 0; i <= 10000; i++) {
            if (i > d) break;

            // 거리 i까지 지름길을 타고 왔다면 dp[i + 1] 은 dp[i] + 1 보다 큼.
            // ex. 0 - 50까지 거리가 10인 지름길이 있다면 dp[50] = 10.
            //     dp[51]은 처음에 초기화로 인하여 51이 됨.
            //     dp[51]을 dp[50]인 10에 한칸 더 간 11로 갱신해야 함.
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

            for (Node next : map[i]) {
                // dp[next.num]은 해당 노드까지 지름길이 있는 경우.
                // dp[지름길의 종료시점]이 "현재까지 거리 + 지름길 거리"로 갱신이 안된 경우 갱신.
                if (dp[i] + next.cost < dp[next.num])
                    dp[next.num] = dp[i] + next.cost;
            }
        }

        System.out.println(dp[d]);
    }
}
