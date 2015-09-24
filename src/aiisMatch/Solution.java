package aiisMatch;

public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        return isMatch(s,0,sLen,p,0,pLen);
    }
    
    public boolean isMatch(String s, int sSt, int sLen, String p, int pSt, int pLen){
    	/*
    	 * First condition: if p is empty, s can only be empty.
    	 * */
        if(pSt>pLen-1){  
        	return (sSt > sLen -1);
        }
        
        /*
         * This is a combination of two conditions:
         * 1. The length of p is only 1;
         * 2. The char at next position of current position is not '*'
         * For both of these situations same action can be taken.
         * If the length of s is 0, it is a false; if the next char is not '*' and current char doesn't match, it's false
         * */
        if(pSt == pLen -1 || p.charAt(pSt+1) != '*'){
        	if(sSt == sLen || (s.charAt(sSt) != p.charAt(pSt) && p.charAt(pSt) != '.')){
        		return false;
        	}else return isMatch(s,sSt+1,sLen, p, pSt+1,pLen);
        }
        
        /*
         * This is the most difficult part to think about. 
         * If the length of p is larger than one and the char at next position is '*':
         * To prevent '*' from greedy matching all of s's substring need to be considered to match with the 
         * substring of p starting from the position after '*'.
         * */
        else{
        	int i = -1;
        	while(sSt+i <= sLen-1 &&(i < 0 || p.charAt(pSt) == s.charAt(sSt+i)||p.charAt(pSt) == '.')){
        		if (isMatch(s,sSt+i+1,sLen,p,pSt+2,pLen)) return true;
        		i ++;
        	}
        	return false;
        }
    }
}
