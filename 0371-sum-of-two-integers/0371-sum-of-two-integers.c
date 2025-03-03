int getSum(int a, int b) {
    while (b != 0) {
        int sum = a ^ b;
        unsigned int carry = ((unsigned int)a & (unsigned int)b) << 1;
        a = sum;
        b = (int)carry;
    }
    return a;
}
