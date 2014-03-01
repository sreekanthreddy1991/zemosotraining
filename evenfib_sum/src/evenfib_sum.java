public class evenfib_sum {
public static void main(String args[]) {
	
	long n1=1;
	long n2=2;
	long fib=0;
	long sum=2;
	while( fib<4000000){
		fib=n1+n2;
		if(fib%2==0){
			sum+=fib;
			}
		n1=n2;
		n2=fib;
	}
	System.out.println("the sum is: "+sum);
	
	
	

}
}
