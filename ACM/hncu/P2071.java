package cn.hncu;
import java.util.Scanner;
public class P2071 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0){
			double max=0;
			int n=sc.nextInt();
			for(int i=0;i<n;i++){
				double a=sc.nextDouble();
				if(a>max){
					max=a;
				}
			}
			System.out.println(String.format("%.2f", max));
		}
	}

}
