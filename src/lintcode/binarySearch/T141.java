package lintcode.binarySearch;

/**
 * @Description:x的平方根
 * 实现 int sqrt(int x) 函数，计算并返回 x 的平方根。
 * @Author: JackYan
 * @Date2019/12/24 13:39
 * @Version V1.0
 **/
public class T141 {
    public int sqrt(int x) {
        if (x < 0)  throw new IllegalArgumentException();
        else if (x <= 1)    return x;
        int start = 1, end = x;
        // 直接对答案可能存在的区间进行二分 => 二分答案
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // writing in this way instead of "nums[mid] * nums[mid]" to avoid overflow
            if (mid == x / mid)  return mid;
                // possible root must be larger than or equal to current mid
            else if (mid < x / mid) start = mid;
                // possible root must be smaller than or equal to current mid
            else    end = mid;
        }
        if (end > x / end)  return start;
        return end;
    }
    public static void main(String[] args) {
        T141 t = new T141();
        System.out.println(t.sqrt(3));
    }
}
/**
 *样例 1:
 * 	输入:  0
 * 	输出: 0
 *
 *
 * 样例 2:
 * 	输入: 3
 * 	输出: 1
 *
 * 	样例解释：
 * 	返回对x开根号后向下取整的结果。
 *
 * 样例 3:
 * 	输入: 4
 * 	输出: 2
 **/