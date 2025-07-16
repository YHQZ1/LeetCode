class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(int i=0; i<details.length; i++){
            char first = details[i].charAt(11);
            int f = first - '0';
            char second = details[i].charAt(12);
            int s = second - '0';
            int age = (f*10)+s;
            if(age > 60) count++;
        }
        return count;
    }
}