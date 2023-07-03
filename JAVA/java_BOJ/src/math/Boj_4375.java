package math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_4375 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLong()) {

            Long inputNum = scanner.nextLong();
            Long compared = 0L;
            int i = 0;

            while (true) {
                compared = (compared * 10) + 1;
                compared = compared % inputNum;
                i += 1;
                if (compared == 0L) {
                    break;
                }
            }
            System.out.println(i);
        }
    }
}
