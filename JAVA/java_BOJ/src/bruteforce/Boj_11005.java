package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_11005 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int num = Integer.parseInt(inputs[0]);
        int base = Integer.parseInt(inputs[1]);

        char[] baseArr = new char[base];
        for (int i = 0; i < base; i++) {
            if (i < 10)
                baseArr[i] = (char) (i + '0');
            else
                baseArr[i] = (char) ('A' + (i - 10));
        }

        List<String> ans = new ArrayList<>();
        while (num > 0) {
            ans.add(String.valueOf(baseArr[num % base]));
            num /= base;
        }
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.printf("%s", ans.get(i));
        }
        System.out.println();
    }
}
