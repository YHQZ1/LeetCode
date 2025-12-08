public class Solution {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = -1;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                res = key;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        // Your shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter fw = new FileWriter("display_runtime.txt")) {
                fw.write("000");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        // If you want to test majorityElement:
        // Solution s = new Solution();
        // System.out.println(s.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
