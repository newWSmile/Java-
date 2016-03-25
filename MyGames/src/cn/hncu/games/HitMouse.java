package cn.hncu.games;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.naming.TimeLimitExceededException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import sun.swing.SwingAccessor;

public class HitMouse extends JFrame implements ActionListener,MouseListener {
	private final String dir="./images/";
	private JLabel jlbMouse;
    Random oRandom;
	private boolean isHit;
	private Timer timer;
	private int delay=1000;
	
	//添加游戏信息
	private JLabel timeShowLabel,timeHitLabel,gradeLabel;
	private int timeShow;
	private int timeHit;
	private int grade=1;
	public HitMouse() {
		super("小妃vs地鼠");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 200, 438, 375);
		setResizable(false);
		//设置背景
		setBack();
//		this.getContentPane().setLayout(null);
		//设置图片光标
		mySetCursor(1);
		this.addMouseListener(this);
		//地鼠出来啦但是我一开始把它隐藏掉啦哈哈哈哈
		ImageIcon imgMouse=new ImageIcon(dir+"dishu.png");
		jlbMouse=new JLabel(imgMouse);
		jlbMouse.setLocation(100, 100);
		jlbMouse.setSize(80, 80);
		jlbMouse.setVisible(false);
		this.getContentPane().add(jlbMouse);
		jlbMouse.addMouseListener(this);
		//监听器
		timer=new Timer(delay, this);
		oRandom=new Random();
		timer.start();
		
		//游戏信息
		JPanel panel=new JPanel();
		this.getContentPane().add(panel);
		//将面板设成透明
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(438,375));//设置此组件的首选大小
		
		//游戏信息****出现次数
		timeShowLabel=new JLabel("0",new ImageIcon(dir+"chuxiancishu.png"),SwingConstants.CENTER);
		timeShowLabel.setFont(new Font("幼圆", Font.BOLD, 20));
		timeShowLabel.setSize(146, 40);
		panel.add(timeShowLabel);
		//游戏信息****打中次数
		timeHitLabel=new JLabel("0",new ImageIcon(dir+"dazhongcishu.png"),SwingConstants.CENTER);
		timeHitLabel.setFont(new Font("幼圆", Font.ITALIC, 20));
		timeHitLabel.setSize(146, 40);
		panel.add(timeHitLabel);
		//游戏信息****等级
		gradeLabel=new JLabel(""+grade,new ImageIcon(dir+"dangqiandengji.png"),SwingConstants.CENTER);
		gradeLabel.setFont(new Font("黑体", Font.BOLD, 20));
		gradeLabel.setSize(146, 40);
		panel.add(gradeLabel);
		
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int run=oRandom.nextInt(9);
		switch(run){
		case 0:
			jlbMouse.setLocation(56,63);break;
		case 1:
			jlbMouse.setLocation(322,204);break;
		case 2:
			jlbMouse.setLocation(185,204);break;
		case 3:
			jlbMouse.setLocation(48,203);break;
		case 4:
			jlbMouse.setLocation(298,133);break;
		case 5:
			jlbMouse.setLocation(162,133);break;
		case 6:
			jlbMouse.setLocation(22,133);break;
		case 7:
			jlbMouse.setLocation(311,63);break;
		case 8:
			jlbMouse.setLocation(186,63);break;
		}
		//给地鼠初始化
		isHit=false;
		ImageIcon imgDiShu=new ImageIcon(dir+"dishu.png");
		jlbMouse.setIcon(imgDiShu);
		jlbMouse.setVisible(true);
		
		//游戏信息数据处理
		timeShow++;
		timeShowLabel.setText(""+timeShow);
		
		//游戏输的处理
		if(timeShow>5){
			timer.stop();//先停定时器再弹出窗口
			jlbMouse.setVisible(false);
		    int a=JOptionPane.showConfirmDialog(this, "大侠是否重新来过", "你输了", JOptionPane.YES_NO_OPTION);
			if(a==JOptionPane.YES_OPTION){
				newGame();
			}
		}
		
	}
	public  void newGame(){
		mySetCursor(1);
		delay=1000;
		timeShow=0;
		timeHit=0;
		grade=1;
		timeShowLabel.setText(""+timeShow);
		timeHitLabel.setText(""+timeHit);
		gradeLabel.setText(""+grade);
		timer.restart();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		mySetCursor(2);
		if(e.getSource()==jlbMouse&&!isHit){
			isHit=true;
			ImageIcon imgIconDaTou=new ImageIcon(dir+"datou.png");
			jlbMouse.setIcon(imgIconDaTou);
			jlbMouse.setVisible(true);
			//游戏信息***打中次数的处理
			timeHit++;
			timeHitLabel.setText(""+timeHit);
			Toolkit.getDefaultToolkit().beep();
			//游戏升级
			if(timeHit>1){
				delay-=190;
				grade++;
				if(delay<100){
					timer.stop();
					jlbMouse.setVisible(false);
					int a=JOptionPane.showConfirmDialog(this, "你通关了！！", "恭喜恭喜", JOptionPane.YES_NO_CANCEL_OPTION);
					if(a==JOptionPane.YES_OPTION){
						newGame();
					}else{
						System.exit(0);
					}
				}
				
				timeShow=0;
				
				timeHit=0;
				timeHitLabel.setText(""+timeHit);
				//升级的时候停顿一下
				timer.stop();
				if(grade>1){
					JOptionPane.showConfirmDialog(this, "恭喜进入第"+grade+"关", "可喜可贺", JOptionPane.CLOSED_OPTION);
				}
				gradeLabel.setText(""+grade);
				timer.restart();
				
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		mySetCursor(1);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	private void mySetCursor(int i) {
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Image img=null;
		if(i==1){
			img=toolkit.createImage(dir+"chui1.png");
			
		}else{
			img=toolkit.createImage(dir+"chui2.png");
		}
		Cursor myCursor=toolkit.createCustomCursor(img, new Point(10,10), "aa");
		this.setCursor(myCursor);
	}
	private void setBack() {//设置背景
		((JPanel)(this.getContentPane())).setOpaque(false);
		Icon bgImage=new ImageIcon(dir+"beijing.jpg");
		JLabel bgLabel=new JLabel(bgImage);
		this.getLayeredPane().add(bgLabel,new Integer(Integer.MIN_VALUE));
		bgLabel.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight());
	}
	
	public static void main(String[] args) {
		new HitMouse();
	}

	
}
