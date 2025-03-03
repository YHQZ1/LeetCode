#define INT_MAX 2147483647
#define INT_MIN -2147483648

int reverse(int x) {
    long long int digit;
    long long int reversed = 0;

    while (x != 0) {
        digit = x % 10;
        x = x / 10;

        if (reversed > (INT_MAX - digit) / 10 || reversed < (INT_MIN - digit) / 10) {
            return 0;
        }

        reversed = reversed * 10 + digit;
    }

    return reversed;
}
