package cn.hncu;

import java.math.*;
import java.util.Scanner;
public class P2054 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextBigDecimal()){
			BigDecimal a=sc.nextBigDecimal();
			BigDecimal b=sc.nextBigDecimal();
			if(a.compareTo(b)==0){//����API  BigDecimal ��������С�ڡ����ڻ���� val ʱ������ -1��0 �� 1
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

}
