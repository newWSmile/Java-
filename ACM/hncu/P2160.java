package cn.hncu;

import java.util.Scanner;

public class P2160 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int[] num=new int[21];
		num[1]=1;
		num[2]=2;
		while(t-->0){
			int n=sc.nextInt();
			
			for(int i=3;i<=n;i++){
				num[i]=num[i-1]+num[i-2];
			}
			System.out.println(num[n]);
		}
	}

}
