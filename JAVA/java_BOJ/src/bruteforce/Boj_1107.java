package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Boj_1107 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int goalNum = scanner.nextInt();
        int length = Integer.toString(goalNum).length();
        int broken = scanner.nextInt();

        List<Integer> brokenNum = new ArrayList<>();
        List<Integer> remoteNum = new ArrayList<>();

        for (int i = 0; i < broken; i++) {
            int num = scanner.nextInt();
            brokenNum.add(num);
        }

        int maxCost = goalNum - 100;
        if (maxCost < 0) {
            maxCost = maxCost * (-1);
        }
        if (maxCost == 0) {
            System.out.println(maxCost);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (brokenNum.contains(i)) {
                continue;
            } else remoteNum.add(i);
        }

        int minCost = maxCost;

        for (int i = 0; i < goalNum + maxCost; i++) {
            boolean checkPass = false;
            for (int num : brokenNum) {
                if (Integer.toString(i).contains(Integer.toString(num))) {
                    checkPass = true;
                    break;
                }
            }

            if (checkPass == false) {
                int cost = Math.abs(goalNum - i);
                if (cost + Integer.toString(i).length() < minCost) {
                    minCost = cost + Integer.toString(i).length();
                }
            }

        }

        System.out.println(minCost);

    }
}
