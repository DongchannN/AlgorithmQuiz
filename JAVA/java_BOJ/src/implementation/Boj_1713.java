package implementation;

import java.io.*;
import java.util.*;

public class Boj_1713 {
    static int n;
    static int seq = 1;
    static Candidate[] candidates = new Candidate[101];


    static class Candidate {
        int seq;
        int amount;

        Candidate() {}
        Candidate(int seq, int amount) {
            this.seq = seq;
            this.amount = amount;
        }
    }

    static void registerCandidate(int recommend) {
        Candidate lowest = new Candidate(Integer.MAX_VALUE, Integer.MAX_VALUE);
        int lowestIdx = 0;
        int cnt = 0;
        for (int i = 1; i <= 100; i++) {
            Candidate now = candidates[i];
            if (now.amount == 0) continue;
            cnt++;
            if (now.amount == lowest.amount) {
                if (now.seq < lowest.seq) {
                    lowest = now;
                    lowestIdx = i;
                }
            } else {
                if (now.amount < lowest.amount) {
                    lowest = now;
                    lowestIdx = i;
                }
            }
        }

        if (cnt >= n) candidates[lowestIdx].amount = 0;
        candidates[recommend].amount++;
        candidates[recommend].seq = seq++;
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        int[] recommends = new int[m];
        for (int i = 0; i < m; i++)
            recommends[i] = Integer.parseInt(line[i]);
        for (int i = 0; i <= 100; i++)
            candidates[i] = new Candidate(0, 0);

        for (int recommend : recommends) {
            if (candidates[recommend].amount != 0) {
                candidates[recommend].amount++;
                continue;
            }
            registerCandidate(recommend);
        }

        for (int i = 1; i <= 100; i++) {
            if (candidates[i].amount != 0)
                System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
