package cn.hncu;

import java.util.Arrays;
import java.util.Scanner;

public class P2083 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		sc.nextLine();
		while(m-->0){
			int n=sc.nextInt();
			sc.nextLine();
			int[] d=new int[n];
			for(int i=0;i<d.length;i++){
				d[i]=sc.nextInt();
			}
			Arrays.sort(d);
			int start=d.length/2;
			int sum=0;
			for(int i=0;i<d.length;i++){
				sum=sum+Math.abs(d[start]-d[i]);
			}
			System.out.println(sum);
		}
	}

}
