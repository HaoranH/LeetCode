package aiisMatch;

public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        return isMatch(s,0,sLen,p,0,pLen);
    }
    
    public boolean isMatch(String s, int sSt, int sLen, String p, int pSt, int pLen){
        if(pSt == pLen){
        	return (sSt == sLen);
        }
        if(pSt == pLen -1){
        	if(sSt == sLen || (s.charAt(sSt) != p.charAt(pSt) && p.charAt(pSt) != '.')){
        		return false;
        	}else return isMatch(s,sSt+1,sLen, p, pSt+1,pLen);
        }
        if(p.charAt(pSt+1) != '*'){
        	if(sSt == sLen || s.charAt(sSt) != p.charAt(pSt) && p.charAt(pSt) != '.'){
        		return false;
        	}else return isMatch(s,sSt+1,sLen, p, pSt+1,pLen);
        }else{
        	int i = -1;
        	while(sSt+i <= sLen-1 &&(i < 0 || p.charAt(pSt) == s.charAt(sSt+i)||p.charAt(pSt) == '.')){
        		if (isMatch(s,sSt+i+1,sLen,p,pSt+2,pLen)) return true;
        		i ++;
        	}
        	return false;
        }
    }
    
    static public void main(String[] args){
    	Solution test = new Solution();
    	System.out.println(test.isMatch("aab","c*a*b"));
    	System.out.println(test.isMatch("abcd","d*"));
    	System.out.println(test.isMatch("ab",".*c"));
    	System.out.println(test.isMatch("a",".*..a*"));
    	System.out.println(test.isMatch("ab",".*.."));
    	System.out.println(test.isMatch("","bab"));
    	System.out.println(test.isMatch("aaa","aaaa"));
    	System.out.println(test.isMatch("aa","a*"));
    }
}
