class Solution {
    public int calculate(String s) {
        int result = 0;
        int curr = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c))
                curr = curr * 10 + (c - '0');
            else if (c == '+') {
                result = result + curr * sign;
                curr = 0;
                sign = 1;
            } else if (c == '-') {
                result = result + curr * sign;
                curr = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = result + curr * sign;
                curr = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        return result + curr * sign;
    }
}