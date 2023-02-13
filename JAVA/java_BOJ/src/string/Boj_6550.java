package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Boj_6550 {
    public void solution() {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String[] inputString = new String[2];
            for (int i = 0; i < 2; i++) {
                inputString[i] = scanner.next();
            }


            String[] firstString = inputString[0].split("");
            List<String> firstNewString = new ArrayList<>(Arrays.asList(firstString));

            String[] secondString = inputString[1].split("");

            for (String s : secondString) {
                if (!firstNewString.isEmpty() && s.equals(firstNewString.get(0))) {
                    firstNewString.remove(0);
                }
            }
            if (firstNewString.isEmpty()) {
                System.out.println("Yes");
            } else System.out.println("No");

        }
    }
}
