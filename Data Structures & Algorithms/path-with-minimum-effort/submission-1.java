class Solution {
    class Pair {
        int x, y, eff;
        public Pair(int _x, int _y, int _eff) {
            x = _x;
            y = _y;
            eff = _eff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] effort = new int[n][m];

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                effort[i][j] = Integer.MAX_VALUE;
            }
        }
        effort[0][0] = heights[0][0];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.eff - b.eff);
        pq.add(new Pair(0,0, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int dist = curr.eff;

            if(x == n-1 && y == m-1) return dist;
            int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
            for(int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >= 0 && newY >= 0 && newX < n && newY < m) {
                    int newEffort = Math.max(dist, Math.abs(heights[newX][newY] - heights[x][y]));
                    if(effort[newX][newY] > newEffort) {
                        effort[newX][newY] = newEffort;
                        pq.add(new Pair(newX, newY, newEffort));
                    }
                }
            }
        }
        return -1;
    }
}