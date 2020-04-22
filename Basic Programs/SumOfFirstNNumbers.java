package Lecture1;

public class SumOfFirstNNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int n=5;
      int sum=0;
      int counter=1;
      while(counter<=n) {
    	  sum=sum+counter;
    	  counter++;
      }
      
      System.out.println(sum);
	}

}
