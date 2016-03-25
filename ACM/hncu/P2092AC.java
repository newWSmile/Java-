package cn.hncu;

import java.util.Scanner;
/*
 * 解题思路：这个题为一个纯数学问题，可以用最笨的方法联立方程组  x+y=n;x*y=m;只要得到其中任何一个变量有整数解就可以了。
y^2-n*y+m=0; 解这个方程得y=（n±√（n^2-4m））/2;
如果有整数解，那么根号√（n^2-4m）能被根号开方出整数。且（n±√（n^2-4m））能被2整除。
技巧：判断一个数能不能被开方出整数，int x=(int)sqrt(y);
                                  x*x==y;这样就可以判断了
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
