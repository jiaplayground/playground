package playcode.dd;

import org.junit.jupiter.api.Test;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }
   private  boolean dfs( char[][] board, int r, int c ){
        if(c ==9){
            c=0;
            r++;
        }
        if(r==9){
            return true;
        }
        if(board[r][c]!='.'){
            return dfs(board, r, c+1);
        }
        for(char i='1'; i<='9'; i++){
           if(isValid(board, r, c, i)){
               board[r][c] = i;
               boolean can = dfs(board, r,c+1);
               if(can) return true;
           }
        }
        board[r][c] = '.';
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char ch){
        for(int i=0; i<9; i++){
            if(board[i][c]==ch || board[r][i] == ch){
                return false;
            }
        }
        int x = r/3*3;
        int y = c /3 *3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[x+i][y+j]==ch){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    void testx() {
        SudokuSolver s = new SudokuSolver();
    char[][] bd =    new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'
                }, {
                '6', '.', '.', '1', '9', '5', '.', '.', '.'
        }, {
                '.', '9', '8', '.', '.', '.', '.', '6', '.'
        }, {
                '8', '.', '.', '.', '6', '.', '.', '.', '3'
        }, {
                '4', '.', '.', '8', '.', '3', '.', '.', '1'
        }, {
                '7', '.', '.', '.', '2', '.', '.', '.', '6'
        }, {
                '.', '6', '.', '.', '.', '.', '2', '8', '.'
        }, {
                '.', '.', '.', '4', '1', '9', '.', '.', '5'
        }, {
                '.', '.', '.', '.', '8', '.', '.', '7', '9'
        }
        };
        s.solveSudoku(bd);
        int x = bd.length;
    }



}

