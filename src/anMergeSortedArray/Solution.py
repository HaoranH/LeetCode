# -*- coding: utf-8 -*-
class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
            :type nums1: List[int]
            :type m: int
            :type nums2: List[int]
            :type n: int
            :rtype: void Do not return anything, modify nums1 in-place instead.
            """
        nums1[:] = nums1[:m] + nums2[:] + nums1[m+n:]
        
        for pos in range(m,m+n):
            for subPos in range(pos,-1,-1):
                if subPos == 0 or nums1[pos] > nums1[subPos-1]:
                    nums1[:] = nums1[:subPos] + [nums1[pos]] + nums1[subPos:pos] + nums1[pos+1:]
                    break
