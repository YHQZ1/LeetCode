int isUnique(char* s, int start, int end) {
    for (int i = start; i < end; i++) {
        if (s[i] == s[end]) {
            return 0;  
        }
    }
    return 1;  
}

int lengthOfLongestSubstring(char* s) {
    int size = strlen(s);
    int maxCount = 0;

    for (int i = 0; i < size; i++) {
        int count = 0;
        for (int j = i; j < size; j++) {
            if (!isUnique(s, i, j)) {
                break;
            }
            count++;
        }
        if (count > maxCount) {
            maxCount = count;
        }
    }
    return maxCount;
}
