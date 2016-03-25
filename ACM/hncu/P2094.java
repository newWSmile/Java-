package cn.hncu;

import java.util.Scanner;

public class P2094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();//n对数据 n为0结束
			if (n == 0) {
				break;
			}
			String[] WinName = new String[n];//赢的人的名字
			String[] LoseName = new String[n];//输的人的名字
			for (int i = 0; i < n; i++) {//进行赋值
				WinName[i] = sc.next();
				LoseName[i] = sc.next();
			}
			for (int i = 0; i < n; i++) {//用WinName组中的值去LoseName组中遍历如果找到了就将胜者组中对应的名字赋为“”。
				for (int j = 0; j < n; j++) {
					if (WinName[i].equals(LoseName[j])) {
						WinName[i] ="";
					}
				}
			}
			//在上面处理过的胜者组中寻找还有多少个名字。同样的名字算一个。“”不算。
			
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
			
			
			
			
			//如果只有一个名字就可以认定他为冠军 否则不能推断冠军。
			if (count == 1) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

}
