
public class mul35 {
	public static void main(String args[]){
		int sum=0;
		for(int number=0;number<1000;number++){
			
			if(number%3 == 0 || number%5 == 0){
				sum+=number;
			}
				
		}
		System.out.println("the sum is "+sum);
		

		
		
	}

}
