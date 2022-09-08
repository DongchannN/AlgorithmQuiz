package dataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_2156 {
    //세가지 케이스를 저장할 배열.
    static ArrayList<Integer> ans = new ArrayList<>();

    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int drinkable = scanner.nextInt(); //마실 수 있는 잔의 수.

        //잔의 용량, 입력.
        int[] capacity = new int[drinkable+1];
        for (int i = 0; i < drinkable; i++) {
            capacity[i] = scanner.nextInt();
        }

        //drinkable 이 홀수면 짝수를 만들기 위해 0을 뒤에 붙임.
        if (drinkable % 2 == 1) {
            capacity[drinkable + 1] = 0;
        }

        executeCase(1, 0, capacity);

        System.out.println(ans.get(0));

    }

    static void executeCase(int caseNum, int startIndex, int[] arr) {
        if (startIndex == arr.length) {
            ans.add(addArr(arr));
            return;
        }

        if (caseNum == 1) {
            arr[startIndex + 1] = 0;
            startIndex += 2;
            executeCase(2, startIndex, arr);
        } else if (caseNum == 2) {
            startIndex += 2;
            executeCase(3, startIndex, arr);
        } else {
            arr[startIndex] = 0;
            startIndex += 2;
            executeCase(1, startIndex, arr);
        }
    }

    static int addArr(int[] arr) {
        int add = 0;
        for (int j : arr) {
            add += j;
        }
        return add;
    }
}
