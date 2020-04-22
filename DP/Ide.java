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
		System.out.println(getBP(0,10);
	}
	static ArrayList<String> getBP(int curr,int end){
	    if(curr==end){
	        ArrayList<String> br=new ArrayList<>();
	        br.add("");
	        return br;
	    }
	    if(curr>end){
	        ArrayList<String> br=new ArrayList<>();
	        return br;
	    }
	    ArrayList<String> myResult=new ArrayList<>();
	    for(int dice=1;dice<=6;dice++){
	        ArrayList<String> recResult=getBP(curr+dice,end);
	        for(int i=0;i<recResult.size();i++){
	            myResult.add(dice+recResult.get(i));
	        }
	    }
	    return myResult;
	}
}
