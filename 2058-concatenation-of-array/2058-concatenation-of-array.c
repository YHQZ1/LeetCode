int* getConcatenation(int* nums, int numsSize, int* returnSize) {
    *returnSize = numsSize * 2; 

    int* ans = (int*)malloc((*returnSize) * sizeof(int)); 
    if (!ans) return NULL;

    for (int i = 0; i < *returnSize; i++) {
        ans[i] = nums[i % numsSize]; 
    }

    return ans;
}