package cn.hncu;

import java.util.Scanner;

public class P2123 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c=sc.nextInt();
		while(c-->0){
			int n=sc.nextInt();
			for(int i=0;i<n;i++){
				int num=i+1;
				int x=num;
				boolean isFirst=true;
				for(int j=0;j<n;j++){
					if(isFirst){
						System.out.print((num));
						isFirst=false;
					}else{
						
						num=num+x;
						System.out.print(" "+(num));
					}
				}
				System.out.println();
			}
		}
	}

}
