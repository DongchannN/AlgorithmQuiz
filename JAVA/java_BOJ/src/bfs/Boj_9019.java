package bfs;

import java.io.*;
import java.util.*;

public class Boj_9019 {

    String[] chars = {"D", "S", "L", "R"};
    int start, end;
    String[] visited;

    int DSLR(int num, int i) {
        if (i == 0) {
            return (num * 2) % 10000;
        } else if (i == 1) {
            if (num == 0) return 9999;
            else return num - 1;
        } else if (i == 2) {
            return (((num % 1000) * 10) + (num / 1000));
        } else {
            return (((num % 10) * 1000) + (num / 10));
        }
    }

    void bfs(int startNum) {
        Queue<Integer> q = new LinkedList<>();
        visited = new String[10001];
        q.offer(startNum);
        visited[startNum] = "";

        boolean canExit = false;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < 4; i++) {
                int next = DSLR(now, i);

                if (visited[next] == null) {
                    q.offer(next);
                    visited[next] = visited[now].concat(chars[i]);
                }
                if (next == end) {
                    canExit = true;
                    break;
                }
            }
            if (canExit) break;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] line = br.readLine().split(" ");
            start = Integer.parseInt(line[0]);
            end = Integer.parseInt(line[1]);

            bfs(start);
            System.out.println(visited[end]);
        }
    }
}
