package cn.hncu;

import java.util.Scanner;

public class P2186 {
	static int result(int num) {
		int numofresult=0;
		numofresult=num/10;
		if(num%10!=0){
			numofresult++;
		}
		return numofresult;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		sc.nextLine();
		while (c-->0) {
			int n = sc.nextInt();
			int qiangxian = n / 2;
			int yiliao = (n - qiangxian) * 2 / 3;
			int tongxin = n - qiangxian - yiliao;
			System.out.println(result(qiangxian)+result(yiliao)+result(tongxin));
		}
	}

}
