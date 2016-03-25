package cn.hncu;

import java.util.Scanner;

public class P2148 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int k=sc.nextInt();
			int[] score=new int[n];
			for(int i=0;i<n;i++){
				score[i]=sc.nextInt();
			}
			int max=score[k-1];
			int num=0;
			for(int i=0;i<n;i++){
				if(score[i]>max){
					num++;
				}
			}
			System.out.println(num);
		}
	}

}
