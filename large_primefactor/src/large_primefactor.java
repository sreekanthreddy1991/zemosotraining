import java.math.*;
public class large_primefactor {

	 public static void main(String[] args) {
	        BigInteger n = new BigInteger("600851475143");
	        BigInteger factor = BigInteger.valueOf(2);

	        while (n.compareTo(BigInteger.ONE) == 1) {

	            while (n.remainder(factor) == BigInteger.ZERO) {
	                n = n.divide(factor);
	            }
	            factor = factor.add(BigInteger.ONE);
	        }

	        System.out.print(factor.subtract(BigInteger.ONE));

	    }

}



