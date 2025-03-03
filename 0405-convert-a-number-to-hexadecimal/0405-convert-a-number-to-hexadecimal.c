char* toHex(int num) {
    if (num == 0) {
        return "0"; 
    }

    static char hex[9]; 
    unsigned int n = (unsigned int) num;
    int i = 0;

    while (n > 0) {
        int rem = n % 16;
        hex[i++] = (rem < 10) ? (rem + '0') : (rem - 10 + 'a');
        n /= 16;
    }
    hex[i] = '\0';

    for (int j = 0, k = i - 1; j < k; j++, k--) {
        char temp = hex[j];
        hex[j] = hex[k];
        hex[k] = temp;
    }

    return hex;
}