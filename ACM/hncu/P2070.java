package cn.hncu;

import java.util.Scanner;

public class P2070 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long fn1,fn;
		while(sc.hasNext()){
			int n=sc.nextInt();
			fn=1;
			fn1=0;
			if(n==-1){
				break;
			}
			if(n==0){
				System.out.println(0);
				continue;
			}
			if(n==1){
				System.out.println(1);
				continue;
			}
			
			for(int i=2;i<=n;i++){
				fn=fn+fn1;
				fn1=fn-fn1;
			}
			System.out.println(fn);
		}
	}
}
