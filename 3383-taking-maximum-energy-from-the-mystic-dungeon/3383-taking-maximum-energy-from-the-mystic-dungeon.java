class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;

        for (int i = energy.length - 1; i >= 0; i--) {
            if (i + k < energy.length) {
                energy[i] = energy[i] + energy[i + k];
            }
            max = Math.max(max, energy[i]);
        }
        return max;
    }
}
