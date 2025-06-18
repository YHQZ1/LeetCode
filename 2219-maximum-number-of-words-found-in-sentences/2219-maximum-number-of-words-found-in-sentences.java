class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(int i=0; i<sentences.length; i++){
            String[] l = sentences[i].split(" ");
            max = Math.max(max, l.length);
        }
        return max;
    }
}