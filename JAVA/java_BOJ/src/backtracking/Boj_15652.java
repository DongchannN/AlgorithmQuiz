package backtracking;

import java.util.*;
public class Boj_15652 {
    static int n;
    static int m;
    static int[] ans;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        ans = new int[m];
        printAns(1, 0);
    }
    private static void printAns(int num, int idx) {
        if (idx >= m) {
            for (int i = 0; i < m; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = num; i <= n; i++) {
            ans[idx] = i;
            printAns(i, idx + 1);
        }
    }
}
