class Solution {
    public String largestGoodInteger(String num) {
        int i = 0;
        String max = "";
        while (i < num.length() - 2) {
            if (num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)) {
                String curr = num.substring(i, i+3);
                if (max.equals("") || curr.compareTo(max) > 0) {
                    max = curr;
                }
            }
            i++;
        }
        return max;
    }
}
