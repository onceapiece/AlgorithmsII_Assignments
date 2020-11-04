import java.util.HashMap;

public class Fibonacci {
    /**
     * Naive Recursive implementation of Fibonacci.
     * @param n root of the tree
     * @return the fibonacci number for n.
     */
    public static int naiveRecursive(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        return naiveRecursive(n-1) + naiveRecursive(n-2);
    }

    /**
     * The improved implementation of the recursive method
     *      for the fibonacci numbers using memoization.
     * @param n root of the tree
     * @return the fibonacci number for n.
     */
    public static int improvedRecursive(int n) {
        HashMap<Integer, Integer> fib = new HashMap<>();
        if (fib.containsKey(n)) return fib.get(n);
        if (n==0) return 0;
        if (n==1) return 1;
        int value = improvedRecursive(n-1) + improvedRecursive(n-2);
        fib.put(n, value);
        return value;
    }

    /**
     * Iterative version to compute Fibonacci number.
     * @param n root of the tree
     * @return the fibonacci number for n.
     */
    public static int iterativeBottomUp(int n) {
        HashMap<Integer, Integer> fib = new HashMap<>();
        fib.put(0,0);
        fib.put(1,1);
        for (int i = 2; i <=n ; i++) {
            fib.put(i, fib.get(i-1) + fib.get(i-2));
        }
        return fib.get(n);
    }

    public static void main(String[] args) {

    }
}
