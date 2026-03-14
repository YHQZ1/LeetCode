class Solution {

    List<String> happyStrings = new ArrayList<>();

    public String getHappyString(int n, int k) {
        String currentString = "";
        generateHappyStrings(n, currentString);

        if (happyStrings.size() < k)
            return "";

        return happyStrings.get(k - 1);
    }

    protected void generateHappyStrings(int n, String currentString) {
        if (currentString.length() == n) {
            happyStrings.add(currentString);
            return;
        }

        for (char currentChar = 'a'; currentChar <= 'c'; currentChar++) {
            if (currentString.length() > 0 &&
                    currentString.charAt(currentString.length() - 1) == currentChar)
                continue;

            generateHappyStrings(n, currentString + currentChar);
        }
    }
}