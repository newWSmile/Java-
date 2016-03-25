package cn.hncu;

import java.util.Scanner;

public class P2109 {
	private static void array(int[] num) {
		for(int i=0;i<num.length-1;i++){
			for(int j=i+1;j<num.length;j++){
				if(num[i]<num[j]){
					int temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			if(n==0){
				break;
			}
			int ac[]=new int[n];
			int[] jp=new int[n];
			for(int i=0;i<n;i++){
				ac[i]=sc.nextInt();
			}
			
			for(int i=0;i<n;i++){
				jp[i]=sc.nextInt();
			}
			
			array(ac);
			array(jp);
			int sumOfac=0;
			int sumOfjp=0;
			for(int i=0;i<n;i++){
				if(ac[i]==jp[i]){
					sumOfac++;
					sumOfjp++;
					continue;
				}
				if(ac[i]>jp[i]){
					sumOfac+=2;
					continue;
				}
				if(ac[i]<jp[i]){
					sumOfjp+=2;
					continue;
				}
			}
			System.out.println(sumOfac+" vs "+sumOfjp);
		}
	}

	

}
