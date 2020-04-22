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
		printSS(str,"");
	}
	static void printP(String str,String result){
	    if(str.length()==0){
	        System.out.print(result+" ");
	        return;
	    }
	    char cc=str.charAt(0);
	    printSS(str.substring(1),result);
	    printSS(str.substring(1),result+cc);
	}
}