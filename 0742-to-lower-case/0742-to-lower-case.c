char* toLowerCase(char* s) {
    int asciiValue;
    
    for(int i=0; s[i]!='\0'; i++){
        asciiValue = (int)s[i];
        if(asciiValue >= 65 && asciiValue <= 90){
            asciiValue = asciiValue+32;
            s[i] = (char)asciiValue;
        }
    }
    return s;
}