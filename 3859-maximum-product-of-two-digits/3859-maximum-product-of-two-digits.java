class Solution {
    public int maxProduct(int n) {
        int size = (int) Math.log10(n) + 1;
        int[] arr = new int[size];
        for(int i=0; i<arr.length; i++){
            int rem = n%10;
            arr[i] = rem;
            n=n/10;
        }

        Arrays.sort(arr);

        int max = arr[arr.length-1]*arr[arr.length-2];

        return max;
    }
}