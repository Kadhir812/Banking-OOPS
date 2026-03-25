package Stringbuils;

import java.util.StringTokenizer;

public class strToken {
   public static void main(String[] args) {
		
		
      StringTokenizer st = new StringTokenizer("we,will,play,sports",",");
      
      while(st.hasMoreElements())
      {
    	  System.out.println(st.nextToken());
      }

	}
	

}

