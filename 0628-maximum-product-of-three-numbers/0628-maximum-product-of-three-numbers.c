int cmp(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

int maximumProduct(int* nums, int numsSize) {
    qsort(nums, numsSize, sizeof(int), cmp);

    int case1 = nums[numsSize - 1] * nums[numsSize - 2] * nums[numsSize - 3];  // Top 3 largest numbers
    int case2 = nums[0] * nums[1] * nums[numsSize - 1];  // Two smallest numbers (negative) * largest

    return (case1 > case2) ? case1 : case2;
}