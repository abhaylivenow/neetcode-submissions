class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] table = new int[amount+1];
        Arrays.fill(table, amount+1);
        table[0] = 0;

        for(int i = 0 ; i <= amount ; i++) {
            for(int coin : coins) {
                long next = (long)i + coin;
                if(next <= amount) {
                    int nextIndex = (int)next;
                    table[nextIndex] = Math.min(table[nextIndex], table[i] + 1);
                }
            }
        }

        if(table[amount] == amount+1) {
            return -1;
        } else {
            return table[amount];
        }
    }
}
