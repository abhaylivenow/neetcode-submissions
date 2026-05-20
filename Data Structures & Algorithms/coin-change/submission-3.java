class Solution {
    public int coinChange(int[] coins, int amount) {
        List<List<Integer>> table = new ArrayList<>();
        for(int i = 0 ; i <= amount; i++) {
            table.add(null);
        }
        table.set(0, new ArrayList<>());

        for(int i = 0 ; i <= amount; i++) {
            if(table.get(i) != null) {
                for(int coin : coins) {
                    long next = (long)i+coin;
                    if(next <= amount) {
                        int nextIndex = (int)next;
                        List<Integer> combination = new ArrayList(table.get(i));
                        combination.add(coin);
                        if(table.get(nextIndex) == null || table.get(nextIndex).size() > combination.size()) {
                            table.set(nextIndex, combination);
                        }
                    }
                }
            }
        }
        return table.get(amount) == null
                ? -1
                : table.get(amount).size();
    }
}
