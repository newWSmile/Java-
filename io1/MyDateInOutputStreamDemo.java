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
		//�����׽Ӽ���
		//д���ļ�
		try {
			OutputStream out= new FileOutputStream("e:/abc/a/data.txt",true);//ture�Ļ������ں���׷�� û�м�ture�Ļ�Ĭ��Ϊfalse ���ǵ�ԭ����
			DataOutputStream dout=new DataOutputStream(out);
			
			for (int i = 0; i <100; i+=2) {
				dout.writeInt(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		�ļ�д���ʱ���ü��±����Ļ����ԣ���Ϊ���±��������Լ��Ķ�ȡ��ʽ���������Ҫ��ȡ�Ļ�Ҫ�Լ�д��ȡ������
		
		// �ļ���ȡ
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
