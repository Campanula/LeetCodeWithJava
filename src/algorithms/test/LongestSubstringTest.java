package algorithms.test;

import algorithms.LongestSubstring;

public class LongestSubstringTest {
    public static void main(String[] args) {
        LongestSubstring test = new LongestSubstring();
        System.out.println(test.longestSubstring(""));
        System.out.println(test.longestSubstring("abcbebdcad"));
        System.out.println(test.longestSubstring("abcbebdca"));
        System.out.println(test.longestSubstring("ab"));
        System.out.println(test.longestSubstring("a"));
        System.out.println(test.longestSubstring("bbbbbbb"));
        System.out.println(test.longestSubstring("pwwkew"));
    }
}
