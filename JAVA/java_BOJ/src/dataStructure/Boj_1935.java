package dataStructure;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Boj_1935 {
    public void solution() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Stack saver = new Stack<>();
        int variableAmount = Integer.parseInt(scanner.nextLine());

        String expression = scanner.nextLine();

        double[] variableInput = new double[30];

        for (int i = 0; i < variableAmount; i+=1) {
            int input = Integer.parseInt(scanner.nextLine());
            variableInput[i] = (float) input;
        }

        for(int i = 0; i < expression.length(); i += 1) {
            int asciiCode = (int) expression.charAt(i);

            if (65 <= asciiCode && asciiCode <=90) {
                saver.push(variableInput[asciiCode-65]);
            }else {
                double num2 = (double) saver.pop();
                double num1 = (double) saver.pop();
                double result;
                switch (asciiCode) {
                    case 43:
                        result = num1 + num2;
                        saver.push(result);
                        break;

                    case 45:
                        result = num1 - num2;
                        saver.push(result);
                        break;

                    case 42:
                        result = num1 * num2;
                        saver.push(result);
                        break;

                    case 47:
                        result = num1 / num2;
                        saver.push(result);
                        break;
                }
            }
        }
        System.out.printf("%.2f",saver.pop());
    }
}