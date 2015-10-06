package ajmaxArea;

public class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        if(length == 0 || length == 1){
            return 0;
        }
        int start = 0;
        int end = length -1;
        int max = 0;
        while(start < end){
            max = Math.max(max,(end - start)*Math.min(height[start],height[end]));
            // Only the change from the shorter side would affect the volume of the container. 
            if(height[start] > height[end]){
                end --;
            }else{
                start++;
            }
        }
        return max;
    }
}