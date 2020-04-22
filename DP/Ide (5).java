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
		printP(str,"");
	}
	static void printP(String str,String result){
	    if(str.length()==0){
	        System.out.print(result+" ");
	        return;
	    }
	    for(int i=0;i<str.length();i++){
	        char cc=str.charAt(i);
	        String ros=str.substring(0,i)+str.substring(i+1);
	        printP(ros,result+cc);
	    }
	}
}