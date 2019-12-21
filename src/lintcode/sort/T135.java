package lintcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Title: LeetCode
 * @ClassName: Tx
 * @Description:
 * @Author: yanwenjie
 * @Date2019/12/20 12:53
 * @Version V1.0
 **/
public class T135 {
    public static void main(String[] args) {
        T135 t = new T135();
        t.combinationSum(new int[]{2,2,2,2,2,3,6,7},7);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        int[] nums = removeDuplicates(candidates);
        dfs(result,list,candidates,0,target);

        return result;
    }

    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }
        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }
        return nums;
    }

    private void dfs(List<List<Integer>> result,List<Integer> list,int[] candidates,int pos,int target){
        Arrays.sort(candidates);
        if(target==0){
            result.add(new ArrayList(list));
            Collections.sort(list);
            return;
        }
        for(int i=pos;i<candidates.length;i++){
            if (target < candidates[i]) {
                break;
            }
            list.add(candidates[i]);
            dfs(result,list,candidates,i,target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
/*    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> rResult = new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(result,list,candidates);
        for(List<Integer> subList:result){
            Integer sum = 0;
            for(Integer v:subList){
                sum +=v;
            }
            if(sum==target){
                rResult.add(subList);
            }
        }
        return rResult;
    }

    private void dfs(List<List<Integer>> result,List<Integer> list,int[] candidates){
        result.add(new ArrayList(list));
        for(int i=0;i<candidates.length;i++){
            list.add(candidates[i]);
            dfs(result,list,candidates);
            list.remove(list.size());
        }
    }*/
}
