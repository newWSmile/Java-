package cn.hncu.Snake;

import java.awt.FlowLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeWin extends JPanel implements ActionListener, KeyListener,
		Runnable {
	JButton newGame, stopGame;
	int score = 0, speed = 5;
	Random r = new Random();
	int rx = 0, ry = 0;
	boolean isStart = false;
	int direction = 0;
	List<SnakeAct> list = new ArrayList<SnakeAct>();
	int tempScore1=0,tempScore2=0;
	Thread newThread ;
	public SnakeWin() {
		newGame = new JButton("开始");
		stopGame = new JButton("结束");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(newGame);
		add(stopGame);
		newGame.addActionListener(this);
		stopGame.addActionListener(this);
		this.addKeyListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(10, 40, 400, 300);
		g.drawString("score: " + score, 150, 20);
		g.drawString("speed: " + speed, 150, 35);
		g.setColor(new Color(0, 255, 0));
		if (isStart) {
			g.fillRect(10 + rx * 10, 40 + ry * 10, 10, 10);
			int color1=0;
			int color2=0;
			int color3=0;
			for (int i = 0; i < list.size(); i++) {
				g.setColor(new Color(color1%255,color2%255,color3%255));
				color1+=30;
				color2+=50;
				color3+=70;
				g.fillRect(10 + list.get(i).getX() * 10, 40 + list.get(i)
						.getY() * 10, 10, 10);
				g.setColor(Color.black);
				g.drawRect(10 + list.get(i).getX() * 10, 40 + list.get(i)
						.getY() * 10, 10, 10);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	private void eat() {
		if (rx == list.get(0).getX() && ry == list.get(0).getY()) {
			rx = r.nextInt(40);
			ry = r.nextInt(30);
			SnakeAct tempAct = new SnakeAct();
			tempAct.setX(list.get(list.size() - 1).getX());
			tempAct.setY(list.get(list.size() - 1).getY());
			list.add(tempAct);
			score=score+10*speed;
			tempScore1+=1;
			if(tempScore1-tempScore2>=2){
				tempScore2=tempScore1;
				if(speed<=9){
					speed+=1;
				}
			}
			
		}
	}

	// 向上方法 注意焦点返还面板
	public void move(int x, int y) {
		if (minYes(x, y)) {
			otherMove();
			list.get(0).setX(list.get(0).getX() + x);
			list.get(0).setY(list.get(0).getY() + y);
			eat();
			repaint();
		}else{//死亡方法
			int a=JOptionPane.showConfirmDialog(this, "你输了!!你的分数是： "+score, "很遗憾", JOptionPane.YES_OPTION);
			if(a==JOptionPane.YES_OPTION){
				newThread=null;
				list.clear();
				score=0;
				speed=5;
				isStart=false;
				newGame.setEnabled(true);
				stopGame.setEnabled(false);
			}else if(a==JOptionPane.NO_OPTION){
				System.exit(0);
			}
		}
	}

	public void otherMove() {
		SnakeAct tempAct = new SnakeAct();
		for (int i = 0; i < list.size(); i++) {
			if (i == 1) {
				list.get(i).setX(list.get(0).getX());
				list.get(i).setY(list.get(0).getY());
			} else if (i > 1) {
				tempAct = list.get(i - 1);
				list.set(i - 1, list.get(i));
				list.set(i, tempAct);
			}
		}
	}

	public boolean minYes(int x, int y) {
		if (!maxYes(list.get(0).getX() + x, list.get(0).getY() + y)) {
			return false;
		}
		return true;
	}

	public boolean maxYes(int x, int y) {
		if (x < 0 || x >= 40 || y < 0 || y >= 30) {
			return false;
		}
		for (int i = 0; i <list.size(); i++) {
			if(i>1&&list.get(0).getX()==list.get(i).getX()&&list.get(0).getY()==list.get(i).getY()){
				return false;
			}
		}
		return true;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (isStart) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				move(0, -1);
				direction = 1;
				break;
			case KeyEvent.VK_DOWN:
				move(0, 1);
				direction = 2;
				break;
			case KeyEvent.VK_LEFT:
				move(-1, 0);
				direction = 3;
				break;
			case KeyEvent.VK_RIGHT:
				move(1, 0);
				direction = 4;
				break;
			default:
				break;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newGame) {
			newGame.setEnabled(false);
			isStart = true;
			rx = r.nextInt(40);
			ry = r.nextInt(30);
			SnakeAct tempAct = new SnakeAct();
			tempAct.setX(20);
			tempAct.setY(15);
			list.add(tempAct);
			this.requestFocus(true);// 把焦点返还给面板
			newThread = new Thread(this);
			newThread.start();
			stopGame.setEnabled(true);
			repaint();
		}
		if (e.getSource() == stopGame) {
			System.exit(0);
		}
	}

	@Override
	public void run() {
		while (isStart) {
			switch (direction) {
			case 1:
				move(0, -1);
				break;
			case 2:
				move(0, 1);
				break;
			case 3:
				move(-1, 0);
				break;
			case 4:
				move(1, 0);
				break;
			default:
				move(1, 0);
				break;
			}
			repaint();
			try {
				Thread.sleep(500-speed*45);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
