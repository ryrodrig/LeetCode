package leetcode.bitmanipulation.easy.review;

/**
 * Swap numbers without third variable.
 */
public class SwapNumbers {

    public static void main(String[] args) {
        int first = 10;
        int second = 100;
        System.out.println("First : " + first + " Second: " + second);

        first = (first ^ second);
        second = (first ^ second);
        first = (first ^ second);

        System.out.println("First : " + first + " Second: " + second);
    }
}
