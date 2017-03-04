package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 * <p>
 * <p>Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * <pre>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 */
public class LongestSubstring {
    public int longestSubstring(String s) {
        char[] cs = s.toCharArray();
        int max = 0, head = 0, pointer = 0, tmp = 0;

        for (; pointer < cs.length; pointer++) {
            tmp = s.indexOf(cs[pointer], head);
            if (tmp != pointer) {
                max = Math.max(max, pointer - head);
                head = tmp + 1;
                if (cs.length - head <= max) return max;
            }
        }
        return pointer - head;
    }

    public int Longest(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        //使用 HashMap 耗时并没有减少

        int max = 0, head = 0, pointer = 0;
        for (; pointer < cs.length; pointer++) {
            if (map.containsKey(cs[pointer]) && map.get(cs[pointer]) >= head) {
                max = Math.max(max, pointer - head);
                head = map.get(cs[pointer]) + 1;
                if (cs.length - head <= max) return max;
            }
            map.put(cs[pointer], pointer);
        }
        return pointer - head;
    }
}