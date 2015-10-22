package amZigZagConversion;

public class FirstSolution {
	public String convert(String s, int numRows) {
        if(numRows <=1) return s;
        int rem = s.length()%(2*(numRows-1));
        if(rem>0){
        	String tmp = s;
            for(int i=rem; i<2*(numRows-1); i++){
                tmp += " ";
            }
            s = tmp;
        }
        int numUnits = s.length()/(2*(numRows-1));
        int unitLen = numRows-1;
        String str = new String();
        for(int i=0; i<numRows; i++){
            for(int j = 0; j<numUnits; j++){
                str += s.charAt(i+j*2*(numRows-1));
                if(i>0&&i<numRows-1){
                    str += s.charAt(2*(numRows-1)*(j+1)-i);
                }
                str = str.trim();
            }
            
        }
        return str;
    }
	
	static public void main(String[] args){
		FirstSolution test = new FirstSolution();
		System.out.println(test.convert("PAYPALIGDADSASHIRING",2));
	}
}
