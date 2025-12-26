class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        char[] chars = pattern.toCharArray();

        if(words.length != chars.length) return false;

        HashMap<Character, String> ps = new HashMap<>();
        HashMap<String, Character> sp = new HashMap<>();

        for(int i=0; i<chars.length; i++){
            char ch = chars[i];
            String str = words[i];

            if(ps.containsKey(ch)){
                if(!ps.get(ch).equals(str)) return false;
            } else {
                ps.put(ch, str);
            }

            if(sp.containsKey(str)){
                if(sp.get(str) != ch) return false;
            } else {
                sp.put(str, ch);
            }
        }
        return true;
    }
}