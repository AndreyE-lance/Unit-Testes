package task1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;



public class Main {
    //Перевод выражения в обратную польскую запись
    public String getString(String arg) {
        String input = arg;
        Stack<String> sign = new Stack<>();
        Queue<String> numbers = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        String[] arrayValues = input.split(" ");
        for (int i = 0; i < arrayValues.length; i++) {
            String value = arrayValues[i];
            if (value.matches("^[0-9]*$")) {
                numbers.add(value);
            } else {
                if (sign.isEmpty() || value.equals("(")) {
                    sign.push(value);
                } else {
                    if ((sign.peek().equals("*") || sign.peek().equals("/")) && !value.equals(")")) {
                        if (!sign.peek().equals("(")) {
                            numbers.add(sign.pop());
                        }
                        sign.push(value);
                    } else {
                        if (value.equals("*") || value.equals("/")) {
                            sign.push(value);
                        } else {
                            if (value.equals(")")) {
                                while (!sign.peek().equals("(")) {
                                    numbers.add(sign.pop());
                                }
                                sign.pop();
                            } else {
                                if (!sign.peek().equals("(")) {
                                    numbers.add(sign.pop());
                                }
                                sign.push(value);
                            }
                        }
                    }
                }
            }
        }
        while (!sign.isEmpty()) {
            numbers.add(sign.pop());
        }

        while (!numbers.isEmpty()) {
            result.append(numbers.poll()).append(" ");

        }
        return String.valueOf(result);
    }
}