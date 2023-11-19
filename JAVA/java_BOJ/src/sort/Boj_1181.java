package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Boj_1181 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.length() < b.length()) return -1;
            else if (a.length() > b.length()) return 1;
            return a.compareTo(b);
        });
        for (int i = 0; i < n; i++) {
            int print = 1;
            for (int j = 0; j < i; j++) {
                if (Objects.equals(arr[i], arr[j])) {
                    print = 0;
                    break;
                }
            }
            if (print == 1) System.out.println(arr[i]);
        }
    }
}

