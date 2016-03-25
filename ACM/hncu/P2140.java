package cn.hncu;

import java.util.Scanner;

public class P2140 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String str=sc.nextLine();
			char[] chs=str.toCharArray();
			for(int i=0;i<chs.length;i++){
				if(chs[i]=='b'){
					chs[i]=' ';
					continue;
				}
				if(chs[i]=='q'){
					chs[i]=',';
					continue;
				}
				if(chs[i]=='t'){
					chs[i]='!';
					continue;
				}
				if(chs[i]=='m'){
					chs[i]='l';
					continue;
				}
				if(chs[i]=='i'){
					chs[i]='e';
					continue;
				}
				if(chs[i]=='c'){
					chs[i]='a';
					continue;
				}
				if(chs[i]=='a'){
					chs[i]='c';
					continue;
				}
				if(chs[i]=='e'){
					chs[i]='i';
					continue;
				}
				if(chs[i]=='l'){
					chs[i]='m';
					continue;
				}
			}
			for(int i=0;i<chs.length;i++){
				System.out.print(chs[i]);
			}
			System.out.println();
		}
	}

}
