package dataStructure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_1935 {
    public void solution() throws IOException {
        Scanner scanner = new Scanner(System.in);

        List<Integer> variableNumber = new ArrayList<>();
        List<String> afterExpression = new ArrayList<>();

        int variableAmount;        //amount of variable
        String inputExpression;    //Expression

        variableAmount = Integer.parseInt(scanner.nextLine());
        inputExpression = scanner.nextLine();

        for (int i = 0; i < variableAmount; i+=1) {
            int inputNumber = Integer.parseInt(scanner.nextLine());
            variableNumber.add(inputNumber);
        }

        for (int index = 0; index < inputExpression.length(); index+=1) {

        }
    }
}
