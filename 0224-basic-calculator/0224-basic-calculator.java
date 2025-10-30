import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int result = 0;
        int curr = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                curr = curr * 10 + (ch - '0');
            } else if (ch == '+') {
                result = result + curr * sign;
                curr = 0;
                sign = 1;
            } else if (ch == '-') {
                result = result + curr * sign;
                curr = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result = result + curr * sign;
                curr = 0;
                result = result * stack.pop();
                result = result + stack.pop();
            }
        }
        return result + curr * sign;
    }
}
