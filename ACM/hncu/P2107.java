package cn.hncu;

import java.util.Scanner;

public class P2107 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			if(n==0){
				break;
			}
			int[] ac=new int[n];
			sc.nextLine();
			for(int i=0;i<n;i++){
				ac[i]=sc.nextInt();
			}
			int max=0;
			for(int i=0;i<n;i++){
				if(ac[i]>max){
					max=ac[i];
				}
			}
			System.out.println(max);
					
		}
	}

}
