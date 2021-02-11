# https://www.acwing.com/problem/content/65/
class Solution(object):
    def findEqualRange(self, A):
        if not A or len(A) == 0:
            return -1
        
        def getC(A, i):
            v = A[i]
            if v < i:
                return -1
            elif v == i:
                return 0
            else:
                return 1
        
        # find left start pos
        l = 0
        r = len(A)
        while l < r:
            m = l + ((r-l)>>1)
            mov = getC(A, m)
            if mov < 0:
                l = m + 1
            else:
                r = m
        # record left start pos
        left = l
        
        # find the right end pos
        # the range would be [left, right)
        l = left
        r = len(A)
        while l < r:
            m = l + ((r - l)>>1)
            mov = getC(A, m)
            if mov <= 0:
                l = m + 1
            else:
                r = m
        # record the right end pos
        right = l
        return [left, right]

    def getNumberSameAsIndex(self, A):
        rs = self.findEqualRange(A)
        if rs[0] == rs[1]:
            return -1
        # randomly pickup a euqal value to return.
        return A[rs[1]-1]
