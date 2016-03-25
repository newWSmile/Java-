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
	
	//�����Ϸ��Ϣ
	private JLabel timeShowLabel,timeHitLabel,gradeLabel;
	private int timeShow;
	private int timeHit;
	private int grade=1;
	public HitMouse() {
		super("С��vs����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 200, 438, 375);
		setResizable(false);
		//���ñ���
		setBack();
//		this.getContentPane().setLayout(null);
		//����ͼƬ���
		mySetCursor(1);
		this.addMouseListener(this);
		//���������������һ��ʼ�������ص�����������
		ImageIcon imgMouse=new ImageIcon(dir+"dishu.png");
		jlbMouse=new JLabel(imgMouse);
		jlbMouse.setLocation(100, 100);
		jlbMouse.setSize(80, 80);
		jlbMouse.setVisible(false);
		this.getContentPane().add(jlbMouse);
		jlbMouse.addMouseListener(this);
		//������
		timer=new Timer(delay, this);
		oRandom=new Random();
		timer.start();
		
		//��Ϸ��Ϣ
		JPanel panel=new JPanel();
		this.getContentPane().add(panel);
		//��������͸��
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(438,375));//���ô��������ѡ��С
		
		//��Ϸ��Ϣ****���ִ���
		timeShowLabel=new JLabel("0",new ImageIcon(dir+"chuxiancishu.png"),SwingConstants.CENTER);
		timeShowLabel.setFont(new Font("��Բ", Font.BOLD, 20));
		timeShowLabel.setSize(146, 40);
		panel.add(timeShowLabel);
		//��Ϸ��Ϣ****���д���
		timeHitLabel=new JLabel("0",new ImageIcon(dir+"dazhongcishu.png"),SwingConstants.CENTER);
		timeHitLabel.setFont(new Font("��Բ", Font.ITALIC, 20));
		timeHitLabel.setSize(146, 40);
		panel.add(timeHitLabel);
		//��Ϸ��Ϣ****�ȼ�
		gradeLabel=new JLabel(""+grade,new ImageIcon(dir+"dangqiandengji.png"),SwingConstants.CENTER);
		gradeLabel.setFont(new Font("����", Font.BOLD, 20));
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
		//�������ʼ��
		isHit=false;
		ImageIcon imgDiShu=new ImageIcon(dir+"dishu.png");
		jlbMouse.setIcon(imgDiShu);
		jlbMouse.setVisible(true);
		
		//��Ϸ��Ϣ���ݴ���
		timeShow++;
		timeShowLabel.setText(""+timeShow);
		
		//��Ϸ��Ĵ���
		if(timeShow>5){
			timer.stop();//��ͣ��ʱ���ٵ�������
			jlbMouse.setVisible(false);
		    int a=JOptionPane.showConfirmDialog(this, "�����Ƿ���������", "������", JOptionPane.YES_NO_OPTION);
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
			//��Ϸ��Ϣ***���д����Ĵ���
			timeHit++;
			timeHitLabel.setText(""+timeHit);
			Toolkit.getDefaultToolkit().beep();
			//��Ϸ����
			if(timeHit>1){
				delay-=190;
				grade++;
				if(delay<100){
					timer.stop();
					jlbMouse.setVisible(false);
					int a=JOptionPane.showConfirmDialog(this, "��ͨ���ˣ���", "��ϲ��ϲ", JOptionPane.YES_NO_CANCEL_OPTION);
					if(a==JOptionPane.YES_OPTION){
						newGame();
					}else{
						System.exit(0);
					}
				}
				
				timeShow=0;
				
				timeHit=0;
				timeHitLabel.setText(""+timeHit);
				//������ʱ��ͣ��һ��
				timer.stop();
				if(grade>1){
					JOptionPane.showConfirmDialog(this, "��ϲ�����"+grade+"��", "��ϲ�ɺ�", JOptionPane.CLOSED_OPTION);
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
	private void setBack() {//���ñ���
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
