bool divideArray(int* nums, int numsSize) {
    int freq[501] = {0};

    for (int i = 0; i < numsSize; i++) {
        freq[nums[i]]++;
    }

    for (int i = 0; i < 501; i++) {
        if (freq[i] % 2 != 0) {
            return false;  
        }
    }

    return true;  
}