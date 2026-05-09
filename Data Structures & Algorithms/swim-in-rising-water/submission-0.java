class Solution {
    class Pair {
        int x, y, dist;
        public Pair(int _x, int _y, int d) {
            x = _x;
            y = _y;
            dist = d;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = grid[0][0];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.add(new Pair(0,0, grid[0][0]));
        
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int w = curr.dist;

            if(x == n-1 && y == m-1) return w;

            if(dist[x][y] < w) continue;
            int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
            for(int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    int newEffort = Math.max(w, grid[newX][newY]);

                    if(newEffort < dist[newX][newY]) {
                        dist[newX][newY] = newEffort;
                        pq.add(new Pair(newX, newY, newEffort));
                    }
                }
            }
        }
        return -1;
    }
}
