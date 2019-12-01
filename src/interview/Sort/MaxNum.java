package interview.Sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Title: LeetCode
 * @ClassName: MaxNum
 * @Description:
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * @Author: yanwenjie
 * @Date2019/11/30 12:40
 * @Version V1.0
 **/

public class MaxNum {
    public static void main(String[] args){
        MaxNum mn = new MaxNum();
        int[] in = {3,30,34,5,9};
        System.out.println(mn.largestNumber(in));
    }
    public String largestNumber(int[] nums) {
        //转换为String[]
        String[] resultStr=new String[nums.length];
        //填充
        for (int i = 0; i < nums.length; i++) {
            resultStr[i]=String.valueOf(nums[i]);
        }
        //排序
        Arrays.sort(resultStr,new OrderRule());
        //处理都是0的情况
        if (resultStr[0].equals("0")) {
            return "0";
        }
        String numStr=new String();
        for (String s : resultStr) {
            numStr+=s;
        }
        return numStr;
    }
}
class OrderRule implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        String o1 = a + b;
        String o2 = b + a;
        return o2.compareTo(o1);
    }
}