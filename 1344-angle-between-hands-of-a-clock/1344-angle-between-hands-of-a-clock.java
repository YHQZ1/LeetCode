class Solution {
    public double angleClock(int hour, int minutes) {
        if (hour == 12)
            hour = 0;
            
        double m = (double) minutes / 60;
        double h = (double) hour + m;

        double mins = (double) minutes / 5;

        double res = Math.abs(mins - h);

        return 30 * Math.min(res, 12 - res);
    }
}
