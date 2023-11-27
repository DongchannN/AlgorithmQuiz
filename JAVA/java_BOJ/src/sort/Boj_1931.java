package sort;

import java.io.*;
import java.util.*;

/**
 * 끝나는 시간이 빠른 순으로 정렬, 끝나는 시간이 같다면 시작 시간이 빠른 회의가 앞
 */
public class Boj_1931 {
    public static class TimeInfo {
        private int startTime;
        private int endTime;
        private int totalTime;

        public TimeInfo() { }
        public TimeInfo(int startTime, int endTime, int totalTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.totalTime = totalTime;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TimeInfo[] arr = new TimeInfo[n];
        List<TimeInfo> reservedTime = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int startTime = Integer.parseInt(s[0]);
            int endTime = Integer.parseInt(s[1]);
            int totalTime = endTime - startTime;
            arr[i] = new TimeInfo(startTime, endTime, totalTime);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a.endTime == b.endTime) return a.startTime - b.startTime;
            return a.endTime - b.endTime;
        });

        int cnt = 1;
        reservedTime.add(arr[0]);
        for (int i = 1; i < n; i++) {
            int flag = 1;

            if (arr[i].startTime < reservedTime.get(reservedTime.size() - 1).endTime
                    && arr[i].endTime > reservedTime.get(reservedTime.size() - 1).startTime)
                flag = 0;
            if (flag == 1) {
                reservedTime.add(arr[i]);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
