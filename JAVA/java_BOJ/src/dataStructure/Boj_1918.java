package dataStructure;

import java.util.EmptyStackException;
import java.io.IOException;
import java.util.*;

public class Boj_1918 {
    public void solution() throws IOException, EmptyStackException {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<String>();
        List<Integer> priorityList = new ArrayList<>();
        Stack stack = new Stack();

        String inputExpression = scanner.nextLine();

        for (int i = 0; i < inputExpression.length(); i++) {

            int priority = numbering(inputExpression.charAt(i));
            priorityList.add(priority);

            if (priority == 2 && priorityList.contains(1)) {
                while (!(stack.isEmpty())) {
                    result.add(String.valueOf(stack.pop()));
                }
                stack.push(inputExpression.charAt(i));
                continue;
            }else if (priority == 2) stack.push(inputExpression.charAt(i));
            if (priority == 1) {
                stack.push(inputExpression.charAt(i));
                continue;
            }
            if (priority == 0) {
                result.add(String.valueOf(stack.pop()));
                continue;
            }
            if (priority == 3) {
                result.add(String.valueOf(inputExpression.charAt(i)));
            }
        }
        while (!(stack.isEmpty())) result.add(String.valueOf(stack.pop()));
        String ans = String.join("",result);
        System.out.println(ans);

    }
    int numbering(char operator) {
        if (operator == '+' || operator == '-') {
            return 2;
        }
        else if (operator == '*' || operator == '/') {
            return 1;
        }
        else if (operator == ')') {
            return 0;
        }
        else return 3;
    }
}
