package cn.hncu;

import java.util.Scanner;

public class P2094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();//n������ nΪ0����
			if (n == 0) {
				break;
			}
			String[] WinName = new String[n];//Ӯ���˵�����
			String[] LoseName = new String[n];//����˵�����
			for (int i = 0; i < n; i++) {//���и�ֵ
				WinName[i] = sc.next();
				LoseName[i] = sc.next();
			}
			for (int i = 0; i < n; i++) {//��WinName���е�ֵȥLoseName���б�������ҵ��˾ͽ�ʤ�����ж�Ӧ�����ָ�Ϊ������
				for (int j = 0; j < n; j++) {
					if (WinName[i].equals(LoseName[j])) {
						WinName[i] ="";
					}
				}
			}
			//�����洦�����ʤ������Ѱ�һ��ж��ٸ����֡�ͬ����������һ�����������㡣
			
			int count=0;
			for(int i=WinName.length-1;i>=0;i--){
				int countTest = 0;
				if(WinName[i].equals("")){
					continue;
				}
				for(int j=i-1;j>=0;j--){
					if(!WinName[i].equals(WinName[j])){
						countTest++;
					}
				}
				if(countTest==i){
					count++;
				}
				
			}
			
			
			
			
			//���ֻ��һ�����־Ϳ����϶���Ϊ�ھ� �������ƶϹھ���
			if (count == 1) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

}
