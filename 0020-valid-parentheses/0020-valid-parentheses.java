class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char curr : s.toCharArray()) {
            if (curr == '(') {
                stack.push(')');
            } else if (curr == '[') {
                stack.push(']');
            } else if (curr == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || curr != stack.peek()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}