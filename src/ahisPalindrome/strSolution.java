package ahisPalindrome;

/*
 *  In my opinion this is a better solution, in that it doesn't need consider negative number.
 *  Convert the integer to string and compare string at both ends. Voilà.
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
