class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(visited, grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(boolean[][] visited, char[][] grid, int i, int j) {
        visited[i][j] = true;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int[] dir : dirs) {
            int newR = i + dir[0];
            int newC = j + dir[1];

            if(newR >= 0 && newR < n && newC >= 0 && newC < m) {
                if(!visited[newR][newC] && grid[newR][newC] == '1') {
                    dfs(visited, grid, newR, newC);
                }
            }
        }
    }
}
