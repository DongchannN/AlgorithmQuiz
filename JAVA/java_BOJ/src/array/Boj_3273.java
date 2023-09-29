package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3273 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[2000001];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[Integer.parseInt(s[i])]++;
        }

        int num = Integer.parseInt(br.readLine());
        int loop = num / 2;
        if (num % 2 == 0)
            loop = num / 2 - 1;
        int cnt = 0;
        for (int i = 1; i <= loop; i++) {
            if (arr[i] == 1 && arr[num - i] == 1)
                cnt++;
        }
        System.out.println(cnt);
    }
}
