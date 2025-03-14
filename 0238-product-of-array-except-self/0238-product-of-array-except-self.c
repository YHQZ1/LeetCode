#include <stdlib.h>

int* productExceptSelf(int* nums, int numsSize, int* returnSize) {
    *returnSize = numsSize;
    int* result = (int*)malloc(numsSize * sizeof(int));
    if (!result) return NULL; 

    result[0] = 1;
    for (int i = 1; i < numsSize; i++) {
        result[i] = result[i - 1] * nums[i - 1];
    }

    int right = 1;
    for (int i = numsSize - 1; i >= 0; i--) {
        result[i] *= right;
        right *= nums[i];
    }

    return result;
}
