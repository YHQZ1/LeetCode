class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> T = new HashMap<>();
        HashMap<Character, Integer> S = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char insert = s.charAt(i);
            if(S.containsKey(insert)){
                S.put(insert, S.get(insert) + 1);
            } else {
                S.put(insert, 1);
            }
        }

        for(int i=0; i<t.length(); i++){
            char insert = t.charAt(i);
            if(T.containsKey(insert)){
                T.put(insert, T.get(insert) + 1);
            } else {
                T.put(insert, 1);
            }
        }

        return S.equals(T);
    }
}