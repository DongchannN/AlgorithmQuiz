package math;

import java.io.*;

public class Boj_1011 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            float dist = y - x;

            long sum = 0;
            int i = 0;
            while (sum < dist / 2) {
                i++;
                sum += i;
            }
            long bound = (sum * 2) - i;

            if (dist <= 3) {
                System.out.println((int) dist);
            } else if (dist <= bound) {
                System.out.println((i * 2) - 1);
            } else {
                System.out.println(i * 2);
            }
        }
    }
}
