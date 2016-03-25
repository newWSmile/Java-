package cn.hncu;

import java.util.Scanner;

public class P2096 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int sum=0;
			int a=sc.nextInt();
			int b=sc.nextInt();
			if(a>=100){
				a=a%100;
			}
			if(b>=100){
				b=b%100;
			}
			sum=a+b;
			if(sum>=100){
				sum=sum%100;
			}
			System.out.println(sum);
		}
	}

}
