package recursion;

import java.io.*;
import java.util.*;

public class Boj_10971 {
    
    static int[][] map;
    static int n;
    static boolean[] visited;
    static List<Integer> path;
    static int minDistance;

    int calculateDistance(List<Integer> path) {
        int totalDistance = 0;
        int distance;
        for (int i = 0; i < n - 1; i++) {
            int now = path.get(i);
            int next = path.get(i + 1);
            distance = map[now][next];
            if (distance == 0) return -1;
            totalDistance += distance;
        }
        distance = map[path.get(n - 1)][path.get(0)];
        if (distance == 0) return -1;
        totalDistance += distance;
        return totalDistance;
    }
    void findMap(int depth) {
        if (depth == n) {
            int ret = calculateDistance(path);
            if (ret != -1)
                minDistance = Math.min(ret, minDistance);
            return ;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                path.add(i);
                visited[i] = true;
                int idx = path.size() - 1;

                findMap(depth + 1);

                path.remove(idx);
                visited[i] = false;
            }
        }
    }
    
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n];
        path = new ArrayList<>();
        minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }

        findMap(0);
        System.out.println(minDistance);
    }
}
