package cn.hncu;

import java.util.Scanner;

public class P2101 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int a=sc.nextInt();
			int b=sc.nextInt();
			long sum=a+b;
			if(sum%86==0){
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		}
	}

}
