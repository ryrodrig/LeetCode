package leetcode.string.medium;

/**
 *
 */
public class IntegerToRoman {

    private String[] M = {"","M","MM", "MMM"};
    private String[] C = {"","C","CC","CCC","CD", "D", "DC", "DCC", "DCCC", "CM"};
    private String[] X = {"","X","XX","XXX","XL", "L", "LX", "LXX", "LXXX", "XC"};
    private String[] I = {"","I","II","III","IV", "V", "VI", "VII", "VIII", "IX"};


    public String convertIntegerToRoman(int number) {
        return M[number/1000] + C[number%1000/100] + X[(number%1000)%100/10] + I[((number%1000)%100)%10];
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.convertIntegerToRoman(3200));
    }
}
