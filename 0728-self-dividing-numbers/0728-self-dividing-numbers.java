class Solution {
    public boolean selfdiv(int num){
        int n = num;
        while(num>0){
            int rem = num%10;
            if(rem == 0){
                return false;
            }
            if(n%rem == 0){
                num = num/10;
            } else {
                return false;
            }
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i=left; i<=right; i++){
            if(selfdiv(i)){
                list.add(i);
            }
        }
        return list;
    }
}