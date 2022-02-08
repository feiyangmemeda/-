package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class 三数之和 {


    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        List<List<Integer>> lists = threeSum1(nums);
        System.out.println();
    }

    /**
     * 这个是自己写的垃圾方法，时间复杂度n^3
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<String, Object> checkMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // 从大到小排序后插入
                        int a = nums[i];
                        int b = nums[j];
                        int c = nums[k];
                        String key = "";
                        if (a == b && b == c) {
                            key = key + a + b + c;
                        } else {
                            if (a > b) {
                                if (a > c) {
                                    key = key + a;
                                    key = c > b ? key + c + b : key + b + c;
                                } else {
                                    key = key + c + a + b;
                                }
                            } else {
                                if (b > c) {
                                    key = a > c ? key + b + a + c : key + b + c + a;
                                } else {
                                    key = key + c + b + a;
                                }
                            }
                        }
                        // 校验map里是不是已经有了
                        if (checkMap.containsKey(key)) {
                            continue;
                        }
                        checkMap.put(key, null);
                        List<Integer> array = new ArrayList<>();
                        array.add(a);
                        array.add(b);
                        array.add(c);
                        result.add(array);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 官方方法，双下标移动
     * 先排序，然后一个从头开始，一个从尾巴向头反向开始
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return result;
        Arrays.sort(nums);

        /**
         * 循环思路
         * 第一层
         * (-5,-5,2,3,4,5,6,7,8,8,9,9) -> (-5,2,3,4,5,6,7,8,8,9,9) -> (3,4,5,6,7,8,8,9,9)
         * 第二层
         * (left = -5,right=9)->(left=2,right=9)
         * 第三层(如果相加等于0后,还要去重,所以left、right还要移动)
         * 。。。。。。。
         */
        for (int i = 0; i < len; i++) {
            // 因为数组已经排序过,三个一组，第一个数字大于0直接会导致结果大于0
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;// 这段需要理解一下,因为这个时候循环来到第二(i+1)次,如果i的值跟上一次的值一样,那不就直接重复了吗(1,1,-1,0),所以跳过
            }
            int left = i + 1; // 左指针(从数组首位+1开始)
            int right = len - 1;// 右指针(从数组末尾开始)
            while (left < right) {// 两个指针开始往中间靠
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return result;
    }
}
