bool isOneBitCharacter(int* bits, int bitsSize) {
    int i = 0;
    while (i < bitsSize - 1) {
        if (bits[i] == 1) {
            i += 2;
        } else {
            i++;
        }
    }
    return i == bitsSize - 1;
}
