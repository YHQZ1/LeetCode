class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        char[] roman = s.toCharArray();

        int sum = 0;

        sum = sum + map.get(roman[roman.length-1]);
        for(int i=roman.length-2; i>=0; i--){
            int curr = map.get(roman[i]);
            int next = map.get(roman[i+1]);
            if(curr < next){
                sum = sum - curr;
            } else{
                sum = sum + curr;
            }
        }
        return sum;
    }
}