package cn.hncu;

import java.util.Scanner;

public class P2131 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String letter=sc.next();
			String word=sc.next();
			char[] ch=letter.toCharArray();
			char[] chs=word.toCharArray();
			int sum=0;
			for(int i=0;i<chs.length;i++){
				if(chs[i]==ch[0]||chs[i]==(ch[0]-32)||chs[i]==(ch[0]+32)){
					sum++;
				}
			}
			double s=sum*1.0/chs.length;
			
			System.out.println(String.format("%.5f", s));
		}
	}

}
