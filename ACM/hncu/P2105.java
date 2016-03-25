package cn.hncu;

import java.util.Scanner;

public class P2105 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			if(n==0){
				break;
			}
			while(n-->0){
				double x,y;
				double x1=sc.nextDouble();
				double y1=sc.nextDouble();
				double x2=sc.nextDouble();
				double y2=sc.nextDouble();
				double x3=sc.nextDouble();
				double y3=sc.nextDouble();
				x=(x1+x2+x3)/3;
				y=(y1+y2+y3)/3;
				System.out.print(String.format("%.1f", x));
				System.out.print(" ");
				System.out.println(String.format("%.1f", y));
			}
			
		}
	}

}
