int* addToArrayForm(int* num, int numSize, int k, int* returnSize) {
    int carry = k;
    int i = numSize - 1;
    int tempSize = numSize + 5; 
    int* result = (int*)malloc(tempSize * sizeof(int));
    int index = 0;

    while (i >= 0 || carry > 0) {
        if (i >= 0) {
            carry += num[i];
        }
        result[index++] = carry % 10;
        carry /= 10;
        i--;
    }

    
    for (int left = 0, right = index - 1; left < right; left++, right--) {
        int temp = result[left];
        result[left] = result[right];
        result[right] = temp;
    }

    *returnSize = index;
    return result;
}