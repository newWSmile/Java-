package cn.hncu;

import java.util.Scanner;

public class P2099 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int a=sc.nextInt();
			int b=sc.nextInt();
			if(a==0&&b==0){
				break;
			}
			int k=a%b;
			boolean flag=true;
			for(int i=0;i<100;i++){
				if((k*100+i)%b==0){
					if(i<10){
						if(flag==true){
							System.out.print("0"+i);
							flag=false;
							continue;
						}else{
							System.out.print(" 0"+i);
							continue;
						}
					}
					if(flag==true){
						System.out.print(i);
						flag=false;
					}else{
						System.out.print(" "+i);
					}
				}
			}
			System.out.println();
		}
	}

}
