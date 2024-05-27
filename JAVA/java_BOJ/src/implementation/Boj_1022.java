package implementation;

import java.io.*;

public class Boj_1022 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int r1, c1, r2, c2, shiftR, shiftC;
    static int[] diag;
    static int[][] map;

    static class Point {
        int row;
        int col;

        int getIdx() {
            if (Math.abs(row) != Math.abs(col)) {
                return -1;
            }
            if (row >= 0) {
                return (row * 2);
            } else {
                return ((col * 2) - 1);
            }
        }
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static void doUnderGo(Point p) {
        int dr = dy[0];
        int dc = dx[0];
        int l = Math.abs(p.row);
        int r = p.row;
        int c = p.col;
        int val = diag[p.getIdx()];
        while (r != -(l + 1) || c != l + 1) {
            if (r == l && c == l + 1) {
                dr = dy[1];
                dc = dx[1];
            }
            if ((r1 <= r && r <= r2) && (c1 <= c && c <= c2)) {
                map[r + shiftR][c + shiftC] = val;
            }
            r += dr;
            c += dc;
            val++;
        }
    }

    static void doUpperGo(Point p) {
        int dr = dy[2];
        int dc = dx[2];
        int l = Math.abs(p.row);
        int r = p.row;
        int c = p.col;
        int val = diag[p.getIdx()];
        while (r!= l || c!= -l) {
            if (r == -l && c == -l) {
                dr = dy[3];
                dc = dx[3];
            }
            if (r1 <= r && r <= r2 && c1 <= c && c <= c2) {
                map[r + shiftR][c + shiftC] = val;
            }
            r += dr;
            c += dc;
            val++;
        }
    }

    static void makeMap(Point startP, Point endP) {
        for (int p = Math.abs(startP.row); p <= Math.abs(endP.row); p++) {
            doUnderGo(new Point(p, -p));
            doUpperGo(new Point(-p, p));
        }
    }

    static int getLongestLen() {
        int len1 = String.valueOf(map[0][0]).length();
        int len2 = String.valueOf(map[0][c2 - c1]).length();
        int len3 = String.valueOf(map[r2 - r1][0]).length();
        int len4 = String.valueOf(map[r2 - r1][c2 - c1]).length();

        return (Math.max(Math.max(len1, len2), Math.max(len3, len4)));
    }

    public void solution() throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r1 = Integer.parseInt(input[0]);
        c1 = Integer.parseInt(input[1]);
        r2 = Integer.parseInt(input[2]);
        c2 = Integer.parseInt(input[3]);
        shiftR = -(r1);
        shiftC = -(c1);
        map = new int[r2 - r1 + 1][c2 - c1 + 1];
        diag = new int[10001];
        diag[0] = 1;
        int add = 2;
        for (int i = 1; i < 10001; i++) {
            diag[i] = diag[i - 1] + add;
            add += 2;
        }
        int s1 = Math.min(Math.abs(r1), Math.abs(c1));
        int s2 = Math.min(Math.abs(r2), Math.abs(c2));
        int start = Math.min(s1, s2);
        if (start > 0) start--;
        if (r1 <= 0 && 0 <= r2 && c1 <= 0 && 0 <= c2) start = 0;
        int e1 = Math.max(Math.abs(r1), Math.abs(c1));
        int e2 = Math.max(Math.abs(r2), Math.abs(c2));
        int end = Math.max(e1, e2);
        Point startP = new Point(start, -1 * start);
        Point endP = new Point(-1 * end,end);
        makeMap(startP, endP);
        int longestLen = getLongestLen();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int surplusSpace = longestLen - String.valueOf(map[i][j]).length();
                for (int k = 0; k < surplusSpace; k++) {
                    sb.append(" ");
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
