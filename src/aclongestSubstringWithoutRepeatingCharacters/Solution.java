package longestSubstringWithoutRepeatingCharacters;
import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        char[] charArr = s.toCharArray();
        int length = charArr.length;
        Set<Character> charSet = new HashSet<Character>();
        int maxLen = 1;
        int start = 0;
        for(int i = 0; i < length; i ++){
            char current = charArr[i];
            maxLen = Math.max(maxLen,i-start);
            if(charSet.contains(current)){
                for(int j = start; j < i; j ++ ){
                    if( charArr[j] == current){
                        start = j + 1;
                        break;
                    }
                    charSet.remove(charArr[j]);
                }
            }else{
                charSet.add(current);
            }
        }
        maxLen = Math.max(maxLen, length - start);
        return maxLen;
    }
}