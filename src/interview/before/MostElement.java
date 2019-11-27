package interview.before;

import java.util.Arrays;

/**
 * @Title: LeetCode
 * @ClassName: MostElement
 * @Description:
 *
 *  多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @Author: yanwenjie
 * @Date2019/11/27 8:46
 * @Version V1.0
 **/
public class MostElement {

    public static void main(String[] args) {
        int[] in = {2,2,1,1,1,2,2};
        MostElement me = new MostElement();
        System.out.println(me.majorityElement(in));
    }

    //solution:Most value must be the middle number of the sorted array
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
