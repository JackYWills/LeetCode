package lintcode;

/**
 * @Title: LeetCode
 * @ClassName: F56
 * @Description:
 * @Author: yanwenjie
 * @Date2019/12/15 9:35
 * @Version V1.0
 **/
public class F56 {
    public class Solution {
        /**
         * @param numbers: An array of Integer
         * @param target: target = numbers[index1] + numbers[index2]
         * @return: [index1, index2] (index1 < index2)
         */
        public int[] twoSum(int[] numbers, int target) {
            // write your code here
            int[] result=new int[2];
            for(int i=0;i<numbers.length;i++){
                for(int j =1;j<numbers.length;j++){
                    if(numbers[i]+numbers[j]==target){
                        result[0]=i;
                        result[1]=j;
                        return result;
                    }
                }
            }
            return result;
        }
    }
}
