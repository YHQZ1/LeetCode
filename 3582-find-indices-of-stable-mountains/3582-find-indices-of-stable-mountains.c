#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* stableMountains(int* height, int heightSize, int threshold, int* returnSize) {
    int index = 0;  
    int* result = (int*)malloc(heightSize * sizeof(int)); 

    if (result == NULL) {
        *returnSize = 0; 
        return NULL;
    }

    for (int i = 1; i < heightSize; i++) {
        if (height[i - 1] > threshold) {
            result[index++] = i;
        }
    }

    *returnSize = index; 
    return result;
}
