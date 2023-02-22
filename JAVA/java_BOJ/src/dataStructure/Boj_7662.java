package dataStructure;

import java.util.*;

public class Boj_7662 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for (int i = 0; i < testCase; i++) {
            int queueSize = scanner.nextInt();

            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int j = 0; j < queueSize; j++) {

                String operate = scanner.next();
                int num = scanner.nextInt();

                if (Objects.equals(operate, "D") && num == 1) {
                    if (treeMap.size() != 0) {
                        int maxNum = treeMap.lastKey();
                        int amount = treeMap.get(maxNum);
                        if (amount == 1) {
                            treeMap.remove(maxNum);
                        } else {
                            treeMap.put(maxNum, amount - 1);
                        }
                    }
                } else if (Objects.equals(operate, "D") && num == -1) {
                    if(treeMap.size() != 0){
                        int minNum = treeMap.firstKey();
                        int amount = treeMap.get(minNum);
                        if (amount == 1) {
                            treeMap.remove(minNum);
                        } else {
                            treeMap.put(minNum, amount - 1);
                        }
                    }
                } else if (Objects.equals(operate, "I")) {
                    int amount = treeMap.getOrDefault(num, 0);
                    treeMap.put(num, amount + 1);
                }
            }

            if (treeMap.size() == 0) {
                System.out.println("EMPTY");
            } else System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
        }
    }

}
