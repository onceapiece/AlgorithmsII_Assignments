public class CutRod {
    public static int[] prices = {0,1,5,8,9,10,17,17,20,24,30};

    public static int Bottom_Up_Cut_Rod(int[] p, int n) {
        int[] r = new int[n+1];
        r[0] = 0;
        for (int j = 1; j <= n ; j++) {
            double q = Double.NEGATIVE_INFINITY;
            for (int i = 1; i <= j; i++) {
                q = Math.max(q, p[i] + r[j-i]);
            }
            r[j] = (int) q;
        }
        return r[n];
    }

    public static int Extended_Bottom_Up_Cut_Rod(int[] p, int n) {
        int[] results = new int[n+1];
        int[] size = new int[n+1];
        results[0] = 0;
        size[0] = 0;

        for (int j = 1; j <= n ; j++) {
            double q = Double.NEGATIVE_INFINITY;
            for (int i = 1; i <= j ; i++) {
                if (q < p[i] + results[j-i]) {
                    q = p[i] + results[j-i];
                    size[j] = i;
                }
                results[j] = (int) q;
            }
        }
        return results[n];
    }

    public static int Extended_Bottom_Up_Cut_Rod_With_Cost(int[] p, int n, int c) {
        int[] results = new int[n+1];
        int[] size = new int[n+1];
        results[0] = 0;
        size[0] = 0;

        for (int j = 1; j <= n ; j++) {
            double q = Double.NEGATIVE_INFINITY;
            for (int i = 1; i <= j ; i++) {
                /**
                 * This first IF statement performs and compares all possible cuts,
                 *     then stores their value in r[j] with the cost C deducted.
                 *
                 * The second IF statement checks to see if a cut minus the cost has
                 *      a higher value than the value with no cuts.
                 */
                if (q < p[i] + results[j-i] - c) {
                    size[j] = i;
                    q = p[i] + results[j-i] - c;
                    results[j] = (int) q;
                }
                if (results[j] < prices[j]) {
                    results[j] = prices[j];
                    size[j] = j;
                }
            }
        }
        return results[n];
    }



    public static void main(String[] args) {
        System.out.println(Extended_Bottom_Up_Cut_Rod_With_Cost(prices, 10, 1));

    }
}
