class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        int profit;

        for(int i=1; i<prices.length; i++){
            if(prices[i]<min){
                min = prices[i];
            } else {
                profit = prices[i] - min;
                
                if(profit>max){
                max = profit;
                }
            }
        }
        return max;
    }
}