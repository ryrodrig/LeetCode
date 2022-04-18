package leetcode.bitmanipulation.easy.review;

public class CaseConversion {
// the difference between upper case and lower case is the 3rd most signiicant bit
    // ‘A’ — 01000001 ‘a’ — 01100001
    // ‘B’ — 01000010 ‘b’ — 01100010
    // lower case has a 1 and upper case has a '0';


    // converting to upper case would require setting 3rd significant bit to '0'
    // '_' bit code = 01011111 nd & operator
    public static void convertToUpperCase() {
        System.out.println("Binary String of '_'" + Integer.toBinaryString('_'));
        for(char c='a' ; c <='z';c++) {
            char charVal =(char) (c & '_');
            System.out.println(charVal);
        }
    }

    // converting to lower case would require setting 3rd significant bit to '1'
    // ' ' bit code = 00100000 nd | operator
    public static void convertToLowerCase() {
        System.out.println("Binary String of ' '" + Integer.toBinaryString(' '));
        for(char c='A' ; c <='Z';c++) {
            char charVal =(char) (c | ' ');
            System.out.println(charVal);
        }
    }

    // toggle requires flipping the 3rd significant bit and whyu not use XOR.
    // ' ' bit code = 00100000 nd ^ operator
    public static void toggle() {
        System.out.println("Binary String of ' '" + Integer.toBinaryString(' '));
        for(char c='A' ; c <='Z';c++) {
            char charVal =(char) (c ^ ' ');
            System.out.println(charVal);
        }
    }

    public static void main(String[] args) {
        convertToUpperCase();
        convertToLowerCase();
        toggle();
    }



}
