int reduce(int n){
    int count=0;
    while(n>0){
        n=n/10;
        count++;
    }
    return count;
}

int findNumbers(int* nums, int numsSize) {
    int count = 0, count2 = 0;
    for(int i=0; i<numsSize; i++){
        count = reduce(nums[i]);
        if(count%2 == 0){
            count2++;
        }
    }
    return count2;
}