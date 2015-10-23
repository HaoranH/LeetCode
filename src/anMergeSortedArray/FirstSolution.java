package anMergeSortedArray;

import java.util.*;

public class FirstSolution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> tmpList = new ArrayList<Integer>();
        for(int i=0; i<m; i++){
            tmpList.add(nums1[i]);
        }
        int start = 0;
        int j = 0;
        while(j<n){
            if(start==tmpList.size()||nums2[j]<tmpList.get(start)){
                tmpList.add(start,nums2[j]);
                start++;
                j++;
            }else start++;
        }
        for(int k=0; k<tmpList.size(); k++){
            nums1[k] = tmpList.get(k);
        }
    }
}
