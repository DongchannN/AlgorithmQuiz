package math;

import java.io.*;

public class Boj_2166 {
    int n;
    Point[] points;
    Point[] sortedPoints;
    boolean[] visited;

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        points = new Point[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int input_x = Integer.parseInt(input[0]);
            int input_y = Integer.parseInt(input[1]);
            points[i] = new Point(input_x, input_y);
        }

        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            Point p = points[i];
            Point nextP;
            if (i == n - 1)
                nextP = points[0];
            else
                nextP = points[i + 1];
            sum1 += (long) p.x * nextP.y;
            sum2 += (long) nextP.x * p.y;
        }
        double area = Math.abs(sum1 - sum2) * 0.5;
        System.out.printf("%.1f\n", area);
    }
}
