int fib(int n){
    if(n == 0) return 0;
    int first = 0, second = 1, third;
    for(int i = 2; i <= n; i++){
        third = first + second;
        first = second;
        second = third;
    }
    return second;
}