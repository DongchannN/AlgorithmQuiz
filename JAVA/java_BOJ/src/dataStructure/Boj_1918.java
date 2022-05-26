package dataStructure;

import java.util.EmptyStackException;
import java.io.IOException;
import java.util.*;

public class Boj_1918 {
    public void solution() throws IOException, EmptyStackException {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> operatorStack = new Stack<>();
        ArrayList outputExpression = new ArrayList<>();
        String inputExpression = scanner.nextLine();

        for (int i = 0; i < inputExpression.length(); i++) {
            char indexChar = inputExpression.charAt(i);

            switch (indexChar) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!(operatorStack.isEmpty()) && numberingPriority(operatorStack.peek()) >= numberingPriority(indexChar)) {
                        outputExpression.add(operatorStack.pop());
                    }
                    operatorStack.add(indexChar);
                    break;
                case ')':
                    while(!(operatorStack.isEmpty()) && operatorStack.peek() != '(') {
                        outputExpression.add(operatorStack.pop());
                    }

                    operatorStack.pop();

                    break;
                case '(':
                    operatorStack.push(indexChar);
                    break;
                default:
                    outputExpression.add(indexChar);
            }

        }

        while(!(operatorStack.isEmpty())) {
                outputExpression.add(operatorStack.pop());
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i<outputExpression.size(); i++){
            ans.append(outputExpression.get(i));
        }
        System.out.println(ans);
    }

    int numberingPriority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        }
        else if (operator == '*' || operator == '/') {
            return 2;
        }
        else if (operator == ')' || operator == '(') {
            return 0;
        }
        return -1;
    }
}
