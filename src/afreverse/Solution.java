package afreverse;

public class Solution {
    public int reverse(int x) {
       int flag = x<0?-1:1;
       x = Math.abs(x);
       long retVal=0;
       long tmp = Long.valueOf(x);
       while(tmp>0){
           retVal = retVal*10 + tmp%10;
           tmp /= 10;
       }
       if(retVal > Integer.MAX_VALUE){
           return 0;
       }else{
    	   return (int)retVal*flag;
       }
    }

//	       int flag = x<0?-1:1;
//	       x = Math.abs(x);
//	       long tmp = Long.valueOf(x);
//	       long remain = 0;
//	       while(tmp > 0){
//	           remain = remain * 10 + tmp %10;
//	           tmp /= 10;
//	       }
//	       // This is the tricky part:
//	       // In java the value after this might overflow for an int type.
//	       // so convert everything into long type and turn it back later.
//	       // However I'm not sure how this would play out in python.
//	       if (remain > Integer.MAX_VALUE){
//	           return 0;
//	       }else{
//	           return (int)remain * flag;
//	       }
//	    }
    
    static public void main(String[] args){
    	int b = Math.abs(-2147483648);
    	System.out.println(b*(-1));
    	Solution test = new Solution();
    	System.out.println(test.reverse(-2147483648));
    }
}