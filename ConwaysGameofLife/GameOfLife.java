public class GameOfLife {

    public int[][] tick(int[][] board) {
        int rows = board.length;
        if(rows == 0) return board;

        int cols = board[0].length;

        int[][] next = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = countLiveNeighbors(board, row, col);

                if (board[row][col] == 1) {
                    next[row][col] = (liveNeighbors == 2 || liveNeighbors == 3) ? 1 : 0;
                } else {
                    next[row][col] = (liveNeighbors == 3) ? 1 : 0;
                }
            }
        }

        return next;
    }

    private int countLiveNeighbors(int[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;

        int count = 0;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue; 

                int r = row + dr;
                int c = col + dc;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    count += board[r][c];
                }
            }
        }

        return count;
    }
}
