class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        
        boolean[][] visitedP = new boolean[n][m];
        boolean[][] visitedA = new boolean[n][m];

        Queue<int[]> qP = new LinkedList<>();
        Queue<int[]> qA = new LinkedList<>();

        for(int i = 0 ; i < n ; i++) {
            bfs(heights, visitedP, qP);
            qP.add(new int[]{i,0});
            visitedP[i][0] = true;
        }
        for(int i = 0 ; i < m ; i++) {
            bfs(heights, visitedP, qP);
            qP.add(new int[]{0,i});
            visitedP[0][i] = true;
        }
        for(int i = 0 ; i < n ; i++) {
            bfs(heights, visitedA, qA);
            qA.add(new int[]{i,m-1});
            visitedA[i][m-1] = true;
        }
        for(int i = 0 ; i < m ; i++) {
            bfs(heights, visitedA, qA);
            qA.add(new int[]{n-1,i});
            visitedA[n-1][i] = true;
        }

        for(int i = 0 ; i < n ;i++) {
            for(int j = 0 ;j < m ; j++) {
                if(visitedP[i][j] && visitedA[i][j]) {
                    List<Integer> mini = new ArrayList<>();
                    mini.add(i);
                    mini.add(j);
                    ans.add(mini);
                }
            }
        }

        return ans;
    }

    public void bfs (int[][] heights, boolean[][] visited, Queue<int[]> q) {
        int n = heights.length;
        int m = heights[0].length;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
            for(int[] dir : dirs) {
                int nX = x + dir[0];
                int nY = y + dir[1];

                if(nX >= 0 && nX < n && nY >= 0 && nY < m) {
                    if(!visited[nX][nY] && heights[nX][nY] >= heights[x][y]) {
                        q.add(new int[]{nX, nY});
                        visited[nX][nY] = true;
                    }
                }
            }
        }
    }
}
