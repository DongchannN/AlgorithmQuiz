package dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj_1912 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();

        ArrayList<Long> sumArray = new ArrayList<Long>();
        int[] arr = new int[arrSize];

        for(int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
            sumArray.add((long) arr[i]);
        }

        for(int i = 1; i <= arrSize; i++) {
            int j = arrSize + 1 - i;
            for(int k = 0; k < j; k++) {
                long addElement = sumPartOfArr(k, k+i-1, arr);
                if(addElement > Collections.max(sumArray)) {
                    sumArray.clear();
                    sumArray.add(addElement);
                }
            }
        }
        long max = Collections.max(sumArray);

        System.out.println(max);


    }

    long sumPartOfArr(int startPoint, int endPoint, int[] arr) {
        long sum = 0;
        for(int i = startPoint; i <= endPoint; i++) {
            sum += arr[i];
        }
        return sum;
    }

}
