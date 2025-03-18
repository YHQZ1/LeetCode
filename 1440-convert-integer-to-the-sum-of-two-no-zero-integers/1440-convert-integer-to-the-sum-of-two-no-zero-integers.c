int containsZero(int num) {
    while (num > 0) {
        if (num % 10 == 0) return 1; 
        num /= 10;
    }
    return 0; 
}

int* getNoZeroIntegers(int n, int* returnSize) {
    int* arr = (int*)malloc(2 * sizeof(int)); 

    for (int i = 1; i < n; i++) {
        int j = n - i;
        if (!containsZero(i) && !containsZero(j)) {
            arr[0] = i;
            arr[1] = j;
            *returnSize = 2;  
            return arr;
        }
    }
    return NULL; 
}