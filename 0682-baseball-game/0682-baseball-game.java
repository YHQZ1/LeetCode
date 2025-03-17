import java.util.*;

class Solution {
    public int calPoints(String[] operations) {
        List<Integer> scores = new ArrayList<>();

        for (String op : operations) {
            int size = scores.size();

            if (op.equals("+")) {
                scores.add(scores.get(size - 1) + scores.get(size - 2));
            } else if (op.equals("D")) {
                scores.add(2 * scores.get(size - 1));
            } else if (op.equals("C")) {
                scores.remove(size - 1);
            } else {
                scores.add(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }
}
