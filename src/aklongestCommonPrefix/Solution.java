package aklongestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
		if (strs.length == 1){
			return strs[0];
		}
		if (strs[0].length() == 0){
			return "";
		}else{
			for (int i = 0; i < strs.length-1; i++){
				int pointer = 0;
				int len = Math.min(strs[i].length(),strs[i+1].length());
				while(pointer < len&&strs[i].charAt(pointer)==strs[i+1].charAt(pointer)){
					pointer++;
				}
				strs[i+1] = strs[i+1].substring(0, pointer);
			}
			return strs[strs.length-1];
		}
	}
}