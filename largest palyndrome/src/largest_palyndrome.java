
public class largest_palyndrome {

	    public static void main(String[] args) {
	        int left;
	        int right;
	        int palindrome=0;
	        
	        for(left=999;left>99;left--){
	            for(right=999;right>=left;right--){
	                int pro=left*right;
	                
	                if(pro<palindrome){
	                    break;
	                }
	                
	                String prostr = new Integer(pro).toString();
	                String prorev = new StringBuilder(prostr).reverse().toString();
	                if(prostr.equals(prorev)){
	                    palindrome = pro;
	                }
	            }
	        }
	        
	        System.out.println("Largest Palindrome is "+palindrome);
	    }
	    
	}



