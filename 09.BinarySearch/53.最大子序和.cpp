/*
 * @lc app=leetcode.cn id=53 lang=cpp
 *
 * [53] 最大子序和
 */

#include <vector>
using namespace std;

// @lc code=start
class Solution {
   public:
    int maxSubArray(vector<int>& A) {
        const int N = A.size();
        int64_t pre_min_value = 0;
        int64_t cur_value = 0;
        int64_t pre_sum = 0;
        int64_t ans = INT_MIN;
        for (int i = 0; i < N; i++) {
            pre_sum += A[i];
            cur_value = pre_sum;
            ans = max(cur_value - pre_min_value, ans);
            pre_min_value = min(pre_min_value, cur_value);
        }
        return ans;
    }
};
// @lc code=end
