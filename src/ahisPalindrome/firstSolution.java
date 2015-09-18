package ahisPalindrome;

public class firstSolution {
	
	// Trying to figure out a way to simplify the code.
	// The specification on Leetcode is vague, not sure what
	// 'extra space' means.
	// 
	/*
	 *  One interesting thing is that, when you pass something 
	 *  like 010 as input (type int),
	 *  java will recognize it as Octal format
	 *  and automatically convert it to 8.
	 *  This problem doesn't exist in Leetcode, however, for a probable
	 *  reason that the web page takes the input as String and   
	 *  converts the string to integer somewhere.
	 *  
	 */
 
    public boolean isPalindrome(int x) {
    	if(x < 0){	      // Negative numbers are not palindromes,
    		return false;  // because the negation operator doesn't make sense on the right. 
    	}
        int digit = 0; // This is the actual digit - 1, for the sake of computing.
        int tmp = x;
        while(tmp/10 >0 ) {
            tmp /= 10;
            digit ++;
        }
        if(tmp == 10){  // 10 seems to be a special case here.
        	return false;
        }
        return checkPalindrome(x,digit);
    }
    
    public boolean checkPalindrome(int x, int digit){
        if (digit == 0){  // Only 1 digit left, which makes it an odd digit palindrome.
            return true;
        }if(digit == 1){  // 2 digits left, which means it may be an even digit palindrome.
            return x/10 == x%10? true:false; 
        }
        int right = x%10;
        int leftDigit= (int)Math.pow(10, digit);
        int left = x/leftDigit;
        if(left == right){
            x = x - x/leftDigit*leftDigit; // Remove the left digit
            x /= 10;	//remove the right digit
            digit = digit - 2;
            return checkPalindrome(x,digit);
        }else{
            return false;
        }
    }
}
