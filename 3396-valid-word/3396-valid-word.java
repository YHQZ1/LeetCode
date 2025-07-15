class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;

        int number = 0, vowel = 0, consonant = 0;

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 
                                       'A', 'E', 'I', 'O', 'U');
        Set<Character> consonants = Set.of(
            'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k',
            'l', 'm', 'n', 'p', 'q', 'r', 's', 't',
            'v', 'w', 'x', 'y', 'z',
            'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K',
            'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T',
            'V', 'W', 'X', 'Y', 'Z'
        );
        Set<Character> numbers = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (vowels.contains(c)) vowel = 1;
            else if (consonants.contains(c)) consonant = 1;
            else if (numbers.contains(c)) number = 1;
            else return false;
        }

        return vowel == 1 && consonant == 1;
    }
}


//vowel-min 1
//consonant-min 1
//length>=3
//word = numbers+alphabets

/*
a,e,i,o,u - encounter -> vowel flag - 1 else 0
consonants - encounter -> consonant flag = 1 else 0
numbers - enocunter -> number flag = 1 else 0
*/