/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498] 对角线遍历
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        // 设定循环次数
        int rowCount = mat.length;
        int colCount = mat[0].length;
        int count = rowCount + colCount - 1;
        int[] result = new int[rowCount * colCount]; 

        // 设定方向
        int m = 0;
        int n = 0;
        int resultIndex = 0;
        for (int i = 0; i < count; i++){
            // 当前遍历的次序 % 2，如果是==0，就是右上，反之左下。
            if (i % 2 == 0){
                // 右上
                // 处理边界问题,在哪一边，哪一边就会超出
                while(m >= 0 & n < colCount){//范围内，添加进result
                    result[resultIndex] = mat[m][n];
                    resultIndex++;
                    m--;
                    n++;
                }
                if (n < colCount){// 范围外矫正拉回来。
                    m++;
                }else{
                    m += 2;
                    n--;
                }
            }else {
                // 左下
                while(m < rowCount && n >= 0){
                    result[resultIndex] = mat[m][n];
                    resultIndex++;
                    m++;
                    n--;
                }
                if(m < rowCount){
                    n++;
                }else{
                    m--;
                    n += 2;
                }
            }
        }
        return result;
    }
}
// @lc code=end

