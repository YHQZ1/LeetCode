class Solution {
    public int maxPower(String s) {
        int count = 1;
        int max = 1;
        if(s.length() == 0 || s == null) return 0;
        
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)) count++;
            else{
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }
}