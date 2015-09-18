package ahisPalindrome;

/*
 *  IMO this is a better solution, in that it doesn't need consider negative number.
 *  Convert the integer to string and compare string at both ends.
 *  Update:
 *  	So, even though this solution was accepted in Leetcode, it doesn't meet the requirement
 *  	of 'Do this without extra space' in a way that restoring the string variable require space.
 *   	FYI.
 * */
public class strSolution {
	public boolean isPalindrome(int x){
		String s = String.valueOf(x);
		int length = s.length();
		for(int n = 0; n <= (length/2); n++){
			if (s.charAt(n) != s.charAt(length-n-1)){
				return false;
			}
		}
		return true;
	}
}
