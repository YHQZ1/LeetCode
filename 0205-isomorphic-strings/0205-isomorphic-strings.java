class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();

        if(s.length() != t.length()) return false;

        for(int i=0;i<s.length();i++){
            char s1=s.charAt(i);
            char s2=t.charAt(i);
            if(map.containsKey(s1)){
                if(map.get(s1)!=s2) return false;
            }
            else if(map.containsValue(s2)) return false;
            map.put(s1,s2);
        }
        return true;
    }
}