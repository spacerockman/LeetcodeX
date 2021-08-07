
```class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return intervals;
        }
        // 合并后我们也不知道到底有多少个数组，所以用ArrayList这个可变的
        List<int[]> res = new ArraysList<>();
        // 给二维数组内的数组排序，因为一开始并不是排好序的，我们只能从小到大看，我们没法操作，无法比较
        // 因为是二维数组，所以要用Arrays.sort()
        // a,b 代表其中两个元素,a(0) - b(0)表示用a的数组第一个，减去b数组第一个，以这个为标准进行排序
        // a(0) - b(0)就是代表从小到大，如果是b(0) - a(0)就是从大到小
        Arrays.sort(intervals, (a, b) -> (a(0) - b(0)) );//排序完成复杂度就是nlog(n),（）内的n就是intervals的长度

        int [] curr = intervals[0];
        // 通过循环，两两比较
        // 先记录初始的第一个数组，从二维数组的第一个开始。
        // 注意：这里已经不需要比较每个数组的0号位了，为一开始的排序就已经排序好了
        // 原理1：如果interval的0号位小于，current的1号位（end），就说明有重合
        // 处理：找到一个最大的值更新curr[1] ↓↓
        // curr[1] = Math.max(curr[1], intervals[i][1]);
        // 原理2：如果如果interval的0号位大于，current的1号位（end），就说明没有重合
        // 处理: 这说明已经合并好了or不需要合并，把curr直接添加到结果集↓↓
        // res.add(curr);

        // 退出循环后，还需要再添加一次值进res集，因为最后一个还没加去进集合,原因是最后一个数组后面是空了无法继续比较了。
        // res.add(curr);

        // 最后，题目要求返回一个二维数组，需要用个toArray()方法，把ArrayList转换成数组↓↓
        // return res.toArray(new int[res.size()][2]);
        
            }
}
```
完整代码
```
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return intervals;
        }
        // 从小到大排序
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        //初始化可变结果list
        List<int[]> res = new ArrayList<>();
        //创建curr，准备两两比较
        int[] curr = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(curr[1] < intervals[i][0]){
                res.add(curr);
                curr = intervals[i];
            }else{
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
        }
        res.add(curr);
        return res.toArray(new int[res.size()][2]);
    }
}
```
