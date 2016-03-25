package cn.hncu;

import java.util.Scanner;

public class P2055 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int s[]={1,-1,2,-2,3,-3,4,-4,5,-5,6,-6,7,-7,8,-8,9,-9,10,-10,11,-11,12,-12,13,-13,14,-14,15,-15,16,-16,17,-17,18,-18,19,-19,20,-20,21,-21,22,-22,23,-23,24,-24,25,-25,26,-26};
		String[] z={"A","a","B","b","C","c","D","d","E","e","F","f","G","g","H","h","I","i","J","j","K","k","L","l","M","m","N","n","O","o","P","p","Q","q","R","r","S","s","T","t","U","u","V","v","W","w","X","x","Y","y","Z","z"};
		
		while(T-->0){
			String f= sc.next();
			int y=sc.nextInt();
			int fy=0;
			for(int i=0;i<z.length;i++){
				if(f.equals(z[i])){
					fy=i;
				}
			}
			System.out.println(y+s[fy]);
		}
	}

}
