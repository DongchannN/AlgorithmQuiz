package dataStructure;

import java.util.Scanner;

public class Boj_16194 {
    public void solution(){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] minCost = new int[number+1];  //카드를 가장 싸게 뽑는 가격. ex) mostCost[3]는 카드 세장을 뽑는 가장 비싼 가격.
        int[] P = new int[number+1];   //카드의 가격.

        P[0] = 0;
        minCost[0] = 0;
        for(int i = 1; i < number + 1; i++) {  //가격 입력받기.
            P[i] = scanner.nextInt();
        }

        for(int i = 1; i < number + 1; i++) {
            int[] compare = new int[i];  //최대 가격에 대한 경우의 수 총 대입
            for(int j = 0; j < i; j++) {
                compare[j] = minCost[j] + P[i - j];
            }
            minCost[i] = getMin(compare, i);  //경우의 수 중 가장
        }
        System.out.println(minCost[number]);

    }

    static int getMin(int[] compare, int size) { //배열 중 가장 큰 값 반환.
        int min = compare[0];
        for(int i = 1; i < size; i++) {
            if(min > compare[i]) min = compare[i];
        }
        return min;
    }
}
