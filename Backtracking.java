public class Backtracking {
    public static void main(String[] args) {

    }

    static boolean NQueen(int board[][], int row) {
        if (row == board.length)
            return true;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                if (NQueen(board, row + 1))
                    return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int board[][], int row, int col) {
        //checking rows
        for (int i = 0; i < col; i++) {
            if(board[row][i]==1) return false;
        }
        //checking cols
        for (int i = 0; i < row; i++) {
            if(board[i][col]==1) return false;
        }
        // //checking digonals
        

        return true;
    }
}
