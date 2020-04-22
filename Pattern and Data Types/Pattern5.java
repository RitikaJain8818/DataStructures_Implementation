package Lecture2;

public class Pattern5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int n=4;
      int nsp=n-1;
      int incvalues=1;
      int decvalues=0;
      int row=1;
      
      while(row<=n) {
    	  
    	  int col=1;
    	  while(col<=nsp) {
    		  System.out.print("  ");
    		  col++;
    	  }
    	  
    	  col=1;
    	  int value=row;
    	  while(col<=incvalues) {
    		  System.out.print(value+" ");
    		  value++;
    		  col++;
    	  }
    	  
    	  col=1;
    	  value=value-2;
    	  while(col<=decvalues) {
    		  System.out.print(value+" ");
    		  col++;
    		  value--;
    	  }
    	  // Work for next row
    	  nsp--;
    	  incvalues++;
    	  decvalues++;
    	  System.out.println();  	  
    	  
    	  row++;
      }
	}

}
