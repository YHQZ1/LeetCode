int smallestEvenMultiple(int n) {
    int result;
    if(n%2==0){
        result = n;
    } else {
        result = n*2;
    }
    return result;
}