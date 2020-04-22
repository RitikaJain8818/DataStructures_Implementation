/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args)
	{
		String str="abc";
		System.out.println(countMP(0,0,3,3));
		printMP(0,0,3,3,"");
		System.out.println();
		System.out.println(countMPD(0,0,3,3));
		printMPD(0,0,3,3,"");
			System.out.println();
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
	        myResult.add(hrecResult.get(i)+'H');
	    }
	    for(int i=0;i<vrecResult.size();i++){
	        myResult.add(vrecResult.get(i)+'V');
	    }
	    return myResult;
	}
	static void printMP(int cr,int cc,int er,int ec,String result){
	    if(cr==er&&cc==ec){
	        System.out.print(result+" ");
	        return;
	    }
	    if(cr>er||cc>ec){
	        return;
	    }
	    printMP(cr+1,cc,er,ec,result+'V');
	    printMP(cr,cc+1,er,ec,result+'H');
	}
	static int countMP(int cr,int cc,int er,int ec){
	    if(cr==er&&cc==ec){
	        return 1;
	    }
	    if(cr>er||cc>ec){
	        return 0;
	    }
	    int count1=0, count2=0;
	    count1+=countMP(cr+1,cc,er,ec);
	    count2+=countMP(cr,cc+1,er,ec);
	    return count1+count2;
	}
	static void printMPD(int cr,int cc,int er,int ec,String result){
	    if(cr==er&&cc==ec){
	        System.out.print(result+" ");
	        return;
	    }
	    if(cr>er||cc>ec){
	        return;
	    }
	    printMPD(cr+1,cc,er,ec,result+'V');
	    printMPD(cr,cc+1,er,ec,result+'H');
	    printMPD(cr+1,cc+1,er,ec,result+'D');
	}
	static int countMPD(int cr,int cc,int er,int ec){
	    if(cr==er&&cc==ec){
	        return 1;
	    }
	    if(cr>er||cc>ec){
	        return 0;
	    }
	    int count1=0,count2=0,count3=0;
	    count1+=countMPD(cr+1,cc,er,ec);
	    count2+=countMPD(cr,cc+1,er,ec);
	    count3+=countMPD(cr+1,cc+1,er,ec);
	    return count1+count2+count3;
	}
}