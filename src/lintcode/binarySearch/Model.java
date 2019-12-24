package lintcode.binarySearch;

/**
 * @Description:
 * @Author: JackYan
 * @Date2019/12/23 17:59
 * @Version V1.0
 **/
public class Model {
    public int binarySearch(int[] nums,int target){
        if(nums == null || nums.length==0){
            return -1;
        }
        int start=0,end=nums.length-1;
        // 相邻就退出，避免死循环
        while(start+1<end){
            // 防止溢出
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                end = mid;
            } else if(nums[mid] < target){
                start = mid;
            } else{
                end = mid;
            }
        }
        if(nums[start]==target){
            return start;
        }
        if(nums[end]==target){
            return end;
        }
        return -1;
    }
}