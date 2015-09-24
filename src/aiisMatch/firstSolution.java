package aiisMatch;

public class firstSolution {
	public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        return isMatch(s,0,sLen,p,0,pLen);
    }
    
    public boolean isMatch(String s, int sSt, int sLen, String p, int pSt, int pLen){
        if(pSt>pLen-1){
        	return (sSt > sLen -1);
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
}