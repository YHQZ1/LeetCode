int findClosestNumber(int* nums, int numsSize) {
    int closest = nums[0];
    
    for (int i = 1; i < numsSize; i++) {
        if (abs(nums[i]) < abs(closest) || (abs(nums[i]) == abs(closest) && nums[i] > closest)) {
            closest = nums[i];
        }
    }
    
    return closest;
}