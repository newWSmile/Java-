package cn.hncu.io1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileInOutDemo {
	public static void main(String[] args) {
//		byte[] b={97,98,99,48,49,50};
//		try {
//			FileOutputStream out=new FileOutputStream("e:/abc/hello.txt");
//			try {
//				out.write(b);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		byte[] buf=new byte[512];
		try {
			FileInputStream in=new FileInputStream("e:/abc/hello.txt");
			try {
				int length=in.read(buf);
				for (int i = 0; i < length; i++) {
					System.out.print((char)buf[i]);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
