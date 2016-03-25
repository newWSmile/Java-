package cn.hncu;
import java.util.Scanner;
public class P2061 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double S = 0,sumC=0,sumS=0;//定义数据：成绩S、crite个数和、成绩与crite的个数乘积之和
		int C=0;//定义crite个数
		boolean flag=true;//标志：如果S<0就可以将其定为false方便后面输出
		double sum=0;//要求输出GPA
		int N=sc.nextInt();//N个测试例子
		sc.nextLine();
		for(int i=0;i<N;i++){
			int K=sc.nextInt();
			sc.nextLine();
			String[] str=new String[K];//一个数组用来放置每个例子每行的内容
			for(int j=0;j<K;j++){//K行数据
				str[j]=sc.nextLine();
				String strNum="";//需要的数据
				for(int a=0;a<str[j].length();a++){//将Str数组中的数字提取出来放到strNum中
					if((str[j].charAt(a)>=48&&str[j].charAt(a)<=57)||(str[j].charAt(a)==' ')){
						strNum+=str[j].charAt(a);
 					}
				}
				String [] strCandS=strNum.split(" ");//按照空格划分数字
				C=Integer.parseInt(strCandS[1]);//第一个为crite个数C
				S=(double)Integer.parseInt(strCandS[2]);//第二个为成绩S
				if(S<60&&S>=0){//如果成绩有小于60的就将flag定位为false，不做处理
					flag=false;
				}else{//将crite个数加起来  K行中的每行成绩与crite数相乘的和赋给sumS
					sumC=C+sumC;
					sumS=(S*C)+sumS;
				}
			}
			sum=sumS/sumC;//求GPA
			if(flag==true){//如果falg为真就输出GPA，并将数据初始化
				System.out.println(String.format("%.2f", sum));//保留两位小数输出
				sum=0;
				sumC=0;
				sumS=0;
			}else{//如果falg为假就输出Sorry 将数据初始化
				System.out.println("Sorry!");
				flag=true;
				sum=0;
				sumC=0;
				sumS=0;
			}
			if(i<N-1){//两个实例之间换行 
				System.out.println();
			}
		}
		
	}

}
