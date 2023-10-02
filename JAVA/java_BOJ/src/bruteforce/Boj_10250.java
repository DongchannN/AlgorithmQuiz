package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10250 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            int height = Integer.parseInt(input[0]);
            int width = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);

            System.out.printf("%d%02d\n", (n - 1) % height + 1, (n - 1) / height + 1);
        }
    }
}
