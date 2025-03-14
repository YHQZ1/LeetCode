bool isMonotonic(int* nums, int numsSize) {
    if (numsSize <= 1) return true;

    bool increasing = true, decreasing = true;

    for (int i = 1; i < numsSize; i++) {
        if (nums[i] > nums[i - 1]) {
            decreasing = false;
        }
        if (nums[i] < nums[i - 1]) {
            increasing = false;
        }
    }

    return increasing || decreasing;
}
