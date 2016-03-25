package cn.hncu.io1;
import java.io.IOException;
public class MySystemIn {
	public static void main(String[] args) {
		try {
			byte[] buf=new byte[512];
		    int num=System.in.read(buf);
			for (int i = 0; i < num; i++) {
				System.out.print((char)buf[i]);//windo中换行符是"\r\n",linux中是"\n"  字节不强转的话 13是回车 10是换行
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
