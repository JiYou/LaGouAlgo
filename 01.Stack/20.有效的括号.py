#
# @lc app=leetcode.cn id=20 lang=python
#
# [20] 有效的括号
#

# @lc code=start


class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if not s or len(s) == 0:
            return True

        if len(s) % 2 == 1:
            return False

        t = []

        for c in s:
            if c == '[' or c == '{' or c == '(':
                t.append(c)
            elif c == ']':
                last = t.pop() if t else '#'
                if last != '[':
                    return False
            elif c == '}':
                last = t.pop() if t else '#'
                if last != '{':
                    return False
            elif c == ')':
                last = t.pop() if t else '#'
                if last != '(':
                    return False
            else:
                return False

        return not t

# @lc code=end
