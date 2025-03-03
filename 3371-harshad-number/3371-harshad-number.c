int sumOfTheDigitsOfHarshadNumber(int x) {
    int num=x, rem, sum=0;
    while(num>0){
        rem=num%10;
        sum+=rem;
        num/=10;
    }
    if(x%sum==0){
        return sum;
    } else {
        return -1;
    }
}