package dataStructure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Boj_1463 {
    public void solution() throws IOException {
        int input;
        int times = 0;

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(input);

        while ( !(arr.contains(1)) ) {
            int arrSize = arr.size();
            for (int i = 0; i < arrSize; i++) {
                arr.add(arr.get(i)-1);
                if(arr.get(i) % 2 == 0) {
                    arr.add(arr.get(i) / 2);
                }
                if(arr.get(i) % 3 == 0) {
                    arr.add(arr.get(i) / 3);
                }

            }
            if (arrSize > 0) {
                arr.subList(0, arrSize).clear();
            }
            times += 1;

        }


        System.out.println(times);
    }
}
