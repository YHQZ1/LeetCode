char findTheDifference(char* s, char* t) {
    int sum1 = 0, sum2 = 0;
    for(int i=0; s[i]!='\0'; i++){
        sum1 = sum1+(int)s[i];
    }

    for(int i=0; t[i]!='\0'; i++){
        sum2 = sum2+(int)t[i];
    }

    int result = abs(sum1 - sum2);

    return (char)result;
}