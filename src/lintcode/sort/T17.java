package lintcode.sort;

import java.util.*;

/**
 * 17、求子集
 *
 * @Date2019/12/17 21:41
 * @Version V1.0
 **/
public class T17 {
    public static void main(String[] args) {
        T17 t = new T17();
        System.out.println(t.subsets(new int[]{1,2,3,4}));
    }
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(result,list,nums,0);
        return result;
    }
    // result:完整结果；list实现回溯
    public void subsetsHelper(List<List<Integer>> result,List<Integer> list,int[] nums,int pos){
        result.add(new ArrayList<Integer>(list));
        for(int i=pos;i<nums.length;i++){
            list.add(nums[i]);
            subsetsHelper(result,list,nums,i+1);
            // 树的一条闭路搜寻完毕
            list.remove(list.size()-1);
        }
    }
}
/*
给定一个含不同整数的集合，返回其所有的子集。

样例
样例 1：

输入：[0]
输出：
[
  [],
  [0]
]
样例 2：

输入：[1,2,3]
输出：
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */