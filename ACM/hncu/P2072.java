package cn.hncu;
import java.util.Scanner;
public class P2072 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String str=sc.nextLine();
			if(str.equals("#")){//����#���˳�
				return;
			}
			
			int count=0;//������� ֻҪ�������һ����ĸ
			String d=str.replaceAll(" +", ",");
			String[] strCount=d.split(",");//����һ�����߶���ո񻮷�
			int sum=strCount.length;
//			for(int i=strCount.length-1;i>=1;i--){//�����һ����ʼ��ǰ�Ƚ� 
//				int countTest=0;//���Դӵ�I����ǰ�Ƚϲ�ͬ�ĸ����������������I�Ļ��ͱ�ʾ����Ǹ��µ���ĸ��
//				for(int j=i-1;j>=0;j--){//��I����֮ǰ��������ĸ���бȽ�
//					if(!(strCount[i].equalsIgnoreCase(strCount[j]))){
//						countTest++;
//					}
//				}
//				if(countTest==i){//������µ���ĸ�Ͱ�����������count+1��
//					count++;
//				}
//			}
			for(int i=0;i<strCount.length;i++){
				for(int j=i+1;j<strCount.length;j++){
					if(strCount[i].equals(strCount[j])){
						count++;
						break;
					}
				}
			}
			System.out.println(sum-count);//���count��
		}
	}
}
