package cn.hncu;

import java.util.Scanner;

public class P2087 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String text=sc.next();
			if(text.equals("#")){
				break;
			}
			String pattern=sc.next();
			char[] ch=text.toCharArray();
			char[] ch2=pattern.toCharArray();
			int k;
			int count=0;
			for(int i=0;i<ch.length;){
				int countCh=0;
				k=i;
				for(int j=0;j<ch2.length;){
					if(!(ch[k]==ch2[j])){
						break;
					}else if(ch[k]==ch2[j]){
						k++;
						j++;
						countCh++;
					}
				}
				if(countCh==ch2.length){
					count++;
					i=i+ch2.length;
				}else{
					i++;
				}
				
			}
			System.out.println(count);
		}
	}
}
