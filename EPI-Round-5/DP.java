/**
 * Count the number of ways to traverse a 2D array
 */
public static int uniquePaths(int m, int n) {
    int[][] mat = new int[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 || j == 0) {
                mat[i][j] = 1;
            } else {
                mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
            }
        }
    }

    return mat[m - 1][n - 1];
}

/**
 * Search for a sequence in a 2D array
 */
public static boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];
    char[] seq = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (existHelper(board, seq, i, j, 0, visited))
                return true;
        }
    }
    
    return false;
}

public static boolean existHelper(char[][] board, char[] seq, int x, int y, int ind, boolean[][] visited) {
    if (ind == seq.length)
        return true;
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != seq[ind] || visited[x][y])
        return false;
    
    visited[x][y] = true;
    boolean exist = existHelper(board, seq, x + 1, y, ind + 1, visited) ||
        existHelper(board, seq, x - 1, y, ind + 1, visited) ||
        existHelper(board, seq, x, y + 1, ind + 1, visited) ||
        existHelper(board, seq, x, y - 1, ind + 1, visited);
    visited[x][y] = false;
    
    return exist;
}

/**
 * Count the number of moves to climb stairs
 */
public int climbStairs(int n) {
    if (n <= 2) {
        return n;
    }
    
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    
    for (int i = 2; i < n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    
    return dp[n - 1];
}