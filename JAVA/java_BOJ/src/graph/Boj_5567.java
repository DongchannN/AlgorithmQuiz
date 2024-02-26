package graph;

import java.io.*;
import java.util.*;

public class Boj_5567 {
    List<Integer>[] map;
    boolean[] visited;
    int n, m;

    void sol(int now, int depth) {
        if (depth > 3) return ;
        visited[now] = true;
        List<Integer> friends = map[now];

        for (int i = 0; i < friends.size(); i++) {
            int friend = friends.get(i);
            sol(friend, depth + 1);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        map = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            map[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            map[a].add(b);
            map[b].add(a);
        }
        sol(1, 1);

        int cnt = 0;
        for (int i = 0; i < n + 1; i++) {
            if (visited[i]) cnt++;
        }
        System.out.println(cnt - 1);
    }
}
