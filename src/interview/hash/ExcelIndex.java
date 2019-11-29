package interview.hash;

/**
 * @Title: LeetCode
 * @ClassName: ExcelIndex
 * @Description:
 * Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 * @Author: yanwenjie
 * @Date2019/11/29 10:57
 * @Version V1.0
 **/
public class ExcelIndex {

    public static void main(String[] args) {
        ExcelIndex ei = new ExcelIndex();
        System.out.println(ei.titleToNumber("ABB"));
    }

    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result *= 26;
            result += s.charAt(i) - 'A' + 1;
        }
        return result;
    }
}
