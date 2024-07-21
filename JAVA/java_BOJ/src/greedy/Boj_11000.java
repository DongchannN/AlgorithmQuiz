package greedy;

import java.util.*;
import java.io.*;

public class Boj_11000 {
    int n;
    Lecture[] lectures;

    static class Lecture {
        int start;
        int end;
        int time;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
            time = end - start;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lectures = new Lecture[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            lectures[i] = new Lecture(s, e);
        }
        Arrays.sort(lectures, (a, b) -> {
            if (a.start == b.start) return (a.end - b.end);
            return (a.start - b.start);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Lecture lec : lectures) {
            if (!pq.isEmpty() && pq.peek() <= lec.start)
            {
                pq.poll();
                pq.add(lec.end);
                continue;
            }
            pq.add(lec.end);
        }
        System.out.println(pq.size());
    }
}
