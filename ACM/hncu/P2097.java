package cn.hncu;

import java.util.Scanner;

public class P2097 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			if(n==0){
				break;
			}
			//ͳ��10���Ƹ���λ�õ�ֵ���ܵ�ֵ
			int num=n;
			int qianwei=num/1000;
			int baiwei=(num-qianwei*1000)/100;
			int shiwei=(num-qianwei*1000-baiwei*100)/10;
			int gewei=num%10;
			int sumOfShi=qianwei+baiwei+shiwei+gewei;
			
			//ͳ��12���Ƹ���λ�õ�ֵ���ܵ�ֵ
			int nOfT=n;
			String sOfT="";
			char a='a';
			int b=a;
			int sumofT=0;
			while(nOfT>0){
				int t=nOfT%12;
				sumofT=sumofT+t;
				if(t>=10){
					int c=t-10+b;
					char d=(char)c;
					sOfT=d+sOfT;
				}else{
					sOfT=t+sOfT;
				}
				nOfT=nOfT/12;
			}
			
			//ͳ��16���Ƹ���λ�õ�ֵ���ܵ�ֵ
			int nOfS=n;
			String sOfS="";
			char aa='a';
			int bb=aa;
			int sumofS=0;
			while(nOfS>0){
				int t=nOfS%16;
				sumofS=sumofS+t;
				if(t>=10){
					int c=t-10+b;
					char d=(char)c;
					sOfS=d+sOfS;
				}else{
					sOfS=t+sOfS;
				}
				nOfS=nOfS/16;
			}
			
			if(sumofT==sumOfShi&&sumofS==sumOfShi){
				System.out.println(n+" is a Sky Number.");
			}else{
				System.out.println(n+" is not a Sky Number.");
				
			}
			
			
			
			
			
			
			
		}
	}

	

}
