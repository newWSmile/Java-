package cn.hncu.io1;
import java.io.IOException;
public class MySystemIn {
	public static void main(String[] args) {
		try {
			byte[] buf=new byte[512];
		    int num=System.in.read(buf);
			for (int i = 0; i < num; i++) {
				System.out.print((char)buf[i]);//windo�л��з���"\r\n",linux����"\n"  �ֽڲ�ǿת�Ļ� 13�ǻس� 10�ǻ���
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
