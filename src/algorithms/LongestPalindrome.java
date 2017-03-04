package algorithms;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        boolean odd = true;
        int maxCenter = 0, pointer = 0, halfLengthForSearch = 0;
        //奇回文
        while (pointer < cs.length) {
            if (cs.length - 1 - pointer < halfLengthForSearch) {
                break;
            }
            if (cs[pointer - halfLengthForSearch] == cs[pointer + halfLengthForSearch]) {
                int halfLength = 1;
                while (pointer - halfLength >= 0 && pointer + halfLength < cs.length) {
                    if (cs[pointer - halfLength] == cs[pointer + halfLength]) {
                        halfLength++;
                    } else {
                        break;
                    }
                }
                if (halfLength > halfLengthForSearch) {
                    halfLengthForSearch = halfLength;
                    maxCenter = pointer;
                }
            }
            pointer++;
        }
        //偶回文以最长奇回文起步再写一遍
        pointer = halfLengthForSearch;
        while (pointer < cs.length) {
            if (cs.length - pointer < halfLengthForSearch) {
                break;
            }
            if (cs[pointer - halfLengthForSearch] == cs[pointer + halfLengthForSearch - 1]) {
                int halfLength = 1;
                while (pointer - halfLength >= 0 && pointer + halfLength <= cs.length) {
                    if (cs[pointer - halfLength] == cs[pointer + halfLength - 1]) {
                        halfLength++;
                    } else {
                        break;
                    }
                }
                if (halfLength > halfLengthForSearch) {
                    halfLengthForSearch = halfLength;
                    maxCenter = pointer;
                    odd = false;
                }
            }
            pointer++;
        }
        if (odd) {
            return s.substring(maxCenter - halfLengthForSearch + 1, maxCenter + halfLengthForSearch);
        } else {
            return s.substring(maxCenter - halfLengthForSearch + 1, maxCenter + halfLengthForSearch - 1);
        }
    }
}
