package cn.hncu;
import java.util.Scanner;
public class P2075 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0){
			int A=sc.nextInt();
			int B=sc.nextInt();
			if(A%B==0){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

}
