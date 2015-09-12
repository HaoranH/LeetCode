class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[]}
    def twoSum(self, nums, target):
        indDic = {}
        diffDic = {}
        for i in range(len(nums)):
            diff = target - nums[i]
                if nums[i] in diffDic:
                    ind1 = indDic[diff] +1
                        ind2 = i + 1
                        return ind1, ind2
                indDic[nums[i]] = i
            diffDic[diff] = nums[i]

