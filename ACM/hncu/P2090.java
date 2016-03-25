package cn.hncu;

import java.util.Scanner;

public class P2090 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		while(sc.hasNext()){
			String str = sc.next();
			double num = sc.nextDouble();
			double price = sc.nextDouble();
			sum = sum + (num * price);
		}
		System.out.println(String.format("%.1f", sum));
	}

}
