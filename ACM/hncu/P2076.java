package cn.hncu;

import java.util.Scanner;

public class P2076 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0){
			int h=sc.nextInt();
			int m=sc.nextInt();
			int s=sc.nextInt();
			if(h>12){
				h=h-12;
			}
			double ans;
			ans=Math.abs((h*30+0.5*m+0.00833*s)-(m*6+s*0.1));
			if(ans>180){
				ans=360-ans;
				System.out.println((int)ans);
			}else{
				System.out.println((int)ans);
			}
		}
	}

}
