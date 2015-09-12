package adfindMedianSortedArrays;

public class Solution{
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int length1 = nums1.length;
        int length2 = nums2.length;
        if((length1 + length2)%2 == 0){
            double ret1 = (double)findMedianSortedArrays(nums1, 0, length1, nums2, 0, length2, (length1+length2)/2);
            double ret2 = (double)findMedianSortedArrays(nums1, 0, length1, nums2, 0, length2, (length1+length2)/2+1);
            return (ret1 + ret2)/2;
        }else{
            return (double)findMedianSortedArrays(nums1, 0, length1, nums2, 0, length2, (length1+length2+1)/2);
        }
    }
    public double findMedianSortedArrays(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1 - start1;
        int len2 = end2 - start2;
        if(len1<=0){
            return nums2[start2+k-1];
        }
        if(len2<=0){
            return nums1[start1+k-1];
        }
        if(k==1){
            return nums1[start1]<nums2[start2]?nums1[start1]:nums2[start2];
        }
        int mid1 = (start1 + end1)/2;
        int mid2 = (start2 + end2)/2;
        
        if(nums1[mid1]<=nums2[mid2]){
        	 if(len1/2 + len2/2 + 1>=k){
                 return findMedianSortedArrays(nums1,start1,end1,nums2,start2,mid2,k);
             }else{
                 return findMedianSortedArrays(nums1,mid1+1,end1,nums2,start2,end2,k-len1/2-1);
             } 
        }else{
            if(len1/2 + len2/2 + 1>=k){
                return findMedianSortedArrays(nums1,start1,mid1,nums2,start2,end2,k);
            }else{
                return findMedianSortedArrays(nums1,start1,end1,nums2,mid2+1,end2,k-len2/2-1);
            }
        }
    }
    
    public static void main(String[] args){
    	int[] nums1 = {1,2,2};
    	int[] nums2 = {1,2,3};
    	Solution test= new Solution();
    	test.findMedianSortedArrays(nums1, nums2);
    }
}