//Microsoft OA Questions
/**
 * Write a function that given an array A consisting of N integers, returns
 * the maximum sum of two numbers whose digits add up to an equal sum
 * If there are no two numbers whose digits have an equal sum, the function
 * should return -1
 */
private static int maxPair(int[] A) {
    if (A.length <= 1) {
        return -1;
    }
    
    int maxSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : A) {
       int digitSum = computeDigitSum(num);
       if (!map.containsKey(digitSum)) {
           map.put(digitSum, num);
       } else {
          maxSum = Math.max(maxSum, map.get(digitSum) + num);
          map.put(digitSum, Math.max(num, map.get(digitSum)));
       }
    }
    
    return maxSum;
}

private static int computeDigitSum(int a){
   a = Math.abs(a);
   int res = 0;
   while(a > 0){
       res += a % 10;
       a /= 10;
   }
   return res;
}