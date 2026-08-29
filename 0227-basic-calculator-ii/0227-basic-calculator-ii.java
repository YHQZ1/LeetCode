class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (Character.isDigit(curr)) {
                num = num * 10 + (curr - '0');
            }

            if ((!Character.isDigit(curr) && curr != ' ') || i == s.length() - 1) {

                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = curr;
                num = 0;
            }
        }

        int result = 0;

        for (int value : stack) {
            result += value;
        }

        return result;
    }
}