class RandomizedSet {
    private final HashSet<Integer> set;
    private final Random rand;

    public RandomizedSet() {
        set = new HashSet<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        int index = rand.nextInt(set.size());
        Iterator<Integer> it = set.iterator();

        for (int i = 0; i < index; i++) {
            it.next();
        }
        return it.next();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */