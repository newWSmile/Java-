package cn.hncu;

import java.util.Scanner;

public class P2113 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean isFirst=true;
		while(sc.hasNext()){
			
			String str=sc.next();
			char chs[]=str.toCharArray();
			int sum=0;
			for(int i=0;i<chs.length;i++){
				int num=chs[i]-48;
				if(num%2==0){
					sum=sum+num;
				}
				
			}
			if(!isFirst){
				System.out.println();
			}
			System.out.println(sum);
			isFirst=false;
		}
	}

}
