int maximumCount(int* nums, int numsSize) {
    int countneg = 0, countpos = 0, result;
    for(int i=0; i<numsSize; i++){
        if(nums[i]>0){
            countpos++;
        } else if(nums[i]<0){
            countneg++;
        }
    }
    if(countpos>countneg){
        result = countpos;
    } else {
        result = countneg;
    }
    return result;
}