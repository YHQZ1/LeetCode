class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();

        for(int i=0; i<numRows; i++){
            List<Integer> row = new ArrayList<>();

            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    row.add(1);
                } else {
                    int value = dp.get(i-1).get(j-1) + dp.get(i-1).get(j);
                    row.add(value);
                }
            }
            dp.add(row);
        }
        return dp;
    }
}