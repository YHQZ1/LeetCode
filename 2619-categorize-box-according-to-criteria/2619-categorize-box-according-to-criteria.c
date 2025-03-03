const char* categorizeBox(int length, int width, int height, int mass) {
    long long volume = (long long)length * width * height;
    
    int isBulky = (length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000LL);
    int isHeavy = (mass >= 100);

    if (isBulky && isHeavy) {
        return "Both";
    } else if (!isBulky && !isHeavy) {
        return "Neither";
    } else if (isBulky) {
        return "Bulky";
    } else {
        return "Heavy";
    }
}
