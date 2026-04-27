class NumMatrix {
    int[][] _matrix;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        _matrix = new int[n+1][m+1];

        for(int i = 1 ; i < n+1 ; i++) {
            for(int j = 1 ; j < m+1 ; j++) {
                _matrix[i][j] = _matrix[i-1][j] + _matrix[i][j-1] - _matrix[i-1][j-1] + matrix[i-1][j-1];
            } 
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1 = row1+1;
        col1 = col1+1;
        row2 = row2+1;
        col2 = col2+1;

        int ans = _matrix[row2][col2] - _matrix[row1-1][col2] - _matrix[row2][col1-1] + _matrix[row1-1][col1-1];
        return ans;
    }
}