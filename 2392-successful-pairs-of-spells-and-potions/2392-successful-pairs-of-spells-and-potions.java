import java.util.*;

class Solution {
    public int binarySearch(int[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            long first = (success + spells[i] - 1L) / spells[i];
            int j = binarySearch(potions, first);
            res[i] = m - j;
        }

        return res;
    }
}
