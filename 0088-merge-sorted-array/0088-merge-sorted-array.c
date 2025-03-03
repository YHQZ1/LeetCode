void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n) {
    for (int i = 0; i < n; i++) {
        nums1[m + i] = nums2[i];
    }

    for (int i = 0; i < nums1Size; i++) {
        for (int j = i + 1; j < nums1Size; j++) {
            if (nums1[i] > nums1[j]) {
                int temp = nums1[i];
                nums1[i] = nums1[j];
                nums1[j] = temp;
            }
        }
    }
}
