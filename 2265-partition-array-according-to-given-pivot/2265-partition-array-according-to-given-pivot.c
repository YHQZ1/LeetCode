int* pivotArray(int* nums, int numsSize, int pivot, int* returnSize) {
    int* result = (int*)malloc(numsSize * sizeof(int));
    if (!result) return NULL;

    int left = 0, right = numsSize - 1;
    int i, k = 0;

    for (i = 0; i < numsSize; i++) {
        if (nums[i] < pivot)
            result[k++] = nums[i];
    }

    for (i = 0; i < numsSize; i++) {
        if (nums[i] == pivot)
            result[k++] = nums[i];
    }

    for (i = 0; i < numsSize; i++) {
        if (nums[i] > pivot)
            result[k++] = nums[i];
    }

    *returnSize = numsSize;
    return result; 
}
