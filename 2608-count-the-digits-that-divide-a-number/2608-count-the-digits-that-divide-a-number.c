int countDigits(int num) {
    int count=0, n=num;
    while(num!=0){
        int rem = num%10;
        if(n%rem == 0){
            count++;
        }
        num=num/10;
    }
    return count;
}