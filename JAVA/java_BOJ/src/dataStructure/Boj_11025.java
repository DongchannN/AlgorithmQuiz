package dataStructure;

import java.util.Scanner;


public class Boj_11025 {
    public void solution(){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] mostCost = new int[number+1];  //카드를 가장 비싸개 뽑는 가격. ex) mostCost[3]는 카드 세장을 뽑는 가장 비싼 가격.
        int[] P = new int[number+1];   //카드의 가격.

        P[0] = 0;
        mostCost[0] = 0;
        for(int i = 1; i < number + 1; i++) {  //가격 입력받기.
            P[i] = scanner.nextInt();
        }

        for(int i = 1; i < number + 1; i++) {
            int[] compare = new int[i];  //최대 가격에 대한 경우의 수 총 대입
            for(int j = 0; j < i; j++) {
                compare[j] = mostCost[j] + P[i - j];
            }
            mostCost[i] = getMax(compare, i);  //경우의 수 중 가장
        }
        System.out.println(mostCost[number]);

    }

    static int getMax(int[] compare, int size) { //배열 중 가장 큰 값 반환.
        int max = compare[0];
        for(int i = 1; i < size; i++) {
            if(max < compare[i]) max = compare[i];
        }
        return max;
    }
}
