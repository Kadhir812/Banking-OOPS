package Wrapper_classes;

 class wrap {
	public static void main(String[] args) {
		
		
		
	  int a=10;
	  
	  Integer a1= Integer.valueOf(a);   // boxing example
	  
	  System.out.println(a);
	  System.out.println(a1);
 
	  
	  
    int num =a1.intValue();   // unboxing example
    
    System.out.println(num);
	
	}
	
}


