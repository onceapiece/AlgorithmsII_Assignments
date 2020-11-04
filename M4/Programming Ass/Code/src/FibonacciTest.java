import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @org.junit.jupiter.api.Test
    void naiveRecursive() {
        Fibonacci.naiveRecursive(6);
    }

    @org.junit.jupiter.api.Test
    void improvedRecursive() {
    }

    @org.junit.jupiter.api.Test
    void iterativeBottomUp() {
        Fibonacci.iterativeBottomUp(6);
    }
}