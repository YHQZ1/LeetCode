class Solution {
    public int findRotateSteps(String ring, String key) {
        int count = 0;
        int j = 0;
        int i = 0;

        while(i < ring.length() && j<key.length()){
            if(ring.charAt(i) == key.charAt(j)){
                count++;
                j++;
            }
            count++;
            i++;
        }
        return count-1;
    }
}