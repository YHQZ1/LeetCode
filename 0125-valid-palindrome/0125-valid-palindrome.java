class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}