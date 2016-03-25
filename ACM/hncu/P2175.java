package cn.hncu;

import java.util.Scanner;

public class P2175 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int m=sc.nextInt();
			int n=sc.nextInt();
			if(m==0&&n==0){
				break;
			}
			System.out.println(n%m);
		}
	}

}
