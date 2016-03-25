package cn.hncu;

import java.util.Scanner;

public class P2086 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double a0,an;
		double[] c=new double[3005];
		while(sc.hasNext()){
			int n=sc.nextInt();
			sc.nextLine();
			a0=sc.nextDouble();
			sc.nextLine();
			an=sc.nextDouble();
			sc.nextLine();
			for(int i=1;i<=n;i++){
				c[i]=sc.nextDouble();
			}
			double ans,t=0;
			for(int i=1;i<=n;i++){
				t=t+(n-i+1)*c[i];
			}
			ans=a0*(0.5*n)+an/2.0-t;
			ans/=(0.5*(n+1));
			System.out.println(String.format("%.2f", ans));
		}
	}

}
