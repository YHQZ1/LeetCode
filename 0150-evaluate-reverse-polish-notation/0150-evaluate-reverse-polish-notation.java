class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if (tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if (tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                int curr = Integer.parseInt(tokens[i]);
                stack.push(curr);
            }
        }
        return stack.peek();
    }
}