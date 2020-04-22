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
	        int W=scn.nextInt();
	        int[] values=new int[n];
	        int[] weights=new int[n];
	        for(int i=0;i<n;i++){
	            values[i]=scn.nextInt();
	        }
	        for(int i=0;i<n;i++){
	            weights[i]=scn.nextInt();
	        }
	        int[][] strg=new int[n+1][W+1];
	        int V=knapsack(values,weights,n,W,strg);
	        System.out.println(V);
	        int[] sol=knapsackSol(strg,V,values);
	        for(int i=0;i<sol.length;i++){
	            System.out.print(sol[i]+" ");
	        }
	        System.out.println();
	    }
	}
	static int knapsack(int[] values,int[] weights,int n,int W,int[][] strg){
	    for(int i=0;i<=n;i++){
	        for(int j=0;j<=W;j++){
	            if(i==0||j==0){
	                strg[i][j]=0;
	                continue;
	            }
	            if(j-weights[i-1]>=0)
	                strg[i][j]=Math.max(strg[i-1][j],strg[i-1][j-weights[i-1]]+values[i-1]);
                else
                    strg[i][j]=strg[i-1][j];
	        }
	    }
	    return strg[n][W];
	}
	static int[] knapsackSol(int[][] strg,int V,int[] values){
	    int[] arr=new int[strg.length-1];
	    for(int i=strg.length-1;i>=0;i--){
	        if(i>=1){
	            int count=0;
	            for(int j=0;j<strg[i].length;j++){
	                if(strg[i-1][j]==V){
	                    count=1;
	                    break;
	                }
	            }
	            if(count==0){
	                arr[i-1]=1;
	                V=V-values[i-1];
	                continue;
	            }else{
	                arr[i-1]=0;
	                continue;
	            }
	        }
	    }
	    return arr;
	}
}