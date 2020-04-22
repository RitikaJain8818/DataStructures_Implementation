/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0){
		    int n=scn.nextInt();
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=scn.nextInt();
		    }
		    System.out.println(lisDP(arr,n));
		}
	}
	static int lisDP(int[] arr,int n){
	    int[] strg=new int[n];
	    Arrays.fill(strg,1);
	    for(int i=1;i<n;i++){
	        for(int j=0;j<i;j++){
	            if(arr[i]>arr[j]&&strg[j]+1>strg[i]){
	                strg[i]=strg[j]+1;
	            }
	        }
	    }
	    int max=Integer.MIN_VALUE;
	    for(int i=0;i<n;i++){
	        System.out.print(strg[i]+" ");
	        if(max<strg[i])
	            max=strg[i];
	    }
	    return max;
	}
}