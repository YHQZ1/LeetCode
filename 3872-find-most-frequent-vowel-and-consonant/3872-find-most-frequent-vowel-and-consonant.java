class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        char[] consonants = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};

        char maxVowel = ' ', maxConsonant = ' ';
        int vowel = -1, consonant = -1;

        for (char ch : vowels){
            int freq = map.getOrDefault(ch, 0);
            if(freq > vowel){
                vowel = freq;
                maxVowel = ch;
            }
        }

        for (char ch : consonants){
            int freq = map.getOrDefault(ch, 0);
            if(freq > consonant){
                consonant = freq;
                maxConsonant = ch;
            }
        }
        return vowel + consonant;
    }
}