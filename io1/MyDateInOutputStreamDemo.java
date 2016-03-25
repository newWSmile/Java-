package cn.hncu.io1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class MyDateInOutputStreamDemo {
	public static void main(String[] args) {
		//流的套接技术
		//写入文件
		try {
			OutputStream out= new FileOutputStream("e:/abc/a/data.txt",true);//ture的话就是在后面追加 没有加ture的话默认为false 覆盖掉原来的
			DataOutputStream dout=new DataOutputStream(out);
			
			for (int i = 0; i <100; i+=2) {
				dout.writeInt(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		文件写入的时候用记事本开的话不对，因为记事本是用它自己的读取方式，我们如果要读取的话要自己写读取方法。
		
		// 文件读取
		try {
			InputStream in= new FileInputStream("e:/abc/a/data.txt");
			DataInputStream din=new DataInputStream(in);
			while(din.available()>0){
				int n=din.readInt();
				System.out.print(n+" ");
			}
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
