int alternateDigitSum(int n) {
    int temp = n, size = 0, sum = 0;
    while (temp != 0) {
        temp /= 10;
        size++;
    }
    int arr[size];
    temp = n;
    for (int i = size - 1; i >= 0; i--) {
        arr[i] = temp % 10;
        temp /= 10;
    }
    for (int i = 0; i < size; i++) {
        if (i % 2 == 0)
            sum += arr[i];
        else
            sum -= arr[i];
    }
    return sum;
}
