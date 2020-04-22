package Lecture2;

public class Pattern7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int n=5;
      int nst=n;
      int nsp=0;
      int row=1;
      while(row<=2*n-1) {
    	  int col=1;
    	  while(col<=nsp) {
    		  System.out.print("  ");
    		  col++;
    	  }
    	  
    	 col=1;
    	 while(col<=nst) {
    		 System.out.print("* ");
    		 col++;
    	 }
    	 if(row<n) {
    		 nsp=nsp+2;
        	 nst--; 
    	 }else {
    		 nsp=nsp-2;
        	 nst++; 
    	 }
    	 
    	
    	
    	 System.out.println();
    	 row++;
      }
	}


}
