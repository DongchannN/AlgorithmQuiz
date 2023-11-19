package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2817 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalVoter = Integer.parseInt(br.readLine());
        int candidate = Integer.parseInt(br.readLine());
        int[] alps = new int[26];
        boolean[] isValidCandidate = new boolean[26];

        float[][] set = new float[26][14];

        for (int i = 0; i < candidate; i++) {
            String[] s = br.readLine().split(" "); // s[0] : 후보자, s[1] : 후보자가 받은 표 수
            char c = s[0].charAt(0);
            if (Float.parseFloat(s[1]) / totalVoter < 0.05) // 5% 미만인 후보자 제외.
                continue;
            isValidCandidate[c - 'A'] = true;
            set[c - 'A'][0] = Float.parseFloat(s[1]);
            for (int j = 2; j <= 14; j++)
                set[c - 'A'][j - 1] = set[c - 'A'][0] / j;
        }

        float maxNum = set[0][0];
        int maxIdx = 0;
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 26; j++) {
                if (maxNum < set[j][alps[j]]) {
                    maxNum = set[j][alps[j]];
                    maxIdx = j;
                }
            }
            alps[maxIdx]++;
            maxNum = set[maxIdx][alps[maxIdx]];
        }

        for (int i = 0; i < 26; i++) {
            if (!isValidCandidate[i])
                continue;
            System.out.printf("%c %d\n", i + 'A', alps[i]);
        }
    }
}
