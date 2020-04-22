/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		    String s1="agbg";
		    String s2="acgb";
		    System.out.println(editDistR(s1,s2));
	}
	static int editDistR(String s1,String s2){
	    if(s1.length()==0)
	        return s2.length();
        if(s2.length()==0)
            return s1.length();
        String ros1=s1.substring(1);
        String ros2=s2.substring(1);
        if(s1.charAt(0)==s2.charAt(0))
            return editDistR(ros1,ros2);
        int o1=1+editDistR(ros1,ros2);//replace
        int o2=1+editDistR(s1,ros2);//remove
        int o3=1+editDistR(ros1,s2);//add
        return Math.min(o1,Math.min(o2,o3));
	}
}