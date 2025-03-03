int sum(int num) {
    int sum = 0;
    while (num != 0) {
        int rem = num % 10;
        sum = sum + rem;
        num = num / 10;
    }
    return sum;
}

int addDigits(int num) {
    while (num >= 10) {
        num = sum(num);
    }
    return num;
}
