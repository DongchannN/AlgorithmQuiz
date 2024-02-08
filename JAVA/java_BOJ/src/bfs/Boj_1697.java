package bfs;

import java.io.*;
import java.util.*;

public class Boj_1697 {
    int n, k;
    int[] map;

    void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        map[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int exit = 0;
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0)
                    next = now - 1;
                else if (i == 1)
                    next = now + 1;
                else
                    next = now * 2;

                if (next >= 0 && next < 200001 && map[next] == -1) {
                    queue.offer(next);
                    map[next] = map[now] + 1;
                }
                if (next == k) {
                    exit = 1;
                    break;
                }
            }
            if (exit == 1) break;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);

        map = new int[200001];
        Arrays.fill(map, -1);
        bfs(n);

//        for (int i : map) {
//            System.out.printf("%d ", i);
//        }
//        System.out.println();

        System.out.println(map[k]);
    }
}
