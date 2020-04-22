package Lecture2;

public class Pattern1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int n=5;
      int nst=n;
      int row=1;
      while(row<=n) {
    	  int starnum=1;
    	  while(starnum<=nst) {
    		  System.out.print("* ");
    		  starnum++;
    	  }
    	  nst=n;
    	  System.out.println();
    	  row++;
      }
	}

}
