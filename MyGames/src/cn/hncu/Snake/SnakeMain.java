package cn.hncu.Snake;

import javax.swing.JFrame;

public class SnakeMain extends JFrame{
	public SnakeMain() {
		SnakeWin win=new SnakeWin();
		add(win);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ì°³ÔÉß----¾ü½Ö×÷Æ·");
		setSize(435,390);
		setLocation(200, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new SnakeMain();
	}

}
