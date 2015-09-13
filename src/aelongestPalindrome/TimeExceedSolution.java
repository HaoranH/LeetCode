package aelongestPalindrome;
/*
 This works but it will exceed time limit on leetcode, even though its time complexity is O(n^2). 
 Gotta figure out a way to improve it.
 */

public class TimeExceedSolution{
    public String longestPalindrome(String S){
        int length = S.length();
        if(length == 1 || length == 2){
            return S;
        }
        String retStr = "";
        for(int n = 1; n<length-1; n++){
            String temp = "";
            if(S.charAt(n-1) == S.charAt(n+1)){
                temp = S.substring(n-1,n+1);
                temp = checkPalindrome(S,n-1,n+1,temp);
            }else if( S.charAt(n) == S.charAt(n+1)){
                temp = S.substring(n,n+1);
                temp = checkPalindrome(S,n,n+1,temp);
            }
            if(temp.length()>retStr.length()){
                retStr = temp;
            }
        }
        return retStr;
    }
    
    public String checkPalindrome(String S,int left, int right, String temp){
        if(left <= 0 || right >= S.length()-1){
            return temp;
        }
        if(S.charAt(left-1) == S.charAt(right+1)){
            temp = S.substring(left-1, right+1);
            return checkPalindrome(S,left-1,right+1,temp);
        }else{
            return temp;
        }
    }
}