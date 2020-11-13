import junit.framework.Assert;

class MemoizedCutRodTest {

   int[] prices = {0,1,5,8,9,10,17,17,20,24,30};
   MemoizedCutRod m = new MemoizedCutRod();

   @org.junit.jupiter.api.Test
   void memoizedCutRodAuxTest() {
      Assert.assertEquals(1, m.MemoizedCutRod(prices, 1));
      Assert.assertEquals(5, m.MemoizedCutRod(prices, 2));
      Assert.assertEquals(8, m.MemoizedCutRod(prices, 3));
      Assert.assertEquals(10, m.MemoizedCutRod(prices, 4));
      Assert.assertEquals(13, m.MemoizedCutRod(prices, 5));
      Assert.assertEquals(17, m.MemoizedCutRod(prices, 6));
      Assert.assertEquals(18, m.MemoizedCutRod(prices, 7));
      Assert.assertEquals(22, m.MemoizedCutRod(prices, 8));
      Assert.assertEquals(25, m.MemoizedCutRod(prices, 9));
      Assert.assertEquals(30, m.MemoizedCutRod(prices, 10));
   }

   @org.junit.jupiter.api.Test
   void memoizedCutRodWithCostAuxTest() {
      Assert.assertEquals(1, m.MemoizedCutRodSolution(prices, 1));
      Assert.assertEquals(5, m.MemoizedCutRodSolution(prices, 2));
      Assert.assertEquals(8, m.MemoizedCutRodSolution(prices, 3));
      Assert.assertEquals(10, m.MemoizedCutRodSolution(prices, 4));
      Assert.assertEquals(13, m.MemoizedCutRodSolution(prices, 5));
      Assert.assertEquals(17, m.MemoizedCutRodSolution(prices, 6));
      Assert.assertEquals(18, m.MemoizedCutRodSolution(prices, 7));
      Assert.assertEquals(22, m.MemoizedCutRodSolution(prices, 8));
      Assert.assertEquals(25, m.MemoizedCutRodSolution(prices, 9));
      Assert.assertEquals(30, m.MemoizedCutRodSolution(prices, 10));
   }

}