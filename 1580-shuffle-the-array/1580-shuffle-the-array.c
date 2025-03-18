int* shuffle(int* nums, int numsSize, int n, int* returnSize) {
    *returnSize = numsSize; 
    int* arr = (int*)malloc(numsSize * sizeof(int));
    if (!arr) return NULL;

    for (int i = 0; i < n; i++) {
        arr[2 * i] = nums[i];  
        arr[2 * i + 1] = nums[i + n]; 
    }

    return arr;
}