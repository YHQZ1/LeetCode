class Solution {
    public void reverseString(char[] s) {
        int i = 0, size = s.length;
        while(i < size/2){
            char temp = s[i];
            s[i] = s[size-i-1];
            s[size-i-1] = temp;
            i++;
        }
    }
}