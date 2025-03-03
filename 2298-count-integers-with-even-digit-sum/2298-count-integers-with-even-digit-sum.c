int checkEven(int x){
    int rem, sum=0;
    while(x>0){
        rem = x%10;
        sum=sum+rem;
        x=x/10;
    }
   return (sum%2==0);
}

int countEven(int num) {
    int count=0;
    for(int i=1; i<=num; i++){
        if(checkEven(i)){
            count++;
        }
    }
    return count;
}