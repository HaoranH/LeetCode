package ahisPalindrome;

public class Solution {
	public boolean isPalindrome(int x){
		if (x<0) return false;
		int digit = 1;         // So counting how many digits is unnecessary. Knowing how many 0s after 1 is the 
		while(x/digit >= 10){  // most straightforward way.
			digit *= 10;
		}
		while (x != 0){            // No need to consider how many digits left neither,
			int left = x / digit;  // in a way that as long as left equals right it's ok
			int right = x % 10;
			if (left != right) return false;
			x = (x%digit)/10;
			digit /= 100;
		}
		return true;
	}
}
