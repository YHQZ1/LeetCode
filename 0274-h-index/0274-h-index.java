class Solution {
    public void sort(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    public int hIndex(int[] citations) {
        sort(citations);
        int h = 0;

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] < i + 1)
                break;
            h++;
        }
        return h;
    }
}