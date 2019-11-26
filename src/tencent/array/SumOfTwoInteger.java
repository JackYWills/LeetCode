/**
 * 
 */
package tencent.array;

import java.util.Arrays;

/**
 * @author JackYan
 *
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length && nums[i]<=target;i++){
        	for(int j=i+1;j<nums.length && nums[j]<=target;j++){
        		if(nums[i]+nums[j]==target){
        			result[0]=i;
        			result[1]=j;
        			return result;
        		}
        	}
        }
        return result;
    }
}

public class SumOfTwoInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] re =solution.twoSum(new int[]{9, 7, 11, 15},9);
		System.out.println(re[0]);
		System.out.println(re[1]);
	}

	
}
