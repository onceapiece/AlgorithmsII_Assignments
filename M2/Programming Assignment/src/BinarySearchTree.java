import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class BinarySearchTree {

    static class Node {
        int key;
        Node left, right, parent;

        public Node(int v) {
            key = v;
            left = right = parent = null;
        }
    }

    static Node root;

    /**
     * Constructor.
     */
    public BinarySearchTree() {
        root = null;
    }

    public static void treeInsert(BinarySearchTree T, Node z) {
        Node y = null;
        Node x = T.root;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            T.root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    public static int getHeight(Node node) {
        if(node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void collectData() throws IOException {
        //create new file and print writer
        FileWriter writeData = new FileWriter("data.csv", false);
        PrintWriter pwOb = new PrintWriter(writeData, false);
        pwOb.flush();
        StringBuilder dataSB = new StringBuilder();

        Random rand = new Random();

        for (int n = 500; n <= 20000 ; n = n + 500) {
            int sumHeight = 0;
            int avgHeight = 0;
            double heightOverLogN = 0;
            double heightOverN = 0;
            double logN = Math.log(n) / Math.log(2);
            for (int j = 0; j < 10; j++) { // take 10 measurements
                BinarySearchTree T = new BinarySearchTree();
                for (int i = 0; i < n; i++) {
                    Node z = new Node(rand.nextInt(n));
                    treeInsert(T, z);
                }
                // Measure the height
                int height = getHeight(T.root);
                sumHeight += height;
                avgHeight = (int)(sumHeight / 10);
                heightOverN = (double) avgHeight / n;
                heightOverLogN = height / logN;
            }
            dataSB.append(n + "," + avgHeight + ",\n");
        }

        writeData.write(String.valueOf(dataSB));
        writeData.close();
    }

    
    public static void main(String[] args) throws IOException {
        collectData();
    }
}
