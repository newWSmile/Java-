package cn.hncu;

import java.util.Scanner;

public class P2164 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0){
			int n=sc.nextInt();
			sc.nextLine();
			int sum1=0;
			int sum2=0;
			while(n-->0){
				String str=sc.nextLine();
				String[] strGame=str.split(" ");
				if(strGame[0].equalsIgnoreCase("P")&&strGame[1].equalsIgnoreCase("P")){
					sum1+=1;
					sum2+=1;
				}
				if(strGame[0].equalsIgnoreCase("P")&&strGame[1].equalsIgnoreCase("R")){
					sum1+=2;
					sum2+=0;
				}
				if(strGame[0].equalsIgnoreCase("P")&&strGame[1].equalsIgnoreCase("S")){
					sum1+=0;
					sum2+=2;
				}
				
				
				if(strGame[0].equalsIgnoreCase("R")&&strGame[1].equalsIgnoreCase("P")){
					sum1+=0;
					sum2+=2;
				}
				if(strGame[0].equalsIgnoreCase("R")&&strGame[1].equalsIgnoreCase("R")){
					sum1+=1;
					sum2+=1;
				}
				if(strGame[0].equalsIgnoreCase("R")&&strGame[1].equalsIgnoreCase("S")){
					sum1+=2;
					sum2+=0;
				}
				
				if(strGame[0].equalsIgnoreCase("S")&&strGame[1].equalsIgnoreCase("P")){
					sum1+=2;
					sum2+=0;
				}
				if(strGame[0].equalsIgnoreCase("S")&&strGame[1].equalsIgnoreCase("R")){
					sum1+=0;
					sum2+=2;
				}
				if(strGame[0].equalsIgnoreCase("S")&&strGame[1].equalsIgnoreCase("S")){
					sum1+=1;
					sum2+=1;
				}
				
				
				
				
			}
			if(sum1==sum2){
				System.out.println("TIE");
			}else if(sum1>sum2){
				System.out.println("Player 1");
			}else if(sum1<sum2){
				System.out.println("Player 2");
			}
		}
	}

}
