package aklongestCommonPrefix;

public class FirstSolution {
	public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len == 0){
            return "";
        }
        else if(len == 1){
            return strs[0];
        }else{
            int pointer = 0;
            if(strs[0].length() == 0){
                return "";
            }
            StringBuilder prex = new StringBuilder(strs[0]);
            for(int i = 1; i < len; i++){
                if(strs[i].length() == 0||prex.length() == 0){
                    return "";
                }
                pointer = Math.min(prex.length(),strs[i].length());
                int tmp = 0;
                while(tmp<pointer&&prex.charAt(tmp)==strs[i].charAt(tmp)){
                    tmp++;
                }
                prex.delete(tmp,prex.length());
            }
            return prex.toString();
        }
    }
}
