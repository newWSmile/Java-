package cn.hncu;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String str=sc.nextLine();
			if(str.equals("#")){//遇到#就退出
				return;
			}
			int count=0;//无论如何 只要输入就有一个字母
			String[] strCount=str.split("\\s+");//按照一个或者多个空格划分
			for(int i=strCount.length-1;i>=0;i--){//从最后一个开始向前比较 
				int countTest=0;//测试从第I个向前比较不同的个数，如果个数等于I的话就表示这个是个新的字母。
				for(int j=i-1;j>=0;j--){//第I个与之前的所有字母进行比较
					if(!(strCount[i].equalsIgnoreCase(strCount[j]))){
						countTest++;
					}
				}
				if(countTest==i){//如果是新的字母就把用来计数的count+1；
					count++;
				}
			}
			System.out.println(count);//输出count。
		}
	}

}
