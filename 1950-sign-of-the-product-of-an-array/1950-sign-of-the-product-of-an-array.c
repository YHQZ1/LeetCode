int signFunc(int num) {
    if (num > 0) {
        return 1;
    } else if (num == 0) {
        return 0;
    } else {
        return -1;
    }
}

int arraySign(int* nums, int numsSize) {
    int negativeCount = 0;

    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == 0) {
            return 0;
        } else if (nums[i] < 0) {
            negativeCount++;
        }
    }
    return (negativeCount % 2 == 0) ? 1 : -1;
}
