package dataStructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Boj_11025 {
    public void solution(){
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int[] cost = new int[number];
        double[] oneCardCost = new double[number];
        double[] sortedCardCost;
        double[][] costAndOneCost = new double[number][2];

        for (int i = 0; i < number; i++) {
            cost[i] = scanner.nextInt();
            oneCardCost[i] = (double) cost[i] / (i+1);
            costAndOneCost[i][0] = cost[i];
            costAndOneCost[i][1] = oneCardCost[i];
        }
        sortedCardCost = oneCardCost.clone();
        Arrays.sort(sortedCardCost);

        double money = 0;
        int num = number;
        for(int i = 0; i < number; i++) {
            double finder = sortedCardCost[number-1-i];  //가장 큰 수부터 찾기 finder는 카드 한개 당 가격.
            int numberOfCard = findIndex(finder, oneCardCost, number) + 1;  //카드의 갯수 ( 그 수의 인덱스 + 1)
            int buyMax = num / numberOfCard;
            if(buyMax == 0) continue;
            num -= numberOfCard * buyMax;
            money += finder * numberOfCard * buyMax;
        }

        System.out.println((int)money);


    }
    static int findIndex(double findNumber, double[] array, int arraySize) {
        int index = -1;
        for(int i = 0; i < arraySize; i++) {
            if(findNumber == array[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
