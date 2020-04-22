/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0){
		    int p= scn.nextInt();
		    int q=scn.nextInt();
		    String s1=scn.next();
		    String s2=scn.next();
		    System.out.println(editDistDP(s1,s2));
		}
	}
	static int editDistDP(String s1,String s2){
	    int[][] strg=new int[s1.length()+1][s2.length()+1];
	    strg[s1.length()][s2.length()]=1;
	    for(int i=s1.length();i>=0;i--){
	        for(int j=s2.length();j>=0;j--){
	            if(i==s1.length()){
	                strg[i][j]=s2.length()-j;
	                continue;
	            }
	            if(j==s2.length()){
	                strg[i][j]=s1.length()-i;
	                continue;
	            }
	            if(s1.charAt(i)==s2.charAt(j)){
	                strg[i][j]=strg[i+1][j+1];
	            }else{
	                strg[i][j]=1+Math.min(strg[i+1][j+1],Math.min(strg[i+1][j],strg[i][j+1]));
	            }
	        }
	    }
	    return strg[0][0];
	}
}