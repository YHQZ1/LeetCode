class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(Character.isLetterOrDigit(curr)){
                sb.append(curr);
            }
        }

        String updated = sb.toString().toLowerCase();
        sb = new StringBuilder(updated);

        return sb.toString().equals(sb.reverse().toString());
    }
}