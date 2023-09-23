package string;

import java.util.Scanner;

public class Boj_13223 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        String nowTime = scanner.nextLine();
        String nextTime = scanner.nextLine();

        int nowHour = Integer.parseInt(nowTime.substring(0, 2));
        int nowMin = Integer.parseInt(nowTime.substring(3, 5));
        int nowSec = Integer.parseInt(nowTime.substring(6, 8));
        int nextHour = Integer.parseInt(nextTime.substring(0, 2));
        int nextMin = Integer.parseInt(nextTime.substring(3, 5));
        int nextSec = Integer.parseInt(nextTime.substring(6, 8));

        int totalNowSec = nowHour * 3600 + nowMin * 60 + nowSec;
        int totalNextSec = nextHour * 3600 + nextMin * 60 + nextSec;

        int subSec = totalNextSec - totalNowSec;

        if (subSec <= 0)
            subSec += 24 * 3600;

        int h = subSec / 3600;
        subSec %= 3600;
        int m = subSec / 60;
        int s = subSec % 60;

        System.out.printf("%02d:%02d:%02d", h, m, s);
    }
}
