class Solution {
    public void getPerms(char[] chars, int idx, List<String> result) {
        if (idx == chars.length) {
            result.add(new String(chars));
            return;
        }

        for (int i = idx; i < chars.length; i++) {
            swap(chars, i, idx);
            getPerms(chars, idx + 1, result);
            swap(chars, i, idx);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public String getPermutation(int n, int k) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++)
            sb.append(i);

        char[] chars = sb.toString().toCharArray();
        getPerms(chars, 0, result);

        Collections.sort(result);
        return result.get(k - 1);
    }

}