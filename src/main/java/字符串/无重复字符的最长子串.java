package 字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例：
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class 无重复字符的最长子串 {


    public static void main(String[] args) {
        int result = length("abcabcdabcdea1234508");
        System.out.println(result);
    }

    public static int length(String s) {
        char[] array = s.toCharArray();
        Map<Character, Object> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (map.containsKey(c)) {
                result = new StringBuilder();
                map = new HashMap<>();
            }
            map.put(c,null);
            result.append(c);
            length = Math.max(length, result.length());
        }
        return length;

    }
}
