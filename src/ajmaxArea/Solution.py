class Solution(object):
    def maxArea(self,height):
        """
            :type height: List[int]
            :rtype: int
            """
        if len(height) == 0 or len(height) == 1:
            return 0
        retMax = 0
        start = 0
        end = len(height) -1
        while start< end:
            retMax = max(retMax,(end-start)*min(height[start],height[end]))
            if height[start] < height[end]:
                start += 1
            else:
                end -= 1
        return retMax

