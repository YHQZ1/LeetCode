int maximum69Number(int num) {
    int n = num;
    int arr[10], count = 0;  

    while (n > 0) {
        arr[count++] = n % 10;
        n /= 10;
    }

    for (int i = count - 1; i >= 0; i--) {
        if (arr[i] == 6) {
            arr[i] = 9; 
            break;
        }
    }

    int result = 0;
    for (int i = count - 1; i >= 0; i--) {
        result = result * 10 + arr[i];
    }

    return result;
}
