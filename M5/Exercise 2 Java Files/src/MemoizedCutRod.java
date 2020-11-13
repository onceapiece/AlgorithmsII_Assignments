

public class MemoizedCutRod {


   public int MemoizedCutRod(int[] p, int n) {
      int[] r = new int[n+1];
      for (int i = 0; i <= n ; i++) {
         r[i] = -1;
      }
      return MemoizedCutRodAux(p, n, r);
   }

   public int MemoizedCutRodAux(int[] p, int n, int[] r) {
      int q = -1;
      if (r[n] >= 0) {
         return r[n];
      }
      if (n==0) {
         q = 0;
      }
      for (int i = 1; i <= n ; i++) {
         q = Math.max(q, p[i] + MemoizedCutRodAux(p, n-i, r));
      }
      r[n] = q;
      return q;
   }

   public static int[][] MemoizedCutRodSolution(int[] prices, int n) {
      int[] results = new int[n+1];
      int[] size = new int[n+1];
      for (int i = 0; i <= n ; i++) {
         results[i] = -1;
      }
      int maxRevenue = MemoizedCutRodSolutionAux(prices, n, results, size);
      return new int[][]{results, size};
   }

   public static int MemoizedCutRodSolutionAux(int[] prices, int n, int[] results, int[] size) {
      int q = -1;
      if (results[n] >= 0) {
         return results[n];
      }
      if (n==0) {
         q = 0;
      }
      for (int i = 1; i <= n ; i++) {
         int b = prices[i] + MemoizedCutRodSolutionAux(prices, n-i, results, size);
         if (q < b) {
            q = b;
            size[n] = i;
         }
      }

      results[n] = q;
      return q;
   }

   public static void PrintCutRodSolution(int n, int[] prices) {
      int[][] solution = MemoizedCutRodSolution(prices, n);
      if (n == solution[1][n]) {
         System.out.println("A rod of length " + n + " should not be cut.\n"
         + "The maximum revenue of length " + n + " is " + solution[0][n]
         + " which is greater than any combination of cuts.");
      } else {
         System.out.println("A rod of length " + n + " should be cut into the following lengths: ");
         int maxRevenue = solution[0][n];
         while (n > 0) {
            System.out.println(solution[1][n]);
            n = n - solution[1][n];
         }
         System.out.println("for a maximum revenue of " + maxRevenue);
      }
   }

   public static void main(String[] args) {
      int[] prices = {0,1,5,8,9,10,17,17,20,24,30};
      PrintCutRodSolution(7, prices);
   }



}
