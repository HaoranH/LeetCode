package aelongestPalindrome;
import java.util.Arrays;
/*
So this solution is the easiest, in a way that it decides whether a sub string is palindrome from both of its ends
so you don't have to consider the middle. Its complexity, however, is O(n^3), which is too high and does not meet 
the time limit of Leetcode.
*/
public class NoBrainerSolution {
    public String longestPalindrome(String s) {
        char[] strArray = s.toCharArray();
        int length = strArray.length;
        if (length == 1 || length == 2){
            return s;
        }
        char[] retVal = new char[0];
        int subLen = 0;
        for (int n = 0; n < length; n++){   // each char from the left
            for(int m = length; m>n; m--){ // each char from the right
                char[] subArr = Arrays.copyOfRange(strArray,n,m);
                int lenPal = decidePalindrome(subArr,0);
                if(lenPal > subLen){ // when current sub string is palindrome whose length is larger than largest
                    retVal = subArr;
                    subLen = lenPal;
                }
            }
        }
        String strRet = new String(retVal);
        return strRet;
    }
    
    public int decidePalindrome(char[] subArr, int lenPal){
        int len = subArr.length;
        if (len <= 1){
            return lenPal;
        }
        if(subArr[0] == subArr[len-1]){
            lenPal ++;
            char[] subsubArr = Arrays.copyOfRange(subArr,1,len-1);
            return decidePalindrome(subsubArr,lenPal);
        }else{
            return -1;
        }
    }
}  