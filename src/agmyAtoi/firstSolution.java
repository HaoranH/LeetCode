package agmyAtoi;
/*
 *  This is the first solution that I come up with after trying to figure out the 
 *  specification in LeetCode.
 *  
 * */
public class firstSolution {
    public int myAtoi(String str) {
        /*
        ""  => 0
        "42" => 42
        " 42" => 42
        "4 2" => 4
        "-42" => -42
        "+42" => 42
        "+-42" => -42
        "-+42" => 0
        " -42" => -42
        "- 42" => 0
        " - 42" => 42
        "abc42" => 0
        "42abc" => 42
        "4abc2" => 4
        "4 2" => 4
        "2147483648" => 2147483647
        "-2147483649" => -2147483648
        */
        int flag = 1;
        int length = str.length();
        long retVal = 0;
        for(int m = 0; m < length; m++){
            char tmp = str.charAt(m);
            if( tmp == ' '){
                continue;
            }else if(tmp == '+'){
                retVal = generator(str,m+1,flag);
                break;
            }else if(tmp == '-'){
                flag = -1;
                retVal = generator(str, m+1,flag);
                break;
            }else if(Character.isDigit(tmp)){
                retVal = generator(str,m,flag);
                break;
            }else return 0;
        }
        return (int)retVal;
        
    }
    
    public long generator(String str, int start,int flag){
        long result = 0;
        for(int n = start; n < str.length(); n++){
            if(Character.isDigit(str.charAt(n))){
                result = result*10 + Character.getNumericValue(str.charAt(n));
                if(result > Integer.MAX_VALUE){
                    return flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
            }else{
                return result*flag;
            }
        }return result*flag;
    }
}
