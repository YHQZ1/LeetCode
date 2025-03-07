
int* findMissingAndRepeatedValues(int** grid, int gridSize, int* gridColSize, int* returnSize) {
    int n = gridSize; 
    int total = n * n;
    
    int* count = (int*)calloc(total + 1, sizeof(int));
    
    int repeated = -1, missing = -1;
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            count[grid[i][j]]++;
        }
    }
    
    for (int i = 1; i <= total; i++) {
        if (count[i] == 2) {
            repeated = i;
        } else if (count[i] == 0) {
            missing = i;
        }
    }
    
    free(count); 

    *returnSize = 2;
    int* result = (int*)malloc(2 * sizeof(int));
    result[0] = repeated;
    result[1] = missing;
    return result;
}