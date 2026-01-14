class Solution {
    public String getLine(List<String> words, int count, int maxWidth) {
        if (words.size() == 0)
            return "";
        if (words.size() == 1)
            return words.get(0) + " ".repeat(maxWidth - words.get(0).length());
        int extraSpaces = (maxWidth - count) / (words.size() - 1);
        int remSpaces = (maxWidth - count) % (words.size() - 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.size() - 1; i++) {
            sb.append(words.get(i)).append(" ");
            sb.append(" ".repeat(extraSpaces));
            if (remSpaces-- > 0)
                sb.append(" ");
        }
        sb.append(words.getLast());
        return sb.toString();
    }

    public String getLastLine(List<String> words, int maxWidth) {
        String wordsStr = String.join(" ", words);
        return wordsStr.toString() + " ".repeat(maxWidth - wordsStr.length());
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int count = 0;
        List<String> currLine = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for (String w : words) {
            if (count == 0) {
                count = count + w.length();
                currLine.add(w);
            } else if (count + 1 + w.length() > maxWidth) {
                result.add(getLine(currLine, count, maxWidth));
                currLine = new ArrayList<>(List.of(w));
                count = w.length();
            } else {
                count = count + 1 + w.length();
                currLine.add(w);
            }
        }
        result.add(getLastLine(currLine, maxWidth));
        return result;
    }
}