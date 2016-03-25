package cn.hncu.io1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IntFile {
	private String fileName;
	public IntFile(String fileName) {
		this.fileName = fileName;
	}
	//������short��Χ�ڵķѲ��������е������뵽�ļ�����
	private void writeToFile() throws IOException {
		FileOutputStream fout=new FileOutputStream(fileName);
		DataOutputStream dout=new DataOutputStream(fout);
		short i=0,j=1;
		do{
			dout.writeInt(i);
			dout.writeInt(j);
			i=(short)(i+j);
			j=(short)(i+j);
		}while(i>0);//ֻҪi<0���������
		dout.close();
		fout.close();
	}
	private void readFormFile() throws IOException {
		FileInputStream fin=new FileInputStream(fileName);
		DataInputStream din=new DataInputStream(fin);
		do{
			int n=din.readInt();
			System.out.print(n+" ");
		}while(din.available()>0);
		System.out.println();
	}
	
	//���쳣�������ļ����� �Ժ��е�û��available��ֻ�����쳣����ȡ�������ݡ�
	private void readFormFile2() throws IOException {
		FileInputStream fin=new FileInputStream(fileName);
		DataInputStream din=new DataInputStream(fin);
		while(true){
			try {
				int n=din.readInt();
				System.out.print(n+" ");
			} catch (EOFException e) {
				break;
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		IntFile afile=null;
		try {
			afile=new IntFile("FibIntFile.dat");
			afile.writeToFile();
//			afile.readFormFile();
			afile.readFormFile2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
