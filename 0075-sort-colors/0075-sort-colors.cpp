class Solution {
public:
    void sortColors(vector<int>& nums) {
    int zeros=0;
    int ones=0;
    int twos=0;
    int numSize=nums.size();

    for(int i=0; i<numSize; i++){
        if(nums[i]==0){
            zeros++;
        } else if (nums[i]==1){
            ones++;
        } else if (nums[i]==2){
            twos++;
        }
    }

    for(int i=0; i<zeros; i++){
        nums[i]=0;
    }

    for(int i=zeros; i<zeros+ones; i++){
        nums[i]=1;
    }

    for(int i=zeros+ones; i<zeros+ones+twos; i++){
        nums[i]=2;
    }
    }
};