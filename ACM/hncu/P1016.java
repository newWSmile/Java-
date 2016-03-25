package cn.hncu;

import java.util.Scanner;

public class P1016 {
	static int k=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			int[] a=new int[n];//�洢�ֽ���ֵ
			int[] color=new int[n];//���������־ -1��ʾδ������
			int[] parent=new int[n];//��Ÿ��ڵ� -1��ʾnull
			int count=0;//������¼����
			System.out.println("Case "+(++k)+":");
			//����ǰ�ĳ�ʼ��
			for (int i = 0; i <n; i++) {
				a[i]=i+1;
				color[i]=-1;//��Ϊ�����ı��Ϊ-1��
			}
			
			dfs(a,color,parent,0,count);
			System.out.println();
		}
	}

	private static void dfs(int[] a, int[] color, int[] parent, int startNode,int count) {
		count++;
		if (count==a.length && isPrime(a[startNode]+a[0])) {
			parent[count-1]=a[startNode];
			print(parent);
		}
		for (int v = 0; v < a.length; v++) {
			color[startNode]=1;
			if (color[v]==-1 && isPrime(a[startNode]+a[v])) {
				parent[count-1]=a[startNode];
				dfs(a, color, parent, v, count);
				//���˵Ļ�������Ҫ�����ֳ�����֮ǰ�Ļ�ԭ��
				color[v]=-1;//��ԭ���
			}
		}
	}

	private static void print( int[] parent) {
		for (int i = 0; i < parent.length; i++) {
			if (i<parent.length-1) {
				System.out.print(parent[i]+" ");
			}else {
				System.out.println(parent[i]);
			}
		}
		
	}

	private static boolean isPrime(int n) {//�ж��Ƿ�Ϊ��������
		if(n==2){
			return true;
		}
		for(int i=2;i*i<=n;i++){
			if(n%i==0){
				return false;
			}
		}
		
		return true;
	}

}
