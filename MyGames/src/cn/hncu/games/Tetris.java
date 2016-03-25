package cn.hncu.games;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tetris extends JFrame {
	public Tetris(){
		TetrisPanel a=new TetrisPanel();
		this.addKeyListener(a.listener);
		add(a);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(220, 275);
		setLocation(400, 100);
		setTitle("���ֵĸ��˶���˹����");
		setResizable(false);
	}
	class TetrisPanel extends JPanel {//��Jpanel�����滭�������ȶ�
		private int blockType;
		private int turnState;
		private int x;
		private int y;
		private int score;
		private int delay;
		private TimerListener listener=new TimerListener();
		Timer timer;
		//�����ͼ���������������Ϸȥ�ķ��飨��ʾ����ʾ����
		//���λ�� x=0--11  y=0--21
		int map[][]=new int[13][23];
		//�������״ 
		//��һά��ʾ�������״
		//�ڶ�ά��ʾ�������ת����
		//����ά��α����ά����ʾ�������
		int shapes[][][]=new int [][][]{
				//I��
				{{0,0,0,0,  1,1,1,1,  0,0,0,0,  0,0,0,0},
				 {0,1,0,0,  0,1,0,0,  0,1,0,0,  0,1,0,0},
				 {0,0,0,0,  1,1,1,1,  0,0,0,0, 0,0,0,0},
				 {0,1,0,0,  0,1,0,0,  0,1,0,0,  0,1,0,0}
				},
				//S��
				{{0,1,1,0,  1,1,0,0,  0,0,0,0,  0,0,0,0},
				 {0,1,0,0,  0,1,1,0,  0,0,1,0,  0,0,0,0},
				 {0,1,1,0,  1,1,0,0,  0,0,0,0,  0,0,0,0},
				 {0,1,0,0,  0,1,1,0,  0,0,1,0,  0,0,0,0}
				},
				//Z
				{{1,1,0,0,  0,1,1,0,  0,0,0,0,  0,0,0,0},
				 {0,0,1,0,  0,1,1,0,  0,1,0,0,  0,0,0,0},
				 {1,1,0,0,  0,1,1,0,  0,0,0,0,  0,0,0,0},
				 {0,0,1,0,  0,1,1,0,  0,1,0,0,  0,0,0,0}
				},
				//J
				{{0,1,0,0,  0,1,0,0,  1,1,0,0,  0,0,0,0},
				 {1,0,0,0,  1,1,1,0,  0,0,0,0,  0,0,0,0},
				 {1,1,0,0,  1,0,0,0,  1,0,0,0,  0,0,0,0},
				 {1,1,1,0,  0,0,1,0,  0,0,0,0,  0,0,0,0}
				},
				//O
				{{1,1,0,0,  1,1,0,0,  0,0,0,0,  0,0,0,0},
				 {1,1,0,0,  1,1,0,0,  0,0,0,0,  0,0,0,0},
				 {1,1,0,0,  1,1,0,0,  0,0,0,0,  0,0,0,0},
				 {1,1,0,0,  1,1,0,0,  0,0,0,0,  0,0,0,0}
				},
				//L
				{{0,1,0,0,  0,1,0,0,  0,1,1,0,  0,0,0,0},
				 {0,0,0,0,  0,1,1,1,  0,1,0,0,  0,0,0,0},
				 {0,1,1,0,  0,0,1,0,  0,0,1,0,  0,0,0,0},
				 {0,0,0,0,  0,0,1,0,  1,1,1,0,  0,0,0,0}
			    },
			    //T
			    {{0,1,0,0,  1,1,1,0,  0,0,0,0,  0,0,0,0},
				 {0,1,0,0,  1,1,0,0,  0,1,0,0,  0,0,0,0},
				 {1,1,1,0,  0,1,0,0,  0,0,0,0,  0,0,0,0},
				 {0,1,0,0,  0,1,1,0,  0,1,0,0,  0,0,0,0}
			    }
		};
		public TetrisPanel(){
			nextBlock();
			newGame();
		}
		private int crash(int x,int y,int blockType,int turnState){
			for(int a=0;a<4;a++){
				for(int b=0;b<4;b++){
//					System.out.println(blockType+" ** "+turnState+" ** "+(a*4+b)+"map:"+(x+b+1)+"--"+(y+a));
					if((shapes[blockType][turnState][a*4+b] & map[x+b+1][y+a])==1){
						return 0;
					}
				}
			}
			return 1;
		}
		//����һ���µķ���
		public void nextBlock(){
			//blockType turnState�������������
			blockType=(int)(Math.random()*100)%7;
			turnState=(int)(Math.random()*100)%4;
			x=4;
			y=0;
			if(crash(x,y,blockType,turnState)==0){
				timer.stop();
				int option=JOptionPane.showConfirmDialog(this, "Game Over! Again????");
				if(option==JOptionPane.OK_OPTION){
					newGame();
				}else if(option==JOptionPane.NO_OPTION){
					System.exit(0);
				}
			}
		}
		
		public void newGame(){
			for(int i=0;i<12;i++){
				for(int j=0;j<22;j++){
					map[i][j]=0;
					map[0][j]=3;
					map[11][j]=3;
				}
				map[i][21]=3;
			}
			delay=1000;
			timer =new Timer(delay, listener);
			timer.start();
			score=0;
		}
		public void down(){
			if(crash(x,y+1,blockType,turnState)==0){
				add(x,y,blockType,turnState);
				nextBlock();
			}
			y++;
			repaint();
		}
		public void add(int x,int y,int blockType,int turnState){
			for(int a=0;a<4;a++){
				for(int b=0;b<4;b++){
					if(shapes[blockType][turnState][a*4+b]==1){
						map[x+b+1][y+a]=shapes[blockType][turnState][a*4+b];
					}
				}
			}
			tryDeline();
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.blue);//�����еķ���
			for(int j=0;j<16;j++){
				if(shapes[blockType][turnState][j]==1){
					g.fillRect((j%4+x+1)*10, (j/4+y)*10, 10, 10);
				}
			}
			g.setColor(Color.red);
			for(int j=0;j<22;j++){//��ͼ����
				for(int i=0;i<12;i++){
					if(map[i][j]==1){
						g.fillRect(i*10, j*10, 10, 10);
						//����ķֽ���
						g.setColor(Color.green);
						g.drawRect(i*10, j*10, 10, 10);
						g.setColor(Color.red);
					}else if(map[i][j]==3){
						g.drawRect(i*10, j*10, 10, 10);
					}
				}
			}
			//���÷�
			g.setColor(Color.BLUE);
			g.setFont(new Font("aa",Font.BOLD,13));
			g.drawString("��ĵ÷֣�"+score, 130, 30);
			
			//���Ҳ���Ļ
			g.setFont(new Font("б��", Font.ITALIC, 12));
			g.drawString("�ܾ�������Ϸ", 130, 70);
			g.drawString("ע�����ұ���", 130, 90);
			g.drawString("������ƭ�ϵ���", 125, 110);
			g.drawString("�ʶ���Ϸ���ԣ�", 125, 130);
			g.drawString("������Ϸ����", 125, 150);
			g.drawString("������ʱ�䣬", 125, 170);
			g.drawString("���ܽ������", 125, 190);
		}
		
		public void turn(){
			turnState=(  turnState+  crash(x,y,blockType,(turnState+1)%4)  )%4;
			repaint();
		}
		public void left(){
			if(x>=0){
				x-=crash(x-1,y,blockType,turnState);
				repaint();
			}
		}
		public void right(){
			if(x<8){
				x+=crash(x+1,y,blockType,turnState);
				repaint();
			}
		}
		
		public void tryDeline(){
			for(int b=0;b<21;b++){//b���к�
				int c=1;
				for(int a=1;a<12;a++){
					c &= map[a][b];//10���������ķ����� �����Ǳ߽�
				}
				if(c==1){
					for(int d=b;d>0;d--){
						for(int e=1;e<11;e++){
							map[e][d]=map[e][d-1];
						}
					}
					score+=10;
					delay=delay/2;
					timer.setDelay(delay);
					repaint();
				}
			}
			
		}
		
		class TimerListener extends KeyAdapter implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				down();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode=e.getKeyCode();
				switch(keyCode){
				  case KeyEvent.VK_LEFT:
					  left();break;
				  case KeyEvent.VK_RIGHT:
					  right();break;
				  case KeyEvent.VK_DOWN:
					  down();break;
				  case KeyEvent.VK_UP:
					  turn();
				}
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		Tetris te=new Tetris();
		te.setVisible(true);
	}
	
}
