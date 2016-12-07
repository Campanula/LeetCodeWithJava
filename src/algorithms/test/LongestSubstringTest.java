package algorithms.test;

import algorithms.LongestSubstring;

public class LongestSubstringTest {
    public static void main(String[] args) {
        LongestSubstring test = new LongestSubstring();
        System.out.println(test.LongestSubstring(""));
        System.out.println(test.LongestSubstring("abcbebdcad"));
        System.out.println(test.LongestSubstring("abcbebdca"));
        System.out.println(test.LongestSubstring("ab"));
        System.out.println(test.LongestSubstring("a"));
        System.out.println(test.LongestSubstring("bbbbbbb"));
        System.out.println(test.LongestSubstring("pwwkew"));
    }
}
