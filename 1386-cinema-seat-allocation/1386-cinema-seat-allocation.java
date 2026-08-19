class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int contributions = n * 2;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int column = reservedSeats[i][1];

            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(column);
        }

        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            HashSet<Integer> seats = entry.getValue();

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for (int seat : seats) {
                if (seat >= 2 && seat <= 5)
                    left = false;
                if (seat >= 4 && seat <= 7)
                    middle = false;
                if (seat >= 6 && seat <= 9)
                    right = false;
            }

            contributions -= 2;
            
            if (left & right)
                contributions += 2;
            else if (left || middle || right)
                contributions += 1;
        }
        return contributions;
    }
}