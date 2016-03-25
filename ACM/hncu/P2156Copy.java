package cn.hncu;

import java.util.Scanner;

public class P2156Copy {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			if(n==0){
				break;
			}
			double sum=0;
			int i;
			sum+=n*1;
			for(i=2;i<=n;i++){
				sum+=1.0/i*(n-i+1)*2;
			}
			System.out.println(String.format("%.2f", sum));
		}
	}

}
