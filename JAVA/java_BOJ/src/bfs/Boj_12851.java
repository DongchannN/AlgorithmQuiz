package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_12851 {
    int n, k;
    int[] map;
    int[] count;


    void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        map[start] = 0;
        count[start] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0)
                    next = now - 1;
                else if (i == 1)
                    next = now + 1;
                else
                    next = now * 2;

                if (next < 0 || next >= 200001) continue;

                if (map[next] == -1) {
                    queue.offer(next);
                    map[next] = map[now] + 1;
                    count[next] = count[now];
                } else if (map[next] == map[now] + 1) {
                    count[next] += count[now];
                }
            }
        }
    }


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);

        map = new int[200001];
        count = new int[200001];

        Arrays.fill(map, -1);
        bfs(n);
        System.out.println(map[k]);
        System.out.println(count[k]);
    }
}
