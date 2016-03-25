package cn.hncu;

import java.util.Scanner;

public class P2163 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=1;
		while(sc.hasNext()){
			String str=sc.nextLine();
			if(str.equalsIgnoreCase("STOP")){
				break;
			}
			char chs[]=str.toCharArray();
			boolean isYes=true;
			for(int i=0;i<chs.length/2;i++){
				if(chs[i]!=chs[chs.length-i-1]){
					isYes=false;
				}
			}
			if(isYes){
				System.out.println("#"+n+": "+"YES");
				n++;
			}else{
				System.out.println("#"+n+": "+"NO");
				n++;
			}
		}
	}

}
