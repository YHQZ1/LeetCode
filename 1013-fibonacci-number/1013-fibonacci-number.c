int fib(int n){
    int result;
    if (n==0)
    return 0;
    if (n==1)
    return 1;
    else
    result=fib(n-1)+fib(n-2);
    return result;

}