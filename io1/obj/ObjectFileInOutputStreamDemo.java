package cn.hncu.io1.obj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectFileInOutputStreamDemo {//用这个一次可以写一个对象，而之前的一次只能写一个字节
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
	    //对象用流异常处理的方式去读到文件结束
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
				new Student("楊柳",new MyDate(1989,1,2),"計算機"),
				new Student("張明",new MyDate(1990,2,3),"計算機"),
				new Person("小玲",new MyDate(1988,6,2)),
		};
		try {
			System.out.println(new ObjectFileInOutputStreamDemo("PersonFile.dat",persons).readFormFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



}
