package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 回文数 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        List<Integer> array = new ArrayList<>();
        while (x > 0) {
            int a = x % 10;
            array.add(a);
            x = x / 10;
        }
        for (int i = 0; i < array.size(); i++) {
            if(!array.get(i).equals(array.get(array.size() - 1 - i))){
                return false;
            }
        }
        return true;
    }
}
