import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class P00130_Surrounded_Regions {

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        P00130_Surrounded_Regions solutions = new P00130_Surrounded_Regions();
        long startTime = System.currentTimeMillis();
        solutions.solve(board);
        long elapseTime = System.currentTimeMillis() - startTime;
        System.out.println("Time Taken : " + elapseTime);
        solutions.printboard(board);
        char[][] board2 = {{'O','O'} , {'O','O'}} ;
        startTime = System.currentTimeMillis();
        solutions.solve(board2);
        elapseTime = System.currentTimeMillis() - startTime;
        System.out.println("Time Taken : " + elapseTime);
        solutions.printboard(board2);

        char[][] board1 = {{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}};

        startTime = System.currentTimeMillis();
        solutions.solve(board1);
        elapseTime = System.currentTimeMillis() - startTime;
        System.out.println("Time Taken : " + elapseTime);
        solutions.printboard(board1);

    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        // Search on the boundaries for 0
        int rows = board.length;
        int columns = board[0].length;
        for (int r = 0; r < rows; r++) {
            mark(board, r, 0);
            mark(board, r, columns - 1);
        }
        for (int c = 0; c < columns; c++) {
            mark(board, 0, c);
            mark(board, rows - 1, c);
        }
        // flip back
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                    continue;
                }
                if (board[r][c] == 'Y') {
                    board[r][c] = 'O';
                    continue;
                }
            }
        }

    }

    private void mark(char[][] board, int x, int y) {
        if (board[x][y] != 'O') {
            return;
        }
        int columns = board[0].length;
        int index = x * columns + y;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(index);
        board[x][y] = 'Y';
        while (!queue.isEmpty()) {
            int top = queue.poll();
            int i = top / columns;
            int j = top % columns;
            if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                board[i-1][j] = 'Y';
                queue.offer((i - 1) * columns + j);
            }
            if (i + 1 < board.length && board[i + 1][j] == 'O') {
                board[i+1][j] = 'Y';
                queue.offer((i + 1) * columns + j);
            }
            if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                board[i][j-1] = 'Y';
                queue.offer(i * columns + (j - 1));
            }
            if (j + 1 < board[0].length && board[i][j + 1] == 'O') {
                board[i][j+1] = 'Y';
                queue.offer(i * columns + (j + 1));
            }
        }
    }

    private void printboard(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println("]");
        }
    }
}
