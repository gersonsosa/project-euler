package com.gersonsosa.projecteuler;

import java.util.Stack;

public class Brackets {

    public boolean isBalanced(String expression) {
       Stack<Character> openBrackets = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (current == '{' || current == '[' || current == '(' ) {
                openBrackets.push(current);
            }else if (current == '}' || current == ']' || current == ')' ) {
                if (openBrackets.isEmpty() || !matches(openBrackets.pop(), current)){
                    return false;
                }
            }
        }
        return openBrackets.empty();
    }

    private boolean matches(char pop, char current) {
        return (pop == '{' && current == '}') || (pop == '[' && current == ']') || pop == '(' && current == ')';
    }
}
