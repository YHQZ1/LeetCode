class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return List.of();

        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v' });
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });

        List<String> curr = new ArrayList<>();
        for (char c : map.get(digits.charAt(0))) {
            curr.add(String.valueOf(c));
        }

        for (int i = 1; i < digits.length(); i++) {
            char[] next = map.get(digits.charAt(i));
            curr = permutate(curr, next);
        }

        return curr;
    }

    private List<String> permutate(List<String> curr, char[] next) {
        List<String> result = new ArrayList<>();

        for (String prefix : curr) {
            for (char c : next) {
                result.add(prefix + c);
            }
        }
        return result;
    }
}
