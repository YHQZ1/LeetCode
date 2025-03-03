int reverse(int x) {
    int rem, rev = 0;
    while (x != 0) {
        rem = x % 10;
        rev = (rev * 10) + rem;
        x = x / 10;
    }
    return rev;
}

bool isSameAfterReversals(int num) {
    int a = reverse(num);
    int b = reverse(a);

    return num == b;  // Directly return the comparison result
}
