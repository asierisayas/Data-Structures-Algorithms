/*
6.5 Delete duplicates from a sorted array
Write a program which takes as input a sorted array and updates
it so that all duplicates have been removed and the remaining elements
have been shifted left tom fill the emptied indices. 
*/
public static int deleteDuplicates(int[] A) {
    int currInd = 1;
    for (int i = 1; i < A.length; i++) {
        if (A[i] != A[i - 1]) {
            A[currInd++] = A[i];
        }
    }

    return currInd;
}

/*
6.6 Buy and Sell a Stock Once
Write a program that takes an array denoting the daily stock price, 
and returns the maximum profit that could be made by buying and then
selling one share of that stock
*/
public static int stocks(int[] A) {
    int min = A[0];
    int maxProfit = Integer.MIN_VALUE;

    for (int i = 1; i < A.length; i++) {
        maxProfit = Math.max(maxProfit, A[i] - min);
        min = Math.min(min, A[i]);
    }
}

/*
6.8 Enumerate all primes to n
Write a program that takes an integer argument and returns all the primes 
between 1 and that integer
*/
public static List<Integer> primes(int n) {
    List<Integer> primes = new ArrayList<>();

    boolean[] notPrime = new boolean[n + 1];
    notPrime[0] = true;
    notPrime[1] = true;

    for (int i = 2; i <= n; i++) {
        if (!notPrime[i]) {
            notPrime[i] = true;
            primes.add(i);

            for (int j = i; j <= n; j += i) {
                notPrime[j] = true;
            }
        }
    }
    return primes;
} 

/*
6.17 Compute the spiral ordering of a 2D Array
*/

public static List<Integer> matrixInSpiralOrder(int[][] mat) {
    List<Integer> output = new ArrayList<>();

    int rowStart = 0;
    int rowEnd = mat.length - 1;
    int colStart = 0;
    int colEnd = mat[0].length - 1;

    while (rowStart < rowEnd && colStart < colEnd) {
        for (int i = colStart; i <= colEnd; i++) {
            output.add(mat[rowStart][i]);
        }
        rowStart++;

        for (int i = rowStart; i <= rowEnd; i++) {
            output.add(mat[i][colEnd]);
        }
        colEnd--;

        if (rowStart < rowEnd) {
            for (int i = colEnd; i >= colStart; i--) {
                output.add(mat[rowEnd][i]);
            }
            rowEnd++;
        }

        if (colStart < colEnd) {
            for (int i = rowEnd; i >= rowStart; i--) {
                output.add(mat[i][colStart])
            }

            colStart++;
        }
    }

    return output;

}