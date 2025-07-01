class Solution {
    public int possibleStringCount(String word) {
        int count = 0;
        for(int i=0; i<word.length()-1; i++){
            char c1 = word.charAt(i);
            char c2 = word.charAt(i+1);
            if(c1 == c2){
                count++;
            }
        }
        return count+1;
    }
}