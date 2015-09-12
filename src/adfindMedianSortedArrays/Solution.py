class Solution(object):
    
    def subfindMedianSortedArrays(self, nums1, start1, end1, nums2, start2, end2, k):
        """
        :type start1: int
        :type start2: int
        :type end1: int
        :type end2: int
        :type k: int
        :rtype: float
        """
        len1 = end1 - start1
        len2 = end2 - start2
        if len1 <= 0:
            return nums2[start2 + k - 1]
        if len2 <= 0:
            return nums1[start1 + k - 1]
        if k == 1:
            return min(nums1[start1], nums2[start2])
        mid1 = (end1+start1)/2
        mid2 = (end2+start2)/2
        if nums1[mid1] >= nums2[mid2]:
            if (len1/2 + len2/2 + 1) >= k:
                return self.subfindMedianSortedArrays(nums1,start1,mid1,nums2,start2,end2,k)
            else:
                return self.subfindMedianSortedArrays(nums1,start1,end1,nums2,mid2+1,end2,k-len2/2-1)
        else:
            if (len1/2 + len2/2 + 1) >= k:
                return self.subfindMedianSortedArrays(nums1,start1,end1,nums2,start2,mid2,k)
            else:
                return self.subfindMedianSortedArrays(nums1,mid1+1,end1,nums2,start2,end2,k-len1/2-1)
                
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        length1 = len(nums1)
        length2 = len(nums2)
        if (length1 + length2) %2 == 0:
            retVal1 = self.subfindMedianSortedArrays(nums1, 0, length1, nums2, 0, length2, (length1 + length2)/2)
            retVal2 = self.subfindMedianSortedArrays(nums1, 0, length1, nums2, 0, length2, (length1 + length2)/2+1)
            return float((retVal1 + retVal2)/2)
        else:
            return self.subfindMedianSortedArrays(nums1, 0, length1, nums2, 0, length2, (length1 + length2 + 1)/2)
    

test = Solution()

print test.findMedianSortedArrays([1,1],[1,2])