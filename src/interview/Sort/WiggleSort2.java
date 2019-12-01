package interview.Sort;

import java.util.Arrays;

/**
 * @Title: LeetCode
 * @ClassName: WiggleSort2
 * @Description:
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 示例 1:
 *
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 *
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 *
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * @Author: yanwenjie
 * @Date2019/12/1 11:06
 * @Version V1.0
 **/
public class WiggleSort2 {
    public static void main(String[] args) {
        int[] in = {0,1,2,3,4,5,6};
        WiggleSort2 ws = new WiggleSort2();
        ws.wiggleSort(in);
        for(int j=0;j<in.length;j++){
            System.out.println(in[j]+"; ");
        }
    }
    public void wiggleSort(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int k = (nums.length+1)/2;
        int j = nums.length;
        for(int i=0;i<nums.length;i++){
            nums[i] = i%2==1?temp[--j]:temp[--k];
        }
    }
    /*
    思路：这道题先对数组进行排序，然后把数组一分为二，分为左半部分left和右半部分right，每次取左半部分的最右边的元素和右半部分最右边的元素组成一队，然后一直到结束。解法很简单，但是问题来了，为什么必须取左右部分最右的元素呢，按道理说左半部分的元素都应该比右半部分小，所以随便取就行了，但是这样是不对的，我们注意数组不是严格递增的，可能会出现等于的情况，而一旦等于的情况跨越左右半边，其他的情况就不行了。比如：4,5,5,6。

其他情况包括：

A：取左半部分最左边和右半部分最左边     4,5     5,6

B：取左半部分最右边和右半部分最左边     5,5     4,6

C：取左半部分最左边和右半部分最右边     4,6     5,5

D：取左半部分最右边和右半部分最右边     5,6     4,5

只有第四种情况满足题意，因为提议要求：A<B>C<D，前三种情况都会出现C不能小于B（可能会有等于的情况出现）的情况，具体大家分析下情况就知道了，只有第四种严格满足要求。
————————————————
版权声明：本文为CSDN博主「麦田里的哈士奇」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_26410101/article/details/82461717
     */
}
