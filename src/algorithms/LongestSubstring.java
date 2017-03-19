package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * <h>Longest Substring Without Repeating Characters</h>
 * <p>Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * <pre>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 */

public class LongestSubstring {
    // 滑移窗口，寻找不包含重复字符的最长子串的长度
    public int longestSubstring(String s) {
        if (s == null || s.equals("")) return 0;

        char[] cs = s.toCharArray();
        int max = 1,//记录最长长度
                head = 0,//窗口左边界
                pointer = 1,//遍历到的当前位置，窗口右边界，与 head 共同指示窗口区间
                tmp;//探查重复字符出现的位置

        for (; pointer < cs.length; pointer++) {
            // 从窗口左边界 head 向右查找，与右边界重复的字符的位置
            tmp = s.indexOf(cs[pointer], head);

            /* 两种必然情况
             * 1.右边界与右边界自身重复（窗口范围内无重复字母）
             * 2.窗口左边界与右边界之间存在与右边界重复的字符（窗口范围内存在重复字母）
             */
            if (tmp != pointer) { //情况 2
                // 取较大者：历史最大窗口 & 当前窗口
                max = Math.max(max, pointer - head);
                head = tmp + 1; // 左边界滑移到重复字母后面一位

                // 剩下的长度不比历史最大长度大，没必要继续搜索
                if (cs.length - head <= max) return max;
            }
            // else 情况 1 ： 滑移右边界，探查新范围
            // for loop pointer++
        }
        // 剩下的长度比 max 大，全程扫描为情况 1
        // 扫描完退出循环，返回此时的窗口大小
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