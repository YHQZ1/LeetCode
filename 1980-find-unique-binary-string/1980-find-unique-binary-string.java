class Solution {
    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        int total = 1 << n;

        for (int i = 0; i < total; i++) {
            String binary = String.format("%" + n + "s", Integer.toBinaryString(i))
                    .replace(' ', '0');
            result.add(binary);
        }

        return result;
    }

    public String findDifferentBinaryString(String[] nums) {
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        int n = nums[0].length();
        list = generateBinary(n);

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            if (!set.contains(list.get(i)))
                return list.get(i);
        }
        return "";
    }
}