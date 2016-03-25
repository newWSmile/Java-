package cn.hncu.io1.obj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectFileInOutputStreamDemo {//�����һ�ο���дһ�����󣬶�֮ǰ��һ��ֻ��дһ���ֽ�
	private String fileName;
	public ObjectFileInOutputStreamDemo(String fileName, Person[] persons) throws IOException {
		this.fileName=fileName;
		writeToFile(persons);
	}
	private void writeToFile(Person[] persons)throws IOException {
		FileOutputStream fout=new FileOutputStream(fileName);
		ObjectOutputStream objOut=new ObjectOutputStream(fout);
		for (int i = 0; i < persons.length; i++) {
			objOut.writeObject(persons[i]);
		}
		objOut.close();
		fout.close();
	}
	private String readFormFile() throws IOException{
		FileInputStream fin=new FileInputStream(fileName);
		ObjectInputStream objIn=new ObjectInputStream(fin);
	    String str="";
	    //���������쳣����ķ�ʽȥ�����ļ�����
		while(true){
			try {
				str+=objIn.readObject().toString()+"\n";
			} catch (Exception e) {
				break;
			}
		}
		return str;
	}
	public static void main(String[] args) {
		Person[] persons={
				new Student("����",new MyDate(1989,1,2),"Ӌ��C"),
				new Student("����",new MyDate(1990,2,3),"Ӌ��C"),
				new Person("С��",new MyDate(1988,6,2)),
		};
		try {
			System.out.println(new ObjectFileInOutputStreamDemo("PersonFile.dat",persons).readFormFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



}
