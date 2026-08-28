class Solution {
    public boolean isNumber(String s) {
        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean exponentSeen = false;
        boolean digitAfterExponent = true;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (Character.isDigit(curr)) {
                digitSeen = true;

                if (exponentSeen)
                    digitAfterExponent = true;

            } else if (curr == 'e' || curr == 'E') {
                if (!digitSeen || exponentSeen)
                    return false;

                exponentSeen = true;
                digitAfterExponent = false;

            } else if (curr == '.') {
                if (dotSeen || exponentSeen)
                    return false;

                dotSeen = true;

            } else if (curr == '+' || curr == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;

            } else {
                return false;
            }
        }

        return digitSeen && digitAfterExponent;
    }
}