class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(int i=0; i<operations.length; i++){
            String operator = operations[i];
            if(operator.equals("++X") || operator.equals("X++")) x++;
            else x--;
        }
        return x;
    }
}