package afreverse;

public class Solution {
    public int reverse(int x) {
       int flag = x<0?-1:1;
       x = Math.abs(x);
       long tmp = Long.valueOf(x);
       long remain = 0;
       while(tmp > 0){
           remain = remain * 10 + tmp %10;
           tmp /= 10;
       }
       // This is the tricky part:
       // In java the value after this might overflow for an int type.
       // so convert everything into long type and turn it back later.
       // However I'm not sure how this would play out in python.
       if (remain > Integer.MAX_VALUE){
           return 0;
       }else{
           return (int)remain * flag;
       }
    }
}