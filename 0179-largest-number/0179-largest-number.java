class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            String ab = a + b;
            String ba = b + a;

            return ba.compareTo(ab);
        });

        if (arr[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}