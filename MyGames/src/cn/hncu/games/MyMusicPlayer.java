package cn.hncu.games;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyMusicPlayer extends JFrame {

	private JLabel songNameLabel = null;
	private JButton lastBtn=null;
	private JButton playBtn=null;
	private JButton nextBtn=null;
	private JButton loopBtn=null;
	List songList=null;
	String dir=null;
	String[] songNames={"song1.wav","song2.wav","song3.wav","song4.wav","song5.wav","song6.wav"};
	//音频数组，将歌曲放在数组中以便于后面操作
	AudioClip[] songs;
	AudioClip currentSong=null;//音频
	int index;//控制歌曲的序号
	//播放线程
	Thread playThread;
	
	public MyMusicPlayer() {
		super("我的个人播放器");
		setBounds(300, 50, 310, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
		
        songNameLabel=new JLabel();
		songNameLabel.setFont(new Font("幼圆 ", Font.BOLD, 20));
		songNameLabel.setText("我的简单播放器 ");
		songNameLabel.setBounds(10, 10, 300, 40);
		this.getContentPane().add(songNameLabel);

		//四个播放按钮
		lastBtn=new JButton(new ImageIcon("images2/1.png"));
//		lastBtn.setIcon(new ImageIcon("images2/1.png"));
		playBtn=new JButton(new ImageIcon("images2/5.png"));
//		playBtn.setIcon(new ImageIcon("images2/2.png"));
		nextBtn=new JButton(new ImageIcon("images2/3.png"));
//		nextBtn.setIcon(new ImageIcon("images2/3.png"));
		loopBtn=new JButton(new ImageIcon("images2/4.png"));
//		loopBtn.setIcon(new ImageIcon("images2/4.png"));
		//设置大小
		lastBtn.setBounds(20, 70, 50, 40);
		playBtn.setBounds(80, 70, 50, 40);
		nextBtn.setBounds(140, 70, 50, 40);
		loopBtn.setBounds(200, 70, 50, 40);
		getContentPane().add(lastBtn);
		getContentPane().add(playBtn);
		getContentPane().add(nextBtn);
		getContentPane().add(loopBtn);
		//给按钮加监听
		MouseListenerc mouseListener=new MouseListenerc();
		lastBtn.addMouseListener(mouseListener);
		playBtn.addMouseListener(mouseListener);
		nextBtn.addMouseListener(mouseListener);
		loopBtn.addMouseListener(mouseListener);
		
		//播放列表
		JLabel listLabel=new JLabel("播放列表");
		listLabel.setBounds(10, 120, 100, 30);
		listLabel.setFont(new Font("宋体", Font.BOLD, 15));
		getContentPane().add(listLabel);
		//设置播放列表控制组件
		songList =new List();
		songList.setBounds(10, 150, 250, 300);
		songList.setBackground(Color.green);
		//将歌曲添加到列表
		songs=new AudioClip[songNames.length];
		for(int i=0;i<songNames.length;i++){
			songs[i]=loadSong(songNames[i]);
			songList.add(songNames[i]);
		}
		getContentPane().add(songList);
		
		
		songList.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				currentSong.stop();
				index=songList.getSelectedIndex();
				playThread=new Thread(new MusicRun());
				playThread.start();
			}
		});
		playThread=new Thread(new MusicRun());
		playThread.start();
		this.setVisible(true);
	}
	private boolean isPlay=true;
	private boolean isLoop=false;
	class MouseListenerc extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==lastBtn){
				int len=songNames.length;
				index=(index+len-1)%len;
				isPlay=true;
			}else if(e.getSource()==playBtn){
				isPlay=!isPlay;
			}else if(e.getSource()==nextBtn){
				int len=songNames.length;
				index=(index+1)%len;
				isPlay=true;
			}else if(e.getSource()==loopBtn){
				isLoop=!isLoop;
			}
			
			if(isPlay){//播放
				currentSong.stop();
				playThread=new Thread(new MusicRun());
				playThread.start();
				playBtn.setIcon(new ImageIcon("images2/5.png"));
			}else{//停止
				currentSong.stop();
				songNameLabel.setText("停止播放"+songNames[index]);
				playBtn.setIcon(new ImageIcon("images2/2.png"));
				
			}
			
		}
		
	}
	class MusicRun implements Runnable{

		@Override
		public void run() {
			currentSong=songs[index];
			if(isLoop){
				currentSong.loop();
			}
			songList.select(index);
			currentSong.play();
			songNameLabel.setText("正在播放"+songNames[index]);
		}
		
	}
	private  AudioClip loadSong(String fileName) {
		AudioClip song=null;
		
		try {
			URL url = new URL("file:./songs/"+fileName);
			song=Applet.newAudioClip(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return song;
	}
	
	public static void main(String[] args) {
		new MyMusicPlayer();
		
		
		//演示音乐播放与停止
//		AudioClip
//		try {
//			URL url=new URL("file:"+"./songs/song1.wav");
//			AudioClip asong=Applet.newAudioClip(url);
//			asong.play();
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
