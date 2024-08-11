package sort;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;

/**
quick_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
    if (p < r) then {
        q <- partition(A, p, r);  # 분할
        quick_sort(A, p, q - 1);  # 왼쪽 부분 배열 정렬
        quick_sort(A, q + 1, r);  # 오른쪽 부분 배열 정렬
    }
}

partition(A[], p, r) {
    x <- A[r];    # 기준원소
    i <- p - 1;   # i는 x보다 작거나 작은 원소들의 끝지점
    for j <- p to r - 1  # j는 아직 정해지지 않은 원소들의 시작 지점
    if (A[j] ≤ x) then A[++i] <-> A[j]; # i값 증가 후 A[i] <-> A[j] 교환
    if (i + 1 != r) then A[i + 1] <-> A[r]; # i + 1과 r이 서로 다르면 A[i + 1]과 A[r]을 교환
    return i + 1;
}
**/
public class Boj_24090 {

    static int[] arr;
    static int k;
    static int cnt = 0;
    static int[] ans;

    static void quickSort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            quickSort(p, q - 1);
            quickSort(q + 1, r);
        }
    }

    static int partition(int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (++cnt == k)
                    ans = new int[]{arr[i], arr[j]};
            }
        }
        if (i + 1 != r) {
            int temp = arr[i + 1];
            arr[i + 1] = arr[r];
            arr[r] = temp;
            if (++cnt == k)
                ans = new int[]{arr[i + 1], arr[r]};
        }
        return (i + 1);
    }


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        line = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(line[i]);
        quickSort(0, n - 1);
        if (cnt < k)
            System.out.println("-1");
        else {
            Arrays.sort(ans);
            System.out.printf("%d %d\n", ans[0], ans[1]);
        }
    }
}
