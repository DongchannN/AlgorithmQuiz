package string;

import java.util.Scanner;

public class Boj_13223 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        String nowStr = scanner.nextLine();
        String nextStr = scanner.nextLine();
        String[] nowSplit = nowStr.split(":");
        String[] nextSplit = nextStr.split(":");

        int nowHour = Integer.parseInt(nowSplit[0]);
        int nowMin = Integer.parseInt(nowSplit[1]);
        int nowSec = Integer.parseInt(nowSplit[2]);

        int nextHour = Integer.parseInt(nextSplit[0]);
        int nextMin = Integer.parseInt(nextSplit[1]);
        int nextSec = Integer.parseInt(nextSplit[2]);

        int sec;
        System.out.println("sec : " + (nextSec - nowSec));
        if (nextSec - nowSec < 0) {
            nextMin -= 1;
            sec = 60 + (nextSec - nowSec);
        } else sec = nextSec - nowSec;

        int min;
        System.out.println("min : " + (nextMin - nowMin));
        if (nextMin - nowMin < 0) {
            nextHour -= 1;
            min = 60 + (nextMin - nowMin);
        } else min = nextMin - nowMin;

        int hour;
        System.out.println("H : " + (nextHour - nowHour));
        if (nextHour - nowHour < 0) {
            hour = 24 + (nextHour - nowHour);
        } else hour = nextHour - nowHour;

        String h = Integer.toString(hour);
        String m = Integer.toString(min);
        String s = Integer.toString(sec);

        if (h.length() == 1) {
            h = "0" + h;
        }
        if (m.length() == 1) {
            m = "0" + m;
        }
        if (s.length() == 1) {
            s = "0" + s;
        }
        System.out.println(h + ":" + m + ":" + s);
    }
}
