int* findWordsContaining(char** words, int wordsSize, char x, int* returnSize) {
    int count = 0;

    for (int i = 0; i < wordsSize; i++) {
        int j = 0;
        while (words[i][j] != '\0') {
            if (words[i][j] == x) {
                count++;
                break;  
            }
            j++;
        }
    }

    int* result = (int*)malloc(count * sizeof(int));
    if (result == NULL) {
        *returnSize = 0;
        return NULL;
    }

    int index = 0;
    
    for (int i = 0; i < wordsSize; i++) {
        int j = 0;
        while (words[i][j] != '\0') {
            if (words[i][j] == x) {
                result[index++] = i;
                break;
            }
            j++;
        }
    }

    *returnSize = count; 
    return result; 
}