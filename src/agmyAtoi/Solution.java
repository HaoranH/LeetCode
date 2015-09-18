package agmyAtoi;

public class Solution {
	public int myAtoi(String str){
		/*
		 *  So for this problem in leetcode, the specification, which should vary if found else where,
		 *  is:
		 *  0. Only numeric character should be converted into digits of the integer.
		 *  1. Whitespace will be ignored only when it's located immediately BEFORE a numeric character. 
		 *  2. '+' or '-' only makes sense when located immediately BEFORE a numeric character.
		 *  3. If not the above cases, any non-numeric character encountered would result in 
		 *  	returning the integer already converted so far, unless 4.
		 *  4. If the current converted integer is larger than 2147483647 or less than -2147483648 the INT_MAX 
		 *  or INT_MIN should be returned.
		 *  
		 *  
		 *  Above specification only works for this question under current condition only. 
		 * */
		str = str.trim(); // get rid of whitespace
        int length = str.length(); 
        if(length == 0){
            return 0;
        }
		int i = 0;
		char firChar = str.charAt(0);
		int flag = 1;
		if (firChar == '-'){
			flag = -1;
			i++;
		}else if(firChar == '+'){
			i++;
		}
		long retVal = 0; // in case of overflow, first define the type of return value as long
		for (int n = i; n < length; n++){
			if(Character.isDigit(str.charAt(n))){
				retVal = retVal*10 + Character.getNumericValue(str.charAt(n));
				if (retVal > Integer.MAX_VALUE){
					return flag == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
				}
			}else break;
		}
		return (int)retVal*flag;
    }
}
