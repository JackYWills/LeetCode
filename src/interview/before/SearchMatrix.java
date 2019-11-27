package interview.before;
/**
 * @Description:
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * @Author: yanwenjie
 * @Date2019/11/27 8:56
 * @Version V1.0
 **/
public class SearchMatrix {
    public static void main(String[] args){
        int[][] in = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        SearchMatrix sm = new SearchMatrix();
        System.out.println(sm.searchMatrix(in,17));
    }

    // Solution: 第一列最后一个元素X：
    // ①等于
    // ②目标小于X：搜索范围缩小至1至4行
    // ③目标大于X：搜索范围缩小至2至5列
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int x = matrix.length-1,y = 0;while(x >= 0&& y < matrix[0].length){
            if(matrix[x][y] > target) {
                --x;
            } else if(matrix[x][y] < target) {
                ++y;
            } else {
                return true; //当前数就是要找的数
            }
        }
        return false;
    }
/*        if(null==matrix || matrix.length<0) {
            return false;
        }
        int line = matrix[0].length-1;
        int column = 0;
        int x = matrix[column][0];
        //System.out.println("X="+x);
        while(line>0 && column>0){
            if(target==matrix[column][0]){
                return true;
            } else if (target<matrix[line][column]){
                --line;
            }else if (target>matrix[line][column]){
                --column;
            }
        }
        return false;
        */
}
