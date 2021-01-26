#
# @lc app=leetcode.cn id=148 lang=python
#
# [148] 排序链表
#
# https://leetcode-cn.com/problems/sort-list/description/
#
# algorithms
# Medium (67.66%)
# Likes:    960
# Dislikes: 0
# Total Accepted:    135.1K
# Total Submissions: 199.6K
# Testcase Example:  '[4,2,1,3]'
#
# 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
# 
# 进阶：
# 
# 
# 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
# 
# 
# 
# 
# 示例 1：
# 
# 
# 输入：head = [4,2,1,3]
# 输出：[1,2,3,4]
# 
# 
# 示例 2：
# 
# 
# 输入：head = [-1,5,3,4,0]
# 输出：[-1,0,3,4,5]
# 
# 
# 示例 3：
# 
# 
# 输入：head = []
# 输出：[]
# 
# 
# 
# 
# 提示：
# 
# 
# 链表中节点的数目在范围 [0, 5 * 10^4] 内
# -10^5 
# 
# 
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        if not head or (not head.next):
            return head
        
        # 找到链表的中点
        s1 = head
        s2 = head
        pre = s1
        while s2 and s2.next:
            pre = s1
            s1 = s1.next
            s2 = s2.next.next
        
        # 把链表拆成两半
        mid = s1 if s2 else pre
        back = mid.next
        mid.next = None

        i = self.sortList(head)
        j = self.sortList(back)

        dummy = ListNode()
        tail = dummy

        while i or j:
            if not j or (i and i.val <= j.val):
                tail.next = i
                tail = i
                i = i.next
            else:
                tail.next = j
                tail = j
                j = j.next
        tail.next = None

        return dummy.next
# @lc code=end

