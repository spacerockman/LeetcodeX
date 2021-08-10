代码
```
class Solution {
    public void setZeroes(int[][] matrix) {
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
           return;
       }

       // 第一步标记第一行和第一列, 设置matrix长度和二维数组的长度，等待遍历用
       boolean firstRowZero = false;
       boolean  firstColZero = false;
       int m = matrix.length;
       int n = matrix[0].length;

       // 先循环判断第一行
        for (int j = 0; j < n; j++){
            if (matrix[0][j] == 0){
                firstRowZero = true;
                break;
            }
        }
        // 循环判断第一列是否存在0
        for (int i = 0; i < m; i++){
            if (matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }

       // 除去第一行和第一列判断是否存在0；
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                // 如果存在matrix[i][j] == 0，则对应的第一行的和第一列中相关的元素也变成0
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
       // 判断第一行和第一列是否存在0,存在的话对应的行和列都变为0。
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        // 根据flag把对应的元素变成0
        if (firstRowZero){
            for (int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }

        if (firstColZero){
            for (int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
```


方法解释：

```
1. 把第一行，和第一列 标记；
    boolean firstRowZero = false;
    boolean firstColZero = false;
2. 分别循环第一行，和第一列，判断是否存在0，如果存在就标记为存在，并且跳出循环
    for(){
        firstRowZero = true;
        break;
    }
    for()

3. for遍历除去第一行和第一列的元素 （i，j=1），如果存在matrix[i][j] == 0，就把对应的行和列都变成0；
    for(){
        if(matrix[i][j] == 0){
            matrix[0][j] = 0;
            martix[i][0] = 0;
        }else if(matrix[0][j] = 0)
    }
4. for遍历判断第一行和第一列是否存在0；(i,j = 1 除了matrix[0][0]以外),如果存在则对应的第一行和第一列以外的行列变成0；
    for(){
        if(matrix[i][0] == 0 || matrix[0][j] == 0){
            martix[i][j] = 0;
        }    
    }

5. 如果firstRowZero 或者 firstColZero == true，则把对应的第一行或者第一列都变成0；
if(firstRowZero){
    for (int j = 0; j < 0; j++){
        matrix[0][j] = 0;
    }
}
if(firstColZero){
    for (int i = 0; i < 0; i++){
        matrix[i][0] = 0;
    }
}
```
