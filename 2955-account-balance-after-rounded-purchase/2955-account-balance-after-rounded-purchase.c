int roundoff(int num) {
    if (num % 10 >= 5) {
        return ((num / 10) + 1) * 10; 
    } else {
        return (num / 10) * 10;
    }
}

int accountBalanceAfterPurchase(int purchaseAmount) {
    int roundedAmount = roundoff(purchaseAmount);
    return 100 - roundedAmount;
}
