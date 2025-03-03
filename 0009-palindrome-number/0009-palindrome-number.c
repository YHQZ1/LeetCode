bool isPalindrome(int x) {
    long int rem;
    long int original=x;
    long int numRev=0;

    if(x<0){
        return false;
    }
    while(x!=0){

    rem=x%10;
    numRev=numRev*10+rem;
    x=x/10;

    }

    return original==numRev;
}