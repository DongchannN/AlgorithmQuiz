package stack;

import java.util.*;
import java.io.*;

public class Boj_2504 {

    static class Element {
        int phase;
        int num;

        public Element(int phase, int num) {
            this.phase = phase;
            this.num = num;
        }
    }

    void calculateStackElements(Deque<Element> calculateStack) {
        Element nowElement = calculateStack.pollFirst();
        if (nowElement == null)
            return;
        if (calculateStack.peekFirst() == null) {
            calculateStack.offerFirst(nowElement);
            return;
        }
        Element previous = calculateStack.peekFirst();
        if (nowElement.phase == previous.phase) {
            previous.num += nowElement.num;
            calculateStackElements(calculateStack);
        } else if (nowElement.phase == previous.phase - 1) {
            previous.num *= nowElement.num;
            previous.phase--;
            calculateStackElements(calculateStack);
        } else {
            calculateStack.offerFirst(nowElement);
            return ;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        Deque<Character> stack = new LinkedList<>();
        Deque<Element> calculateStack = new LinkedList<>();

        int exitCode = 0;
        for (char c : arr) {
            if (c == '(' || c == '[')
                stack.offerFirst(c);
            else if (c == ']') {
                if (stack.size() == 0 || stack.peekFirst() != '[') {
                    exitCode = -1;
                    break;
                } else {
                    stack.pollFirst();
                    Element element = new Element(stack.size(), 3);
                    calculateStack.offerFirst(element);
                    calculateStackElements(calculateStack);
                }
            } else if (c == ')') {
                if (stack.size() == 0 || stack.peekFirst() != '(') {
                    exitCode = -1;
                    break;
                } else {
                    stack.pollFirst();
                    Element element = new Element(stack.size(), 2);
                    calculateStack.offerFirst(element);
                    calculateStackElements(calculateStack);
                }
            }
        }
        calculateStackElements(calculateStack);
        if (exitCode == -1 || !stack.isEmpty()) System.out.println(0);
        else System.out.println(calculateStack.peek().num);
    }
}
