int* runningSum(int* nums, int numsSize, int* returnSize) {
    *returnSize = numsSize; 

    int* result = (int*)malloc(numsSize * sizeof(int)); 
    if (!result) return NULL; 

    result[0] = nums[0]; 

    for (int i = 1; i < numsSize; i++) {
        result[i] = result[i - 1] + nums[i];  
    }

    return result;
}