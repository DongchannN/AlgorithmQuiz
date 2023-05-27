package dfs;

import java.io.BufferedReader;
import java.util.*;

public class Boj_14940 {
    static int depth;
    static int width;
    static int[][] map;
    static int[][] ans;
    static boolean[][] visited;
    static int[] moveY = {-1, 1, 0, 0};
    static int[] moveX = {0, 0, -1, 1};

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        depth = scanner.nextInt();
        width = scanner.nextInt();
        map = new int[depth][width];
        ans = new int[depth][width];
        Location startPoint = new Location(0,0);
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 2) {
                    startPoint.y = i;
                    startPoint.x = j;
                }
            }
        }
        visited = new boolean[depth][width];
        bfs(startPoint.y, startPoint.x);

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < width; j++) {
                if (ans[i][j] == 0 && map[i][j] == 1) {
                    ans[i][j] = -1;
                }
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void bfs(int startY, int startX) {

        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(startY, startX));
        visited[startY][startX] = true;

        while(!queue.isEmpty()){
            Location nowLocation = queue.poll();
            for (int i = 0; i < 4; i++) {

                int nextY = nowLocation.y + moveY[i];
                int nextX = nowLocation.x + moveX[i];

                if (nextY < 0 || nextY > depth - 1 || nextX < 0 || nextX > width - 1) {
                    continue;
                }

                if (map[nextY][nextX] == 0 || visited[nextY][nextX]) {
                    continue;
                }

                queue.add(new Location(nextY, nextX));
                ans[nextY][nextX] = ans[nowLocation.y][nowLocation.x] + 1;
                visited[nextY][nextX] = true;
            }
        }
    }

    class Location {
        int y;
        int x;

        Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
