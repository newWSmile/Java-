package cn.hncu;

import java.util.Scanner;
/*
 * ����˼·�������Ϊһ������ѧ���⣬��������ķ�������������  x+y=n;x*y=m;ֻҪ�õ������κ�һ��������������Ϳ����ˡ�
y^2-n*y+m=0; ��������̵�y=��n���̣�n^2-4m����/2;
����������⣬��ô���ṣ̌�n^2-4m���ܱ����ſ������������ң�n���̣�n^2-4m�����ܱ�2������
���ɣ��ж�һ�����ܲ��ܱ�������������int x=(int)sqrt(y);
                                  x*x==y;�����Ϳ����ж���
 * */
public class P2092AC {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(sc.hasNext()){
			int n,m;
			flag=true;
			n=sc.nextInt();
			m=sc.nextInt();
			if(n==0&&m==0){
				break;
			}
			int y=n*n-4*m;
			if(y>=0){
				int x=(int)Math.sqrt(y);
				if(x*x==y){
					if((n+x)%2==0&&(n-x)%2==0){
						
					}else{
						flag=false;
					}
				}else{
					flag=false;
				}
			}else{
				flag=false;
			}
			if(flag){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}

}
