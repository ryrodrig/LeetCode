package leetcode.bitmanipulation.easy.review;

public class OppositeNumbers {

    public static void main(String[] args) {
        int firstNumber = 10;
        int secondNumber = 12;

        if((firstNumber ^ secondNumber) < 0) {
            System.out.println("Opposite signs");
        } else {
            System.out.println("Same signs");
        }
    }
}
