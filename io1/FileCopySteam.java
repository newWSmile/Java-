package cn.hncu.io1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopySteam {
	public static void main(String[] args) {
		String dir1="e:/abc/a/";
		String dir2="e:/abc/b/";
		String fileName="a.txt";
		byte buf[]=new byte[512];
		//io流的异常处理的模板
		FileInputStream fin=null;
		FileOutputStream fout=null;
		try {
			 fin=new FileInputStream(dir1+fileName);
			 fout=new FileOutputStream(dir2+fileName);
			do {
				int len=fin.read(buf);
				fout.write(buf,0,len);
			} while (fin.available()>0);//用fin.available()来判断是否还有东西。
			
		} catch(IOException e){
			System.out.println("我输出的io流信息有错!!!");
		}finally{
			try{
				if(fin!=null){
					fin.close();
				}
				if(fout!=null){
					fout.close();
				}
			}catch (Exception e) {
				throw new RuntimeException("关流失败!!");//前后台，给用户看的
				
			}
		}
		
	}

}
