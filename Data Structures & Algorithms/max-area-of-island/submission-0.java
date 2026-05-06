class Solution {
    class Pair<A, B> {
        public final A first;
        public final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
    
        int max = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    max = Math.max(dfs(visited, grid, i, j), max);
                }
            }
        }
        return max;
    }

    public int dfs(boolean[][] visited, int[][] grid, int i, int j) {
        int count = 1;
        int n = grid.length;
        int m = grid[0].length;

        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                if(!visited[nr][nc] && grid[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    count += dfs(visited, grid, nr, nc);
                }
            }
        }
        return count;
    }
}
