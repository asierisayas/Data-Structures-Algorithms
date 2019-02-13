/*
17.1 Count the number of score combinations
Write a program that takes a final score and scores for individual plays, and returns the number of combinations of plays that result in the final score. 
*/
public int change(int amount, int[] coins) {
    if (amount == 0)
        return 1;
    
    if (coins.length == 0)
        return 0;
    
    int[][] dp = new int[coins.length][amount + 1];
    for (int i = 0; i < dp.length; i++) {
        dp[i][0] = 1;
        for (int j = 1; j < dp[0].length; j++) {
            if (i - 1 >= 0) {
                dp[i][j] += dp[i - 1][j];
            }
            if (j - coins[i] >= 0) {
                dp[i][j] += dp[i][j - coins[i]];
            }
        }
    }
    
    return dp[dp.length - 1][dp[0].length - 1];
}

/*
17.2 Compute the Levenshtein Distance
Write a program that takes two strings and computes the minimum number of edits needed to transform the first string into the second string
*/
public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i < dp.length; i++) {
        dp[i][0] = i;
    }
    
    for (int j = 0; j < dp[0].length; j++) {
        dp[0][j] = j;
    }
    
    for (int i = 1; i < dp.length; i++) {
        for (int j = 1; j < dp[0].length; j++) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1))
                dp[i][j] = dp[i - 1][j - 1];
            else 
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        }
    }
    
    return dp[dp.length - 1][dp[0].length - 1];
}

/*
17.3 Count the Number of ways to traverse a 2D array
Write a program that counts how many ways you can go from the 
top-left to the bottom-right in a 2D array
*/
public int numWays(int n, int m) {
    int[][] dp = new int[n][m];
    for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[0].length; j++) {
            if (i == 0 || j == 0) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
    }

    return dp[n - 1][m - 1];
}

/*
17.5 Search for Sequence in 2D Array
Write a program that takes as arguments a 2D array and a 1D array, 
and checks whether the 1D array occurs in the 2D array
*/
public boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];
    char[] seq = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (existHelper(board, seq, 0, i, j, visited)) {
                return true;
            }
        }
    }
}

public boolean existHelper(char[][] board, char[] seq, int ind, int x, int y, boolean[][] visited) {
    if (ind == word.length) {
        return true;
    }

    if (x < 0 || x == board.length || y < 0 || y == board[0].length || visited[x][y] || seq[ind] != board[x][y]) {
        return false;
    }

    visited[x][y] = true;
    boolean exist = 
        existHelper(board, seq, ind + 1, x + 1, y, visited) ||
        existHelper(board, seq, ind + 1, x - 1, y, visited) || 
        existHelper(board, seq, ind + 1, x, y + 1, visited) ||
        existHelper(board, seq, ind + 1, x, y - 1, visited);

    visited[x][y] = false;
    return exist;
}

/*
17.6 Knapsack/Coin Change Problem
Given coins of 1, 2, and 3. Find how many ways you can added up 5
*/
public int change(int amount, int[] coins) {
    int[][] dp = new int[coins.length][amount + 1];

    for (int i = 0; i < dp.length; i++) {
        dp[i][0] = 1;
        for (int j = 1; j < dp[0].length; j++) {
            int withCoin = 0;
            int withOutCoin = 0;
            if (j - coins[i] >= 0) {
                withCoin += dp[i][j - coins[i]];
            }
            if (i - 1 >= 0) {
                withOutCoin += dp[i - 1][j];
            }

            dp[i][j] = withCoin + withOutCoin;
        }
    }

    return dp[dp.length - 1][dp[0].length - 1];
}

/*
17.7 The BEDBATHANDBEYOND.COM problem
Given a dictionary (set of strings), and a name, check whether
the name is the concatentation of a sequence of dictionary words.
A dictionary word may appear more than once in the sequence, e.g., 
"a", "man", "a", "plan", "a", "canal" is a valid sequence for 
"amanaplanacanal".
*/
public boolean wordBreak(String word, Set<String> dict) {
    boolean[] f = new boolean[word.length() + 1];
    f[0] = true;

    for (int i = 1; i <= word.length(); i++) {
        for (int j = 0; j < i; j++) {
            if (f[j] && dict.contains(word.substring(j,i))) {
                f[i] = true;
                break;
            }
        }
    }

    return f[word.length()];
}

/*
17.8 Find the Minimum Weight Path in a Triangle
Write a program that tkes as input a triangle of numbers and returns
the weight of a minimum weight path
*/

/*
17.10
Count the number of moves to climb stairs
Write a program that takes as inputs n and k and returns the number of 
ways in which you can get to your destination
Complexity: Take O(k) time to compute each entry, n entries so O(kn)
*/
public int countMoves(int k, int n) {
    int[] arr = new int[n];
    for (int i = 0; i < k; i++) {
        arr[i] = i + 1;
    }

    for (int j = k; j < n; j++) {
        for (int i = 1; i <= k; i++) {
            arr[j] += arr[j - i];
        }
    }

    return arr[n - 1];
}

/*
17.12 Find the Longest Nondecreasing Subsequence
Write a program that takes an input an array of numbers and returns 
the length of a longest nondecreasing subsequence in the array
Complexity: O(n^2) time and O(n) space
*/
public int nonDec(int[] arr) {
    int[] counter = new int[arr.length];
    Arrays.fill(counter, 1);
    for (int i = 1; i < arr.length; i++) {
        for (int j = 0; j < i; j++) {
            if (arr[j] <= arr[i]) {
                counter[i] = Math.max(counter[i], counter[j] + 1);
            }
        }
    }

    return Collections.max(Arrays.asList(counter));
}
