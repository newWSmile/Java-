package cn.hncu;

import java.util.Scanner;

public class P2057 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			long a=sc.nextLong(16);
			long b=sc.nextLong(16);
			String srt=Long.toHexString(a+b);
			if(a+b<0){
				System.out.print("-");
				System.out.println(Long.toHexString(-(a+b)).toUpperCase());
			}else{
				System.out.println(Long.toHexString(a+b).toUpperCase());
			}
		}
	}


}
