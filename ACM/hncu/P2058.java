package cn.hncu;

import java.util.Scanner;

public class P2058 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			if (N == 0 && M == 0) {
				break;
			}
			int len=(int) Math.sqrt((double)(M)*2.0);
//			Sy	stem.out.println(len);
			while(len>0){
				int a=M/len-(len-1)/2;//m=a*n+(n-1)*n/2;���n�����ô��ʱa1=1,�Ƶ�һ��n*(n+1)=m*2������n���Ϊ
				//sqrt��m*2);
				int b;
				if((a*len+(len-1)*len/2)==M){//���ù�ʽm=a*n+(n-1)*n/2;)�������������a��Ȼ����Ӧ���������[a,a+len-1]
					System.out.println("["+a+","+(a+len-1)+"]");
				}
				len--;
			}
			System.out.println();
		}
	}

}
