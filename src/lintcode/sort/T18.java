package lintcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集。
 * 子集中的每个元素都是非降序的
 * 两个子集间的顺序是无关紧要的
 * 解集中不能包含重复子集
 **/
public class T18 {
    public static void main(String[] args) {
        T18 t = new T18();
        System.out.println(t.subsetsWithDup(new int[]{1,2,2}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subSubSet(result,new ArrayList<>(),nums,0);
        return result;
    }
    private void subSubSet(List<List<Integer>> result,List<Integer> list,int[] nums,int pos){
        result.add(new ArrayList(list));
        for(int i=pos;i<nums.length;i++){
            if(i!=pos && nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            subSubSet(result,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
/**
 * 样例 1：
 *
 * 输入：[0]
 * 输出：
 * [
 *   [],
 *   [0]
 * ]
 * 样例 2：
 *
 * 输入：[1,2,2]
 * 输出：
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
