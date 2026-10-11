class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0 ; i < 9 ; i = i+3) {
            for(int j = 0 ; j < 9 ; j = j + 3) {
                Set<Character> gridSet = new HashSet<>();
                char[][] subGrid = getSubGrid(board, i, j);
                for(int a = 0 ; a < 3 ; a++) {
                    for(int b = 0 ; b < 3 ; b++) {
                        char c = subGrid[a][b];
                        if(gridSet.contains(c)) {
                            return false;
                        } else {
                            if(c != '.') {
                                gridSet.add(c);
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0 ; i < 9 ; i++) {
            char[] row = board[i];
            Set<Character> rowSet = new HashSet<>();
            for(int j = 0 ; j < row.length ; j++) {
                char c = row[j];
                if(rowSet.contains(c)) {
                    return false;
                } else {
                    if(c != '.') {
                        rowSet.add(c);
                    }
                }
            }
        }

        for(int i = 0 ; i < 9 ; i++) {
            Set<Character> colSet = new HashSet<>();
            for(int j = 0 ; j < 9 ; j++) {
                char c = board[j][i];
                if(colSet.contains(c)) {
                    return false;
                } else {
                    if(c != '.') {
                        colSet.add(c);
                    }
                }
            }
        }

        return true;
    }

    public char[][] getSubGrid(char[][] board, int r, int c) {
        char[][] subGrid = new char[3][3];

        if(r >= 0 && r <= 2) {
            r = 0;
        } else if(r > 2 && r <= 5) {
            r = 3;
        } else {
            r = 6;
        }

        if(c >= 0 && c <= 2) {
            c = 0;
        } else if(c > 2 && c <= 5) {
            c = 3;
        } else {
            c = 6;
        }
        //System.out.print("R:"+r + " , C:" +c);

        // new r,c
        for(int i = 0 ; i < 3 ; i++) {
            for(int j = 0; j < 3 ; j++) {
                int newR = i + r;
                int newC = j + c;
                subGrid[i][j] = board[newR][newC];
            }
        }
        return subGrid;
    }
}