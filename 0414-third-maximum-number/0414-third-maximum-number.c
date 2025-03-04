int thirdMax(int* nums, int numsSize) {
    long first = LONG_MIN, second = LONG_MIN, third = LONG_MIN;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == first || nums[i] == second || nums[i] == third) {
            continue; 
        }
        if (nums[i] > first) {
            third = second;
            second = first;
            first = nums[i];
        } else if (nums[i] > second) {
            third = second;
            second = nums[i];
        } else if (nums[i] > third) {
            third = nums[i];
        }
    }

    return (third == LONG_MIN) ? first : third;
}
