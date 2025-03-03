int subtractProductAndSum(int n) {
    int rem, prod=1, sum=0, diff;
    while(n>0){
        rem=n%10;
        sum=sum+rem;
        prod=prod*rem;
        n=n/10;
    }
    diff=prod-sum;

    return diff;
}