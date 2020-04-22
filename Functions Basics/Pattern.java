package Lecture3;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int n=4;
       int decvalues=0;
       int len=2*n-1;
       
       int row=1;
       while(row<=len) {
    	   int samevalues=len-(2*decvalues);
    	   int value=n;
    	   
    	   int col=1;
    	   while(col<=decvalues) {
    		   System.out.print(value+" ");
    		   value--;
    		   col++;
    	   }
    	   
    	   col=1;
    	   while(col<=samevalues) {
    		   System.out.print(value+" ");
    	       col++;
    	   }
    	   col=1;
    	   value=value+1;
    	   while(col<=decvalues) {
    		   System.out.print(value+" ");
    		   value++;
    		   col++;
    	   }
    	   
    	   if(row<n) {
    		   decvalues++;
    	   }else {
    		   decvalues--;
    	   }
    	   System.out.println();
    	   row++;
       }
		
	}

}
