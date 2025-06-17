class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean result = false;
        int i=0, j=0;
        while(i<s.length() && j<t.length()){
            if( s.charAt(i) == t.charAt(j) ){
                i++;
                j++;
            } else {
                j++;
            }
        }
        if(i == s.length()){
            result = true;
        }
        return result;
    }
}