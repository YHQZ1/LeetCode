int singleNumber(int* nums, int numsSize) {
    for (int i = 0; i < numsSize; i++) {
        int target = nums[i];
        int count = 0;
        for (int j = 0; j < numsSize; j++) {
            if (target == nums[j]) {
                count++;
            }
        }
        if (count == 1) {
            return target;
        }
    }
    return 0;
}
