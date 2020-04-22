/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args)
	{
		Scanner scn=new Scanner(System.in);
		int curr=0;
		int end=10;
		System.out.println(getMP(0,0,3,3));
	}
	static ArrayList<String> getMP(int cr,int cc,int er,int ec){
	    if(cr==er&&cc==ec){
	        ArrayList<String> br=new ArrayList<>();
	        br.add("");
	        return br;
	    }
	    if(cr>er||cc>ec){
	        ArrayList<String> br=new ArrayList<>();
	        return br;
	    }
	    ArrayList<String> myResult=new ArrayList<>();
	    ArrayList<String> hrecResult=getMP(cr,cc+1,er,ec);
	    ArrayList<String> vrecResult=getMP(cr+1,cc,er,ec);
	    for(int i=0;i<hrecResult.size();i++){
	        myResult.add('H'+hrecResult.get(i));
	    }
	    for(int i=0;i<vrecResult.size();i++){
	        myResult.add('V'+vrecResult.get(i));
	    }
	    return myResult;
	}
}
