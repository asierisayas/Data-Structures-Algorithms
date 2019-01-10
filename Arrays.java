/*
6.4 Advancing through an array
*/
public boolean canReachEnd(int[] arr) {
    int furthestMaxSoFar = 0;
    int lastIndex = arr.length - 1;

    for (int i = 0; i <= furthestMaxSoFar && furthestMaxSoFar <= lastIndex; i++) {
        furthestMaxSoFar = Math.max(furthestMaxSoFar, i + arr[i]);
    }

    return furtherstMaxSoFar >= lastIndex;
}

/*
6.5 Delete Duplicates from a sorted Array
*/
public int deleteDups(int[] arr) {
    int count = 1;
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] != arr[i - 1])
            arr[count++] = arr[i - 1];
    }
}

/*
6.6 Buy and Sell a stock once
*/
public int maxProfit(int[] arr) {
    int min = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = 1; i < arr.length; i++) {
        maxProfit = Math.max(maxProfit, arr[i] - min);
        min = Math.min(min, arr[i]);
    }

    return maxProfit;
}


/*
6.17 Spiral matrix
Write a 2D array in spiral order
*/
public static List<Integer> matrixSpiral(int[] mat) {
    List<Integer> ls = new ArrayList<>();
    int rowStart = 0;
    int colStart = 0;
    int rowEnd = mat.length - 1;
    int colEnd = mat[0].length - 1;

    while (rowStart <= rowEnd && colStart <= colEnd) {
        for (int i = colStart; i <= colEnd; i++) {
            ls.add(mat[rowStart][i]);
        }
        rowStart++;

        for (int i = rowStart; i <= rowEnd; i++) {
            ls.add(mat[i][colEnd]);
        }
        colEnd--;

        if (rowStart <= rowEnd) {
            for (int i = colEnd; i >= colStart; i--) {
                ls.add(mat[rowEnd][i]);
            }
            rowEnd--;
        }
        
        if (colStart <= colEnd) {
            for (int i = rowEnd; i >= rowStart; i--) {
                ls.add(mat[i][colStart]);
            }
            colStart++;
        }
    }

    return ls;
}

/*
6.18 Rotate a 2D array
*/
public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < (n + 1) / 2; i++) {
        for (int j = i; j < n - 1 - i; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[n - 1 - j][i];
            matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
            matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
            matrix[j][n - 1 - i] = temp;
        }
    }
}