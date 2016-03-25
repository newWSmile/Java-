package cn.hncu;

import java.util.Scanner;

public class P20562 {
	public  static void change(double x11,double y11,double x22,double y22){
		double t;
		if(x11>x22){
			t=x11;
			x11=x22;
			x22=t;
			t=y11;
			y11=y22;
			y22=t;
		}
		if(y11>y22){
			t=y11;
			y11=y22;
			y22=t;
			t=x11;
			x11=x22;
			x22=t;
		}
//		System.out.println(x11+"*"+y11+"*"+x22+"*"+y22);
	}
	
	public static void main(String[] args) {
//	    double x1,x2,y1,y2;
		Scanner sc=new Scanner(System.in);
		double x[]=new double[4];
		double y[]=new double[4];
		while(sc.hasNext()){
			for(int i=0;i<4;i++){
				x[i]=sc.nextDouble();
				y[i]=sc.nextDouble();
			}
			change(x[0],y[0],x[1],y[1]);
			change(x[2],y[2],x[3],y[3]);
			if((x[3]>=x[2]&&x[2]>=x[1]&&x[1]>=x[0])||(y[3]>=y[2]&&y[2]>=y[1]&&y[1]>=y[0])) {
                System.out.println(String.format("%.2f", 0));
            }else if((x[1]>=x[0]&&x[0]>=x[3]&&x[3]>=x[2])||(y[1]>=y[0]&&y[0]>=y[3]&&y[3]>=y[2])) {
                System.out.println(String.format("%.2f", 0));
            }else if(x[3]>=x[1]&&x[1]>=x[2]&&x[2]>=x[0]){
                if(y[0]<=y[2]){
                    System.out.println(String.format("%.2f", (x[1]-x[2])*(y[1]-y[2])));
                }else if(y[0]>=y[2]){
                    System.out.println(String.format("%.2f", (x[1]-x[2])*(y[3]-y[0])));
                }
            }else if(x[1]>=x[3]&&x[3]>=x[0]&&x[0]>=x[2]){
                if(y[0]<=y[2]){
                    System.out.println(String.format("%.2f", (x[3]-x[0])*(y[1]-y[2])));
                }else if(y[0]>=y[2]){
                    System.out.println(String.format("%.2f", (x[3]-x[0])*(y[3]-y[0])));
                }
            }else if(x[3]>=x[1]&&x[1]>=x[0]&&x[0]>=x[2]){
                System.out.println(String.format("%.2f", (x[1]-x[0])*(y[1]-y[0])));
            }else if(x[1]>=x[3]&&x[3]>=x[2]&&x[2]>=x[0]){
                System.out.println(String.format("%.2f", (x[3]-x[2])*(y[3]-y[2])));
            }else {
                System.out.println(String.format("%.2f", 0));
            }
		}
		
		
	}

}
