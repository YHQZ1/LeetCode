int numberOfCuts(int n) {
    int result;
    if(n == 1){
        result = 0;
    } else if(n%2 == 0){
        result = n/2;
    } else if(n%2 == 1){
        result = n;
    }
    return result;
}