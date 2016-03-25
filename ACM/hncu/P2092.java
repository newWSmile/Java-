package cn.hncu;

import java.util.Scanner;

public class P2092 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			int m=sc.nextInt();
			if(n==0&&m==0){
				break;
			}
			
			boolean s=false;
			for(int i=-10000;i<10001;i++){
				long k=n-i;
				if(k*i==m){
					s=true;
					break;
				}
			}
			if(s==true){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}

}
