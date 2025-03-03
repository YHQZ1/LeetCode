int missingNumber(int* nums, int numsSize) {
    int sum=0;
    int count=0;
    for(int i=0; i<numsSize; i++){
        count=count+1;
        sum=sum+count;
    }

    int sumNumbers=0;
    for(int i=0; i<numsSize; i++){
        sumNumbers+=nums[i];
    }

    int missing;

    missing = sum - sumNumbers;

    return missing;

}