package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_10448 {
    public void solution() throws IOException {
        int sum = 0;
        int add = 1;
        List<Integer> arr = new ArrayList<>();
        while (sum <= 1000) {
            arr.add(sum);
            sum += add;
            add++;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int num = Integer.parseInt(br.readLine());

            boolean find = false;
            for (int p = 1; p < arr.size(); p++) {
                for (int q = 1; q < arr.size(); q++) {
                    for (int r = 1; r < arr.size(); r++) {
                        int ans = arr.get(p) + arr.get(q) + arr.get(r);
                        if (ans == num) {
                            find = true;
                            break;
                        }
                    }
                    if (find)
                        break;
                }
                if (find)
                    break;
            }
            if (find)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
