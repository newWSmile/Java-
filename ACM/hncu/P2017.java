package cn.hncu;

import java.util.Scanner;

public class P2017 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			int m=sc.nextInt();
			if(n==1){
				System.out.println(0);
				continue;
			}
			int temp=10;
			int s = 0;
			while(m-->0){
				s=temp/n;
				temp=temp%n*10;
			}
			System.out.println(s);
			
		}
	}

}
