package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3058_2 {
    static int n;
    static char[][] map;
    /**
     * 사탕을 교환할 시 아래, 오른쪽만 교환함. (가장 아랫줄, 가장 오른쪽 줄 OutOfBound 주의!)
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++)
            map[i] = br.readLine().toCharArray();

        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && map[i][j] != map[i][j + 1]) { // 오른쪽과 바꾸기
                    swapCandy(i, j, i, j + 1);
                    ans = Math.max(ans, Math.max(findMaxCol(), findMaxRow())); // 바꾸고 최대 찾기
                    swapCandy(i, j, i, j + 1);
                }
                if (i + 1 < n && map[i][j] != map[i + 1][j]) { // 아래쪽과 바꾸기
                    swapCandy(i, j, i + 1, j);
                    ans = Math.max(ans, Math.max(findMaxCol(), findMaxRow()));
                    swapCandy(i, j, i + 1, j);
                }
            }
        System.out.println(ans);
    }

    private void swapCandy(int i1, int j1, int i2, int j2) {
        char temp = map[i1][j1];
        map[i1][j1] = map[i2][j2];
        map[i2][j2] = temp;
    }

    /**
     * 가장 긴 연속 Row(열, 가로) 확인
     * @return
     */
    private int findMaxRow() {
        int ret = 1;
        for (int r = 0; r < n; r++) {
            int len = 1;
            for (int c = 1; c < n; c++) {
                if (map[r][c] == map[r][c - 1]) {
                    len++;
                } else {
                    ret = Math.max(ret, len);
                    len = 1;
                }
            }
            ret = Math.max(ret, len);
        }
        return ret;
    }

    /**
     * 가장 긴 연속 Column(행, 세로) 확인
     */
    private int findMaxCol() {
        int ret = 1;
        for (int c = 0; c < n; c++) {
            int len = 1;
            for (int r = 1; r < n; r++) {
                if (map[r][c] == map[r - 1][c]) {
                    len++;
                } else {
                    ret = Math.max(ret, len);
                    len = 1;
                }
            }
            ret = Math.max(ret, len);
        }
        return ret;
    }
}
