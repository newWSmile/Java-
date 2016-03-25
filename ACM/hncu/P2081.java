package cn.hncu;

import java.util.Scanner;

public class P2081 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		while(n-->0){
			String str=sc.nextLine();
			char[] ch=str.toCharArray();
			char[] ch2=new char[6];
			ch2[0]='6';
			for(int i=1;i<ch2.length;i++){
				ch2[i]=ch[i+5];
			}
			for(int i=0;i<ch2.length;i++){
				System.out.print(ch2[i]);
			}
			System.out.println();
		}
	}
}
