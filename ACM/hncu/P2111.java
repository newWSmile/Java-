package cn.hncu;

import java.util.Scanner;

public class P2111 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int v=sc.nextInt();
			if(v==0){
				break;
			}
			int n=sc.nextInt();
			int[] pi=new int[n];
			int[] mi=new int[n];
			for(int i=0;i<n;i++){
				pi[i]=sc.nextInt();
				mi[i]=sc.nextInt();
			}
			
			for(int i=0;i<pi.length-1;i++){
				for(int j=i+1;j<pi.length;j++){
					if(pi[i]<pi[j]){
						int temp=pi[i];
						pi[i]=pi[j];
						pi[j]=temp;
						temp=mi[i];
					    mi[i]=mi[j];
					    mi[j]=temp;
					}
				}
			}
			
//			for(int i=0;i<n;i++){
//				System.out.println(pi[i]+" "+mi[i]);
//			}
			int sum = 0;
          
            for(int i=0;i<n;i++){
                for(int j=0;j<mi[i];j++){
                    if(v>0){
                        sum=sum+pi[i];
                        v=v-1;
                    }
                }
            }
            System.out.println(sum);
		}
	}

}
