int sumOfUnique(int* nums, int numsSize) {
    int sum = 0;

    for (int i = 0; i < numsSize; i++) {
        int count = 0;

        for (int j = 0; j < numsSize; j++) {
            if (nums[i] == nums[j]) {
                count++;
                }
            }

            if (count == 1) {
            sum += nums[i];
            }
        }
    return sum;
}
