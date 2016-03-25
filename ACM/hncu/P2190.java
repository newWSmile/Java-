package cn.hncu;

import java.util.Scanner;

public class P2190 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c=sc.nextInt();
		sc.nextLine();
		int[] a=new int[31];
		
		a[1]=1;
		a[2]=3;
		a[3]=5;
		while(c-->0){
			int n=sc.nextInt();
			if(n>=4){
				a[n]=a[n-1]+2*a[n-2];
			}
			System.out.println(a[n]);
		}
	}

}
