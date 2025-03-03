int differenceOfSum(int* nums, int numsSize) {
    int sum=0;
    for(int i=0; i<numsSize; i++){
        sum+=nums[i];
    }    
    
    int rem, sum1 = 0, sum2 = 0;
    for(int i=0; i<numsSize; i++){
        while(nums[i]>0){
            rem = nums[i]%10;
            sum1 = sum1 + rem;
            nums[i] = nums[i]/10;
        }
    }
    return sum-sum1;
}