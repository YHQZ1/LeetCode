class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> string = new Stack<>();

        int num = 0;
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (Character.isDigit(curr)) {
                num = num * 10 + (curr - '0');
            } else if (curr == '[') {
                count.push(num);
                string.push(current.toString());

                num = 0;
                current = new StringBuilder();
            } else if (curr == ']') {
                int repeat = count.pop();
                String previous = string.pop();

                StringBuilder temp = new StringBuilder(previous);

                for (int j = 0; j < repeat; j++) {
                    temp.append(current);
                }
                
                current = temp;
            } else {
                current.append(curr);
            }
        }
        return current.toString();
    }
}