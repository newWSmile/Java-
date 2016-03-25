package cn.hncu;

import java.util.Scanner;

public class P2056 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double x[]=new double[4];
		double y[]=new double[4];
		while(sc.hasNext()){
			for(int i=0;i<4;i++){
				x[i]=sc.nextDouble();
				y[i]=sc.nextDouble();
			}
			
			if(x[2]>x[0]&&x[2]>x[1]&&x[3]>x[2]&&y[2]>y[0]&&y[2]>y[1]&&y[3]>y[2]){
//				System.out.println("1");
				System.out.println(0.00);
			}else if(x[2]>x[0]&&x[2]<x[1]&&x[3]>x[1]&&x[3]>x[2]&&
			   y[2]>y[0]&&y[2]<y[1]&&y[3]>y[1]&&y[3]>y[2]){
//				System.out.println("2");
				System.out.println(String.format("%.2f",(x[1]-x[2])*(y[1]-y[2])));
			}else if(x[0]>x[2]&&x[1]>x[0]&&x[3]>x[1]&&
			   y[0]>y[2]&&y[1]>y[0]&&y[3]>y[1]){
//				System.out.println("3-1");
				
				System.out.println(String.format("%.2f",(x[1]-x[0])*(y[1]-y[0])));
			}else if(x[2]>x[0]&&x[3]>x[2]&&x[1]>x[3]&&
			   y[2]>y[0]&&y[3]>y[2]&&y[1]>y[3]){
//				System.out.println("3-2");
				System.out.println(String.format("%.2f",(x[3]-x[2])*(y[3]-y[2])));
			}else if(x[0]>x[2]&&x[3]>x[0]&&x[1]>x[3]&&
			   y[0]>y[2]&&y[3]>y[0]&&y[1]>y[3]){
				
//				System.out.println("4");
				System.out.println(String.format("%.2f",(x[3]-x[0])*(y[3]-y[0])));
			}else if(x[3]>x[2]&&x[0]>x[3]&&x[1]>x[0]&&
			   y[3]>y[2]&&y[0]>y[3]&&y[1]>y[0]){
//				System.out.println("5");
				System.out.println(0.00);
			}
			
		}
		
		
	}

}
