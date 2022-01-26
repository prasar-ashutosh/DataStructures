package test;

public class IntegerDivision {
	
	public static void main(String[] args) {
		int a = -2147483648;
		int b =	-1;
		int res = divide(a, b);
		System.out.println(res);
		
		
		int aa =  - 2147483648;
		
		System.out.println(-1 * aa);
		
		
		
		
	}
	
	
	
    public static int divide(int dividend, int divisor) {
        boolean negative = (dividend < 0) ^ (divisor < 0);
        
        long divLong = dividend;               
        
        if(dividend < 0) {
            divLong = (long) (-1 * (long)dividend);
        }
        if(divisor < 0) {
            divisor = (-1 * divisor);
        }
                        
        long i = 0;
        while(divLong >= divisor) {
            divLong = divLong - divisor;
            i++;
        }
        
        if(negative){
          return (int)(-1*i);   
        } else {
        return (int) i;
        }
    }

}
