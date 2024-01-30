package recursion;

import java.io.*;
import java.util.*;

public class Boj_17136 {

    static int[] papers = {0, 5, 5, 5, 5, 5}; // 색종이의 남은 개수 저장.
    static int[][] map;
    static int ans = 26;
    static int cnt = 0;

    /**
     * 2차원 map을 정한 숫자로 채움.
     * 파라미터로 입력된 row, col을 기준으로 size크기의 정사각형 만큼. (방향을 오른쪽, 아래.)
     */
    void fillMap(int row, int col, int size, int i) {
        for (int r = row; r < row + size; r++)
            for (int c = col; c < col + size; c++)
                map[r][c] = i;
    }

    /**
     * row, col을 기준으로 size만큼의 색종이를 붙일 수 있는 경우 true 반환
     * size크기의 정사각형 안에 0이 있는 경우 붙일 수 없음.
     * size크기의 정사각형이 map의 범위를 넘어가는 경우 붙일 수 없음.
     */
    boolean isValid(int row, int col, int size) {
        if (row + size - 1 > 10
                || col + size - 1 > 10)
            return false;

        for (int r = row; r < row + size; r++) {
            for (int c = col; c < col + size; c++) {
                if (map[r][c] == 0) return false;
            }
        }
        return true;
    }

    /**
     * parameter로 입력된 row, col을 기준으로 다음에 색종이를 붙여야할 공간 1 이 있는지 확인.
     * 있다면 해당 row, col을 int[2] 배열로 반환 배열의 첫번째 요소는 row, 두번째 요소는 col
     */
    int[] checkNext(int row, int col) {
        int nextRow = -1;
        int nextCol = -1;

        for (int c = col; c <= 10; c++) {
            if (map[row][c] == 1) {
                nextRow = row;
                nextCol = c;
                return new int[]{nextRow, nextCol};
            }
        }
        for (int r = row + 1; r <= 10; r++) {
            for (int c = 1; c <= 10; c++) {
                if (map[r][c] == 1) {
                    nextRow = r;
                    nextCol = c;
                    return new int[]{nextRow, nextCol};
                }
            }
        }
        return new int[]{nextRow, nextCol};
    }

    void recursion(int nowRow, int nowCol) {
        int[] next = checkNext(nowRow, nowCol);
        if (next[0] == -1 || next[1] == -1) {
            ans = Math.min(cnt, ans);
            return ;
        }

        for (int size = 1; size <= 5; size++) {
            if (papers[size] == 0) continue;
            if (!isValid(next[0], next[1], size)) continue;

            fillMap(next[0], next[1], size, 0);
            papers[size]--;
            cnt++;
            recursion(next[0], next[1]);
            fillMap(next[0], next[1], size, 1);
            papers[size]++;
            cnt--;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[11][11];

        for (int i = 1; i <= 10; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= 10; j++)
                map[i][j] = Integer.parseInt(input[j - 1]);
        }

        recursion(1, 1);
        if (ans == 26) System.out.println("-1");
        else System.out.println(ans);
    }
}
