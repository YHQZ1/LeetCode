class Solution {
    public boolean isTriangle(int a, int b, int c){
        if(a+b > c && a+c > b && b+c > a) return true;
        return false;
    }

    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=2; i--){
            int j=0, k=i-1;
            while(j<k){
                if(isTriangle(nums[i], nums[j], nums[k])){
                    count = count + (k-j);
                    k--;
                } else j++;
            }
        }
        return count;
    }
}