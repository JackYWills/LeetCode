package interview.before;

/**
 * @Title: LeetCode
 * @ClassName: MergeSortedArray
 * @Description:
 * 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * @Author: yanwenjie
 * @Date2019/11/28 8:35
 * @Version V1.0
 **/
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={1,5,6};
        MergeSortedArray ms = new MergeSortedArray();
        ms.merge(nums1,3,nums2,3);
    }
    // Soltion:两个数组”有效部分“倒序比较，大者倒序存入nums1末尾
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1 = m-1,l2=n-1,len = m+n-1;
        while(l2>=0){
            nums1[len--]= (l1>=0 &&nums1[l1]>nums2[l2] )?nums1[l1--]:nums2[l2--];
        }
    }
}
