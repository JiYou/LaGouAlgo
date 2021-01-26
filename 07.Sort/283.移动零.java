/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (63.59%)
 * Likes:    925
 * Dislikes: 0
 * Total Accepted:    301.5K
 * Total Submissions: 474.2K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] A) {
        int l = 0, i = 0;
        while (i < A.length) {
            if (A[i] != 0) {
                int t = A[l];
                A[l] = A[i];
                A[i] = t;
                i += 1;
                l += 1;
            } else {
                i++;
            }
        }
    }
}
// @lc code=end

