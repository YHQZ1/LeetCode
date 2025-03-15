
int strStr(char* haystack, char* needle) {
    if (*needle == '\0') return 0; 
    
    int haystack_len = strlen(haystack);
    int needle_len = strlen(needle);

    for (int i = 0; i <= haystack_len - needle_len; i++) {
        int j;
        for (j = 0; j < needle_len; j++) {
            if (haystack[i + j] != needle[j]) {
                break;
            }
        }
        if (j == needle_len) {
            return i;
        }
    }
    return -1; 
}
