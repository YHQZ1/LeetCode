char* mergeAlternately(char *word1, char *word2) {
    int l1 = strlen(word1), l2 = strlen(word2);
    int length = l1 + l2;
    
    char *result = (char*)malloc((length + 1) * sizeof(char));
    if (!result) return NULL; 

    int i = 0, j = 0, k = 0;
    
    while (i < l1 || j < l2) {
        if (i < l1) result[k++] = word1[i++];
        if (j < l2) result[k++] = word2[j++];
    }

    result[k] = '\0';
    return result;
}
