package cn.hncu;
import java.util.Scanner;
public class P2061 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double S = 0,sumC=0,sumS=0;//�������ݣ��ɼ�S��crite�����͡��ɼ���crite�ĸ����˻�֮��
		int C=0;//����crite����
		boolean flag=true;//��־�����S<0�Ϳ��Խ��䶨Ϊfalse����������
		double sum=0;//Ҫ�����GPA
		int N=sc.nextInt();//N����������
		sc.nextLine();
		for(int i=0;i<N;i++){
			int K=sc.nextInt();
			sc.nextLine();
			String[] str=new String[K];//һ��������������ÿ������ÿ�е�����
			for(int j=0;j<K;j++){//K������
				str[j]=sc.nextLine();
				String strNum="";//��Ҫ������
				for(int a=0;a<str[j].length();a++){//��Str�����е�������ȡ�����ŵ�strNum��
					if((str[j].charAt(a)>=48&&str[j].charAt(a)<=57)||(str[j].charAt(a)==' ')){
						strNum+=str[j].charAt(a);
 					}
				}
				String [] strCandS=strNum.split(" ");//���տո񻮷�����
				C=Integer.parseInt(strCandS[1]);//��һ��Ϊcrite����C
				S=(double)Integer.parseInt(strCandS[2]);//�ڶ���Ϊ�ɼ�S
				if(S<60&&S>=0){//����ɼ���С��60�ľͽ�flag��λΪfalse����������
					flag=false;
				}else{//��crite����������  K���е�ÿ�гɼ���crite����˵ĺ͸���sumS
					sumC=C+sumC;
					sumS=(S*C)+sumS;
				}
			}
			sum=sumS/sumC;//��GPA
			if(flag==true){//���falgΪ������GPA���������ݳ�ʼ��
				System.out.println(String.format("%.2f", sum));//������λС�����
				sum=0;
				sumC=0;
				sumS=0;
			}else{//���falgΪ�پ����Sorry �����ݳ�ʼ��
				System.out.println("Sorry!");
				flag=true;
				sum=0;
				sumC=0;
				sumS=0;
			}
			if(i<N-1){//����ʵ��֮�任�� 
				System.out.println();
			}
		}
		
	}

}
