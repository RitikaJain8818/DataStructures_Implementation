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
		System.out.println(countBP(0,10));
		getBP(0,10,"");
	}
	static void getBP(int s,int e,String result){
	    if(s==e){
	        System.out.print(result+" ");
	        return;
	    }
	    if(s>e){
	        return;
	    }
	    for(int dice=1;dice<=6;dice++){
	        getBP(s+dice,e,result+dice);
	    }
	}
	static int countBP(int s,int e){
	    if(s==e){
	        return 1;
	    }
	    if(s>e){
	        return 0;
	    }
	    int count=0;
	    for(int dice=1;dice<=6;dice++){
	        count+=countBP(s+dice,e);
	    }
	    return count;
	}
}