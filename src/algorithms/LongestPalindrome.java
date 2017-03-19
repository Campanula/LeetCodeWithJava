package algorithms;

/**
 * <h>Longest Palindromic Substring</h>
 * <p>Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.</p>
 * Example:
 * <pre>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * </pre>
 * Example:
 * <pre>
 * Input: "cbbd"
 * Output: "bb"
 * </pre>
 */

public class LongestPalindrome {
    /**
     * 暴力搜索
     */
    public String longestPalindromeF(String s) {
        char[] cs = s.toCharArray();
        for (int searchScope = cs.length - 1; searchScope >= 0; searchScope--) {
            int space = cs.length - searchScope;
            for (int i = 0; i < space; i++) {
                if (cs[i] == cs[i + searchScope]) {
                    boolean isPalindrome = true;
                    int radius = searchScope / 2;
                    for (int j = 1; j <= radius; j++) {
                        if (cs[i + j] != cs[i + searchScope - j]) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) {
                        return s.substring(i, i + searchScope + 1);
                    }
                }
            }
        }
        return cs.length > 0 ? s.substring(0, 1) : "";
    }

    /**
     * 回文竞价：回文中心为竞价代表，回文半径长的获胜
     */
    private int lo = 0, maxLen = 0, searchRadius = 0;

    public String longestPalindrome(String s) {
        lo = 0;
        maxLen = 0;
        searchRadius = 0;
        char[] c = s.toCharArray();
        if (c.length < 2) return s;

        //        int head = 0;
        //        for (int i = 1; i < c.length; i++) {
        //            if (c[head] != c[i]) {
        //                if (i - head > maxLen) {
        //                    maxLen = i - head;
        //                    lo = head;
        //                }
        //                head = i;
        //            }
        //        }
        //
        //        if (maxLen % 2 != 0) {
        //            searchRadius = maxLen / 2;
        //        } else {
        //            searchRadius = maxLen / 2 - 1;
        //        }

        for (int i = searchRadius + 1; i + searchRadius + 1 < c.length; i++) {
            if (c[i - searchRadius - 1] == c[i + searchRadius + 1]) {
                extendPalindrome(c, i, i);  //assume odd length, try to extend Palindrome as possible
            }
        }
        for (int i = searchRadius; i + searchRadius + 1 < c.length; i++) {
            if (c[i - searchRadius] == c[i + searchRadius + 1]) {
                extendPalindrome(c, i, i + 1); //assume even length.
            }
        }
        return maxLen == 0 ? s.substring(0, 1) : s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(char[] c, int j, int k) {
        while (j >= 0 && k < c.length && c[j] == c[k]) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
            searchRadius = maxLen / 2;
        }
    }
}
