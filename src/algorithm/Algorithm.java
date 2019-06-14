package algorithm;

import java.util.Scanner;

public class Algorithm {
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a finite sequence (separated by commas)");
		String n = reader.nextLine(); 
		String[] arr;
		arr = n.split(",");
		reader.close();
		
		while(!allZero(arr)) {
			if(!nonNeg(arr) || !nonIncr(arr) || !bigFirst(arr) 
					|| sub(arr) == null) {
				System.out.println(
					"The sequence is NOT graphic!");
				return;
			}
			arr = sub(arr);
			arr = order(arr);
		}
		System.out.println(toString2(arr));
		System.out.println("The sequence IS graphic!");
}
	
	public static boolean allZero(String[] n) {
			int a[] = toIntArr(n);
			for(int i=0; i<a.length; i++) {
				if(a[i] != 0) {
					return false;
				}
			}
			return true;
	}
	
	public static String toString2(String[] s) {
		String x ="";
		for(int i=0; i<s.length; i++) {
			x += s[i];
		}
		return x;
	}
	
	public static boolean nonNeg(String[] s) {
		for(int i=0; i<s.length; i++) {
			if(Integer.parseInt(s[i]) < 0) {
				return false;
			}
		}
		return true;
	}
	
	public static String[] toString(int a[]) {
		String[] s = new String[a.length];
		for(int i=0; i<a.length; i++) {
			s[i] = Integer.toString(a[i]);
		}
		return s;
	}
	
	public static boolean nonIncr(String[] n) {
		int a[] = toIntArr(n);
		for(int i=0; i<n.length; i++) {
			for(int j=i+1; j<n.length; j++) {
				if(a[i] < a[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean bigFirst(String[] n) {
		if(Integer.parseInt(n[0]) >= n.length) {
			return false;
		}
		return true;
	}
	
	public static String[] sub(String[] n) {
		int s = Integer.parseInt(n[0]);
		String[] n2 = new String[n.length-1];
		int c = 0;
		for(int i=1; i<=s; i++) {
			int x = Integer.parseInt(n[i])-1;
			if(x >= 0) {
				//char c = (char)(x+'0');
				n2[c] = Integer.toString(x);
				c++;
			}else {
				return null;
			}
		}
		if(s+1 < n.length) {
			for(int y=s+1; y<n.length; y++) {
				n2[c] = n[y];
				c++;
			}
		}
		return n2;
	}
	
	public  static  int[]  toIntArr(String[] n) {
		int a[] = new int[n.length];
		for(int x=0; x<n.length; x++) {
			a[x] = Integer.parseInt(n[x]);
		}
		return a;
	}
	
	public static String[] order(String[] n) {
		if(!nonIncr(n)) {
			int[] a = toIntArr(n);
			int temp;
			for(int i=0; i<n.length; i++) {
				for(int j=i+1; j<n.length; j++) {
					if(a[i] < a[j]) {
						temp = a[i];
	                    a[i] = a[j];
	                    a[j] = temp;
					}
				}
			}
			return toString(a);
		}else {
			return n;
		}
	}
}
