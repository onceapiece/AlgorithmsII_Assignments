import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ActivitySelectors {

    public static int[] s, f;

    public static List<Integer> RecursiveActivitySelector(int k, int n) {
        List<Integer> a = new ArrayList<>();
        int m = k + 1;
        while (m <= n && s[m] < f[k]) {
            m++;
        }
        if (m <= n) {
            a.add(m);
            a.addAll(RecursiveActivitySelector(m, n));
        }
        return a;
    }

    public static List<Integer> GreedyActivitySelector(int n) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        int k = 1;
        for (int m = 2; m < n; m++) {
            if (s[m] >= f[k]) {
                a.add(m);
                k = m;
            }
            return a;
        }

        return a;
    }

    public static void InitializeArray(int n) {
        s = new int[n];
        f = new int[n];
         s[0] = 0;
         f[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i%2 == 0) {
                s[i] = f[i-2];
                f[i] = s[i] + 2;
            } else {
                s[i] = f[i-1] - 1;
                f[i] = f[i-1] + 1;
            }
        }
    }

    public static void StudyOverhead(int n) throws IOException {
        FileWriter writeData = new FileWriter("ActivitySelData.csv", false);
        PrintWriter pw0b = new PrintWriter(writeData, false);
        pw0b.flush();
        StringBuilder sb = new StringBuilder();


        InitializeArray(n);
        for (int i = 1; i < n; i++) {
            long timeRecursive = 0, timeIterative = 0;
            for (int j = 1; j < 40; j++) {
                ArrayList<Integer> A = new ArrayList<>();
                long start = System.nanoTime();
                RecursiveActivitySelector(0, i-1);
                long end = System.nanoTime();
                timeRecursive += end - start;

                start = System.nanoTime();
                GreedyActivitySelector(i-1);
                end = System.nanoTime();
                timeIterative += end - start;
            }
            sb.append(i + "," + timeRecursive + "," + timeIterative + ","
                    + (double)timeRecursive/timeIterative + "\n");
        }
        writeData.write(String.valueOf(sb));
        writeData.close();
    }

    public static void main(String[] args) throws IOException {
        StudyOverhead(5000);
    }
}
