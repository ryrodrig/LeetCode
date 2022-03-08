package leetcode.stack;

import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    Map<String,Integer> parenthesisMap = new HashMap<String,Integer>();
    {
        parenthesisMap.put("(",1);
        parenthesisMap.put(")",1);
        parenthesisMap.put("{",2);
        parenthesisMap.put("}",2);
        parenthesisMap.put("[",3);
        parenthesisMap.put("]",3);
    }

    public static class Stack {
        String[] items;
        int top = -1;

        Stack(int size) {
            items = new String[size];
        }

        public String pop() {
            if(top == -1) {
                throw new RuntimeException("Stack is empty");
            }
            return items[top--];
        }

        public void push(String item) {
            if(top == items.length) {
                throw new RuntimeException("Stack is full");
            }
            top++;
            items[top] = item;
        }

        public boolean isEmpty() {
            if(top == -1) {
                return true;
            }
            return false;
        }

    }

    public boolean isValid(String s) {
        Stack stack = new Stack(s.length());
        char[] characters = s.toCharArray();

        try {
            for(char character : characters) {
                if(character == '(' || character == '{' || character == '[') {
                    stack.push(String.valueOf(character));
                } else if(character == ')' || character == '}' || character == ']') {
                    String topStack = stack.pop();
                    int popCharWeight = parenthesisMap.get(topStack);
                    int currentCharWeight = parenthesisMap.get(String.valueOf(character));
                    if(popCharWeight != currentCharWeight) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } catch(Exception e) {
            return false;
        }

        if(stack.isEmpty()) {
            return true;
        }

        return false;

    }
}
