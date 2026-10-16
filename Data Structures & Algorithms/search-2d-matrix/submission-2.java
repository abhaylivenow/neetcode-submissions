class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        if(n == 1 && m == 1 && matrix[0][0] == target) {
            return true;
        }

        int l = 0;
        int r = n*m - 1;

        while(l <= r) {
            int mid = l + (r-l)/2;
            int getElement = getIndexElement(matrix, mid);
            if(getElement == target) {
                return true;
            } else if(getElement < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;

    }

    public int getIndexElement(int[][] matrix, int index) {
        int ans = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int newR = index / cols;
        int newC = index % cols;

        //System.out.print(newR+","+newC);

        return matrix[newR][newC];
    }
}
