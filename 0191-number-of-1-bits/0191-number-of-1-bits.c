int hammingWeight(int num) {
    int count = 0;

    while (num > 0) {
        if (num % 2 == 1) { 
            count++;
        }
        num = num / 2; 
    }

    return count;
}
