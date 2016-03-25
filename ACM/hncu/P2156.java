package cn.hncu;

import java.util.Scanner;

public class P2156 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			if(n==0){
				break;
			}
			double[][] num=new double[n][n];
			
			for(int i=0;i<n;i++){
				if(i>=1){
					int x=1;
					for(int j=i-1;j>=0;j--){
						num[i][j]=1.0/(1+x);
						x++;
					}
				}
				num[i][i]=1;
			}
			for(int j=0;j<n;j++){
				if(j>=1){
					int x=1;
					for(int i=j-1;i>=0;i--){
						num[i][j]=1.0/(1+x);
						x++;
					}
				}
			}
			double sum=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					sum=sum+num[i][j];
				}
			}
			System.out.println(String.format("%.2f", sum));
			
		}
	}
}
