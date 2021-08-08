### 思路
1. 旋转90°，就是头行和尾行互换，再对角线的元素互换


Java 代码
```
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        // corner case
        if (matrix == null || matrix.length == 0) return;

        // ①上下互换
            // 标记头一个和最后一个数组的坐标位置
        int top = 0;
        int bottom = matrix.length - 1;
        while(top < bottom){
            int[] temp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;
            top++;
            bottom--;
        }

        // 对角线互换
        for (int i = 0; i < matrix.length; i++){
            // 注意：这里是j+1，从图形来看，只交换了一半的元素。
            for (int j = i + 1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
```
