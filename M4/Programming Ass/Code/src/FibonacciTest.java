import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @org.junit.jupiter.api.Test
    void naiveRecursive() {
        Fibonacci.naiveRecursive(6);
    }

    @org.junit.jupiter.api.Test
    void improvedRecursiveTest() {
        Fibonacci.improvedRecursive(6);
    }

    @org.junit.jupiter.api.Test
    void iterativeBottomUp() {
        Fibonacci.iterativeBottomUp(6);
    }
}