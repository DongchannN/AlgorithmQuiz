package dataStructure;

import java.util.*;

public class Boj_2309 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        List<Integer> height = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int inputNum = scanner.nextInt();
            height.add(inputNum);
            sum += inputNum;
        }

        int overHeight = sum - 100;

        List<Integer> deleteIndex = new ArrayList<>();
        for (int i = 0; i < height.size(); i++) {
            int firstNum = height.get(i);
            for (int k = i + 1; k < height.size(); k++) {

                int secondNum = height.get(k);

                if (firstNum + secondNum == overHeight) {
                    deleteIndex.add(firstNum);
                    deleteIndex.add(secondNum);
                    break;
                }
            }
            if (deleteIndex.size() == 2) {
                break;
            }
        }
        height.remove(deleteIndex.get(0));
        height.remove(deleteIndex.get(1));
        Collections.sort(height);

        for (Integer integer : height) {
            System.out.println(integer);
        }
    }
}
