/*
17.3 Count the number of ways to traverse a 2D Array
Write a program that counts how many ways you can go from the top-left
to the bottom-right in a 2D array
*/
public static int numWays(int m, int n) {
    int[][] mat = new int[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 || j == 0) {
                mat[i][j] == 1;
            } else {
                mat[i][j] = mat[i - 1][j] + mat[i][j - 1] + mat[i - 1][j - 1] + 1;
            }
        }
    }

    return mat[m - 1][n - 1];
}


/*
17.5 Search for Sequence in a 2D Array
*/
public boolean exist(char[][] board, String word) {
    char[] charWord = word.toCharArray();
    boolean[][] visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (existHelper(charWord, 0, i, j, board, visited)) {
                return true;
            }
        }
    }

    return false;
}

public boolean existHelper(char[] charWord, int wordInd, int x, int y, char[][] board, boolean[][] visited) {
    if (wordInd == charWord.length) {
        return true;
    }

    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || charWord[wordInd] != board[x][y]) {
        return false;
    }

    visited[x][y] = true;

    boolean exist =
        existHelper(charWord, wordInd + 1, x + 1, y, board, visited) ||
        existHelper(charWord, wordInd + 1, x - 1, y, board, visited) || 
        existHelper(charWord, wordInd + 1, x, y + 1, board, visited) || 
        existHelper(charWord, wordInd + 1, x, y - 1, board, visited);

    visited[x][y] = true;

    return exist;
}

/*
17.7 The BedBathAndBeyond.Com
Given a dictionary, design an efficient algorithm that checks whether the
name is the concatenation of a sequence of dictionary words
*/
public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] f = new boolean[s.length() + 1];
    f[0] = true;
    
    for (int i = 1; i <= s.length(); i++) {
        for (int j = 0; j < i; j++) {
            if (f[j] && wordDict.contains(s.substring(j, i))) {
                f[i] = true;
                break;
            }
        }
    }
    
    return f[s.length()];
}

/*
17.12 Find the longest increasing subsequence
*/
public int lengthOfLIS(int[] nums) {
    if (nums.length < 1)
        return 0;
    
    int[] dp = new int[nums.length];
    
    for (int i = 1; i < nums.length; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }
    
    int max = dp[0];
    for (int curr : dp) {
        max = Math.max(max, curr);
    }
    
    return max + 1;
}