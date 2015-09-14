package aelongestPalindrome;

public class Solution{
    public String longestPalindrome(String S){
        int length = S.length();
        /*
         According to the question description, there will only one unique palindrome for each input.
         So when the length is 2, the string should have two same characters hence the palindrome.
         */
        if(length == 0 || length == 1 || length == 2){
            return S;
        }
        String retStr = "";
        for(int n = 0; n<length; n++){
        	String temp = "";
        	// I tried to figure out a way to avoid calling ckeckPalindrome twice for different situations
        	// but it seemed that any additional conditional statement would cause extra increase of complexity
        	// such as boundary conditions.
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
        // When returning, the value of current variable 'left' and 'right' no longer fit for the 
        // condition, so we have to return their previous value.
        return S.substring(left+1, right); // 'substring' excludes right value.
    }
    
}