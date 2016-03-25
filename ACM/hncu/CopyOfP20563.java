package cn.hncu;

import java.util.Scanner;

public class CopyOfP20563 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double x[]=new double[4];
		double y[]=new double[4];
		double a1,b1,a2,b2;
		while(sc.hasNext()){
			for(int i=0;i<4;i++){
				x[i]=sc.nextDouble();
				y[i]=sc.nextDouble();
			}
//			change(x[0], x[1]);
//			change(y[0], y[1]);
//			change(x[2], x[3]);
//			change(y[2], y[3]);
			
			if(x[0]>x[1]){
				double temp;
				temp=x[0];
				x[0]=x[1];
				x[1]=temp;
			}
			if(y[0]>y[1]){
				double temp;
				temp=y[0];
				y[0]=y[1];
				y[1]=temp;
			}
			if(x[2]>x[3]){
				double temp;
				temp=x[2];
				x[2]=x[3];
				x[3]=temp;
			}
			if(y[2]>y[3]){
				double temp;
				temp=y[2];
				y[2]=y[3];
				y[3]=temp;
			}
			
			a1=max(x[0], x[2]);
			b1=max(y[0], y[2]);
			a2=min(x[1], x[3]);
			b2=min(y[1], y[3]);
			
//			double l=min(x[1], x[3])-max(x[0], x[2]);
//			double d=min(y[1], y[3])-max(y[0], y[2]);
			
			double area;
			if(a1>a2||b1>b2){
				area=0;
			}else{
			    area=(a2-a1)*(b2-b1);
			}
			System.out.println(String.format("%.2f", area));
		}
		
	}
	static void change(double x,double y){//·µ»ØµÄÊÇX<Y
	    double t;
		if(x>y){
			t=x;
			x=y;
			y=t;
		}
	}
	static double max(double a,double b){
		return a>b?a:b;
	}
	static double min(double c,double d){
		return c<d?c:d;
	}
	

}
