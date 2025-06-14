class Solution {

    final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String helper(int n){
        if(n == 0) return "";
        else if(n < 20) return LESS_THAN_20[n] + " ";
        else if(n < 100) return TENS[n/10] + " " + helper(n%10);
        else return LESS_THAN_20[n/100] + " Hundred " + helper(n%100); 
    }

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        String result = "";
        int i = 0;

        while(num > 0){
            if(num%1000 != 0){
                result = helper(num%1000) + THOUSANDS[i] + " " + result;
            }
            num = num/1000;
            i++;
        }
        return result.trim();
    }
}