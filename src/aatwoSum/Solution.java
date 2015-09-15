package aatwoSum;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexDic = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> diffDic = new HashMap<Integer, Integer>();
        int[] retVal = new int[2];
        for (int i=0; i<nums.length;i++){
            int diff = target - nums[i];
            if (diffDic.containsKey(nums[i])){
                int index2 = i + 1;
                int index1 = indexDic.get(diff) + 1;
                retVal[0] = index1;
                retVal[1] = index2;
            }
            indexDic.put(nums[i],i);
            diffDic.put(diff,nums[i]);
        }
        return retVal;
    }
}