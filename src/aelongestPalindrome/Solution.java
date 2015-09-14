package aelongestPalindrome;
/*
 This works but it will exceed time limit on leetcode, even though its time complexity is O(n^2). 
 Gotta figure out a way to improve it.
 */

public class Solution{
    public String longestPalindrome(String S){
        int length = S.length();
        if(length == 0 || length == 1 || length == 2){
            return S;
        }
        String retStr = "";
        for(int n = 0; n<length; n++){
        	String temp = "";
        	temp = checkPalindrome(S,n-1,n+1);
        	if(temp.length()>retStr.length()){
                retStr = temp;
            }
            temp = checkPalindrome(S,n,n+1);
            if(temp.length()>retStr.length()){
                retStr = temp;
            }
        }
        return retStr;
    }
    
    public String checkPalindrome(String S,int left, int right){
        while(left >= 0 && right <= S.length()-1 && S.charAt(left) == S.charAt(right)){
        	left --;
        	right ++;
        }
        return S.substring(left+1, right);
    }
    
    static public void main(String[] args){
    	Solution test = new Solution();
    	System.out.println(test.longestPalindrome("ccc"));
    }
}