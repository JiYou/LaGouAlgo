/*
 *
 * [1696] 跳跃游戏 VI
 *
 * https://leetcode-cn.com/problems/jump-game-vi/description/
 *
 * algorithms
 * Medium (33.27%)
 * Likes:    18
 * Dislikes: 0
 * Total Accepted:    2.5K
 * Total Submissions: 7.4K
 * Testcase Example:  '[1,-1,-2,4,-7,3]\n2'
 *
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 *
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i
 * + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
 *
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的
 * 得分 为经过的所有数字之和。
 *
 * 请你返回你能得到的 最大得分 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums = [1,-1,-2,4,-7,3], k = 2
 * 输出：7
 * 解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
 *
 *
 * 示例 2：
 *
 *
 * 输入：nums = [10,-5,-2,4,0,3], k = 3
 * 输出：17
 * 解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
 *
 *
 * 示例 3：
 *
 *
 * 输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * 输出：0
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1
 * -10^4 
 *
 *
 */

#include <deque>
#include <vector>

using namespace std;

class Solution {
   public:
    int maxResult(vector<int> &A, int k) {
        const int N = A.size();
        // pair.first表示走到i位置最多收集的金币
        // pair.second表示下标i
        // Q是一个严格单调递减的队列
        deque<pair<int, int>> Q;

        // 走到i位置时，最大的金币收益
        int ans = 0;

        for (int i = 0; i < N; i++) {
            // 出队！
            // 对于i而言，
            // [i-k, i-1]可以跳到A[i]
            // 最远i - (i - k) = k
            // 因此超出这个范围的，必须要出队
            while (!Q.empty() && i - Q.front().second > k) {
                Q.pop_front();
            }

            // 获得在位置i时的收益
            if (!Q.empty()) {
                ans = Q.front().first + A[i];
            } else {
                ans = A[i];
            }

            // 入队，当A[i]入队的时候，要把小于等于他的那些
            // 收益比他低，又比他旧的给踢除掉
            // 注意！这里使用的是严格的单调递减!
            while (!Q.empty() && Q.back().first <= ans) {
                Q.pop_back();
            }
            // 入队!
            Q.emplace_back(ans, i);
        }
        return ans;
    }
};
