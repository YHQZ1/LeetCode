int sumOfSquares(int number) {
    int rem, sum = 0;

    while (number > 0) {
        rem = number % 10;
        sum += rem * rem;
        number /= 10;
    }

    return sum;
}

bool isHappy(int n) {
    int slow, fast;
    slow = fast = n;

    do {
        slow = sumOfSquares(slow);              
        fast = sumOfSquares(sumOfSquares(fast));
    } while (slow != fast);

    return (slow == 1);
}