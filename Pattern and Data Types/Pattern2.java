package Lecture2;

public class Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int n=5;
      int nst=1;
      int row=1;
      while(row<=n) {
    	  int starnum=1;
    	  while(starnum<=nst) {
    		  System.out.print("* ");
    		  starnum++;
    	  }
    	  nst++;
    	  System.out.println();
    	  row++;
      }
	}


}
