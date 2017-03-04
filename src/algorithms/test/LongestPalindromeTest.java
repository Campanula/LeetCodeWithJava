package algorithms.test;

import algorithms.LongestPalindrome;

/**
 * Created by Chaney on 2017/3/2.
 */
public class LongestPalindromeTest {
    public static void main(String[] args){
        LongestPalindrome test = new LongestPalindrome();
        System.out.println(test.longestPalindrome("abcbaabcefecbagghabcdefghiihgfedcbahxx"));
        System.out.println(test.longestPalindrome("bb"));
        System.out.println(test.longestPalindrome("a"));
        System.out.println(test.longestPalindrome("babad"));
        System.out.println(test.longestPalindrome("abcba"));
        System.out.println(test.longestPalindrome("abb"));
    }
}
