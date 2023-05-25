package MySite.LeetCode.graph;

public class SurroundedRegions {
    public final int[] row = {-1, 0, 0, 1};
    public final int[] col = {0, -1, 1, 0};
    public boolean isSafe(char[][] board, int i , int j, char target){
        return (i >= 0 && i < board.length) && (j >= 0 && j < board[0].length) && board[i][j] == target;
    }
    public void dfs(char[][] board, int i, int j, char replacement){
        char target = board[i][j];
        board[i][j] = replacement;
        for(int k = 0 ; k < 4; k++){
            if(isSafe(board, i + row[k], j + col[k], target)){
                dfs(board, i + row[k], j + col[k], replacement);
            }
        }
    }
    public void dfs(char[][] board ){
        if(board.length == 0) return;
        int M = board.length;
        int N = board[0].length;

        for(int i = 0; i < N; i++){
            if(board[0][i] == 'O') dfs(board, 0, i, '2');
            if(board[M - 1][i] == 'O') dfs(board, M - 1, i, '2');
        }
        for(int i = 0; i < M; i++){
            if(board[i][0] == 'O') dfs(board, i, 0, '2');
            if(board[i][N - 1] == 'O') dfs(board, i, N - 1, '2');
        }
        for(int i = 0; i < M; i++){
            for( int j = 0; j < N; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '2') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void solve(char[][] board) {
        dfs(board);
    }
}
