import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    public static HashMap<Integer, Integer> fib = new HashMap<>();

    /**
     * The improved implementation of the recursive method
     *      for the fibonacci numbers using memoization.
     * @param n root of the tree
     * @return the fibonacci number for n.
     */
    public static int improvedRecursive(int n) {
        if (fib.containsKey(n)) return fib.get(n);
        if (n==0) return 0;
        if (n==1) return 1;
        int value = improvedRecursive(n-1) + improvedRecursive(n-2);
        fib.put(n, value);
        return value;
    }

    public static HashMap<Integer, Integer> fib2 = new HashMap<>();

    /**
     * Iterative version to compute Fibonacci number.
     * @param n root of the tree
     * @return the fibonacci number for n.
     */
    public static int iterativeBottomUp(int n) {
        fib2.put(0,0);
        fib2.put(1,1);
        for (int i = 2; i <=n ; i++) {
            fib2.put(i, fib2.get(i-1) + fib2.get(i-2));
        }
        return fib2.get(n);
    }

    public static void naiveData() throws IOException {
        FileWriter writeData = new FileWriter("naive_recursive_data.csv", false);
        PrintWriter pw0b = new PrintWriter(writeData, false);
        pw0b.flush();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= 55; i++) {
            long starTime = System.nanoTime();
            naiveRecursive(i);
            long endTime = System.nanoTime();
            long totalTime = endTime - starTime;
            sb.append(i + "," + totalTime + "\n");
        }
        writeData.write(String.valueOf(sb));
        writeData.close();
    }

    public static void improvedRecData() throws IOException {
        FileWriter writeData =
                new FileWriter("improved_recursive_data.csv", false);
        PrintWriter pw0b = new PrintWriter(writeData, false);
        pw0b.flush();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= 55; i++) {
            long starTime = System.nanoTime();
            improvedRecursive(i);
            long endTime = System.nanoTime();
            long totalTime = endTime - starTime;
            sb.append(i + "," + totalTime + "\n");
        }
        writeData.write(String.valueOf(sb));
        writeData.close();
    }

    public static void iterativeData() throws IOException {
        FileWriter writeData = new FileWriter("iterative_data.csv", false);
        PrintWriter pw0b = new PrintWriter(writeData, false);
        pw0b.flush();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= 55; i++) {
            long starTime = System.nanoTime();
            iterativeBottomUp(i);
            long endTime = System.nanoTime();
            long totalTime = endTime - starTime;
            sb.append(i + "," + totalTime + "\n");
        }
        writeData.write(String.valueOf(sb));
        writeData.close();
    }

    public static void main(String[] args) throws IOException {
//        naiveData();
        improvedRecData();
        iterativeData();
    }
}
