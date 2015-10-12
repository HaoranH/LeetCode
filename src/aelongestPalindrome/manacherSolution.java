package aelongestPalindrome;
//

public class manacherSolution {
	public String longestPalindrome(String s){
		int len = s.length();
		if(len == 0||len == 1||len == 2){
			return s;
		}
		
		StringBuilder T = new StringBuilder("#");
		T.append(s.charAt(0));
		for(int i = 1; i < len; i++){
			 T.append('#');
			 T.append(s.charAt(i));
		}
		T.append('#');
		
		int[] P = new int[T.length()];
		
		int R = 1;
		int C = 1;
		int max = 0;
		String retStr = "";
		for(int i = 1; i < T.length() -1; i++){
			int mirror = 2*C - R;
			P[i] = Math.min(R-i,P[mirror]);
			while(i-1-P[i] >= 0 && i + 1 + P[i] < T.length() && (T.charAt(i - 1 - P[i]) == T.charAt(i + 1 + P[i]))){
				P[i] ++;
			}
			if(P[i] > max){
				max = P[i];
				retStr = s.substring((i-P[i])/2,(i+P[i]+1)/2);
			}
			if(i+P[i] > R){
				C = i;
				R = i + P[i];
			}
			
		}
		return retStr;
	}
}