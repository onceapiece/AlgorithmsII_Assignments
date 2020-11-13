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


}
