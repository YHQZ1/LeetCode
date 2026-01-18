import java.util.*;

class Solution {

    static class Machine {
        int cost;
        int capacity;

        Machine(int cost, int capacity) {
            this.cost = cost;
            this.capacity = capacity;
        }
    }

    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        Machine[] machines = new Machine[n];

        for (int i = 0; i < n; i++) {
            machines[i] = new Machine(costs[i], capacity[i]);
        }

        Arrays.sort(machines, Comparator.comparingInt(m -> m.cost));

        int[] prefixMax = new int[n];
        prefixMax[0] = machines[0].capacity;
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], machines[i].capacity);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (machines[i].cost < budget) {
                ans = Math.max(ans, machines[i].capacity);
            }
        }

        for (int i = 1; i < n; i++) {
            int remaining = budget - machines[i].cost;
            if (remaining <= 0) continue;

            int j = binarySearch(machines, remaining, i - 1);
            if (j != -1) {
                ans = Math.max(ans, machines[i].capacity + prefixMax[j]);
            }
        }

        return ans;
    }

    
    private int binarySearch(Machine[] machines, int target, int hi) {
        int lo = 0, res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (machines[mid].cost < target) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
}
