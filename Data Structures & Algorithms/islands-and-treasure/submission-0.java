class Solution {
    class Pair<A, B> {
        public final A first;
        public final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Pair<int[], Integer>> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 0) {
                    q.add(new Pair(new int[]{i,j}, 0));
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            Pair<int[], Integer> curr = q.poll();
            int i = curr.first[0];
            int j = curr.first[1];
            int dist = curr.second;
            grid[i][j] = dist;

            int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
            for(int[] dir : dirs) {
                int nr = i + dir[0];
                int nc = j + dir[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if(grid[nr][nc] == Integer.MAX_VALUE && !visited[nr][nc]) {
                        q.add(new Pair(new int[]{nr, nc}, dist+1));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
}
