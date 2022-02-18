package 数组;

/**
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 跳跃游戏 {
    public static int jump(int[] nums) {
        int step = 0;
        int currentPosition = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i] + i;// 当前能跳到什么位置
            maxPosition = Math.max(maxPosition, temp);// 选出当i<currentPosition时，最远的下标
            if (i == currentPosition) {//把i移动到最远下标
                currentPosition = maxPosition; // 把当前下标移动到能跳到的最大位置
                step++;
            }
        }
        return step;
    }
}
