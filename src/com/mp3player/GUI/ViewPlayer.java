package com.mp3player.GUI;
/**
 * 
 /*** @author Senay M.
 *@version 3,0
 */



import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.mp3player.otherclasses.DisplayControlers;
import com.mp3player.otherclasses.PlayerMethods;

import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class ViewPlayer implements ActionListener{

	int colorIndex=1;
	
	DisplayControlers dc=new DisplayControlers();
	PlayerMethods pm=new PlayerMethods();
	
	DefaultListModel<String> myList=new DefaultListModel<String>();
	JList<String> listPlaylist = new JList<String>();
	
	private JLabel lblNowplaying = new JLabel("NowPlaying");
	private JFrame frmMyMpPlayer;
	
	private JButton btnOpen = new JButton("Open Media");
	private JButton btnPlaypause = new JButton("Play");
	private JButton btnStop = new JButton("Stop");
	private JButton btnPrevious = new JButton("Previous");
	private JButton btnNext = new JButton("Next");
	private JButton btnChangeSkin = new JButton("Change Skin");
	private JLabel lblDisplay = new JLabel("Now Playing :");
	private JLabel lblDisplayPlayList = new JLabel("Play List");
	private JButton btnAddtoplaylist = new JButton("Add File To Playlist");
	private JButton btnPause = new JButton("Pause");


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPlayer window = new ViewPlayer();
					window.frmMyMpPlayer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ViewPlayer() {
		initialize();
		addActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyMpPlayer = new JFrame();
		frmMyMpPlayer.getContentPane().setBackground(Color.GRAY);
		frmMyMpPlayer.setBackground(Color.GRAY);
		frmMyMpPlayer.setTitle("My MP3 Player");
		frmMyMpPlayer.setBounds(100, 100, 450, 389);
		frmMyMpPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyMpPlayer.getContentPane().setLayout(null);
		frmMyMpPlayer.setVisible(true);
		
		
		btnOpen.setBounds(28, 11, 116, 23);
		frmMyMpPlayer.getContentPane().add(btnOpen);
		
		
		
		btnPlaypause.setBounds(28, 45, 72, 23);
		frmMyMpPlayer.getContentPane().add(btnPlaypause);
		
		
		
		btnStop.setBounds(185, 45, 72, 23);
		frmMyMpPlayer.getContentPane().add(btnStop);
		
		
		btnPrevious.setBounds(270, 45, 72, 23);
		frmMyMpPlayer.getContentPane().add(btnPrevious);
		
		
		
		btnNext.setBounds(342, 45, 72, 23);
		frmMyMpPlayer.getContentPane().add(btnNext);
		
		
		
		btnChangeSkin.setBounds(298, 11, 116, 23);
		frmMyMpPlayer.getContentPane().add(btnChangeSkin);
		
		
		lblDisplay.setForeground(Color.BLUE);
		lblDisplay.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDisplay.setBounds(28, 88, 89, 14);
		frmMyMpPlayer.getContentPane().add(lblDisplay);
		
		
		lblNowplaying.setForeground(Color.BLUE);
		lblNowplaying.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNowplaying.setBounds(122, 88, 292, 14);
		frmMyMpPlayer.getContentPane().add(lblNowplaying);
		
		
		lblDisplayPlayList.setForeground(Color.BLUE);
		lblDisplayPlayList.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDisplayPlayList.setBounds(28, 125, 89, 14);
		frmMyMpPlayer.getContentPane().add(lblDisplayPlayList);
		
		
		
		btnAddtoplaylist.setBounds(267, 122, 147, 23);
		frmMyMpPlayer.getContentPane().add(btnAddtoplaylist);
		
		
		//btnShuffle.setBounds(143, 11, 79, 23);
		//frmMyMpPlayer.getContentPane().add(btnShuffle);
		
		
		//btnRepeat.setBounds(221, 11, 79, 23);
		//frmMyMpPlayer.getContentPane().add(btnRepeat);
		
		
		
		btnPause.setBounds(99, 45, 72, 23);
		frmMyMpPlayer.getContentPane().add(btnPause);
		
		
		listPlaylist.setBounds(28, 150, 386, 23);
		frmMyMpPlayer.getContentPane().add(listPlaylist);
		
		listPlaylist.setModel(myList);
	}
	public void addActionListeners(){
		btnOpen.addActionListener(this );
		btnPlaypause.addActionListener(this);
		btnStop.addActionListener(this);
		btnPrevious.addActionListener(this);
		btnNext.addActionListener(this); 
		btnChangeSkin.addActionListener(this);
		btnAddtoplaylist.addActionListener(this);
		btnPause.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e){
		//If clicked open
		if (e.getSource()== btnOpen){
			PlayerMethods.displayIndex=0;
			PlayerMethods.playerIndex=0;
			dc.setListhight(23);
			pm.open();
			
			pm.updateDisplay(lblNowplaying);
			dc.updatePlaylistOnOpen(myList, listPlaylist);

		}
	
		//If clicked play
		if (e.getSource()==btnPlaypause){
			pm.play();
		}
		//If clicked Pause
		if (e.getSource()==btnPause) {
			pm.pause();
		}
		//If clicked stop
		if (e.getSource()==btnStop){
			pm.stop();
		}
		//If clicked previous
		if (e.getSource()==btnPrevious){

			if(PlayerMethods.displayIndex>0){
			pm.previous();
			pm.updateDisplayOnNextPrevious(lblNowplaying);
			listPlaylist.setSelectedIndex(PlayerMethods.displayIndex);
			
		}
		}
		//If clicked next
		if (e.getSource()==btnNext){
			if (PlayerMethods.displayIndex<PlayerMethods.playerIndex){
				pm.next();
				pm.updateDisplayOnNextPrevious(lblNowplaying);
				listPlaylist.setSelectedIndex(PlayerMethods.displayIndex);
				
		}
		}
		//If clicked changeSkin
		if (e.getSource()==btnChangeSkin){
			if (colorIndex==0)	{	
				frmMyMpPlayer.getContentPane().setBackground(Color.BLACK);
				colorIndex++;
		}
		else if (colorIndex==1)	{	
			frmMyMpPlayer.getContentPane().setBackground(Color.GREEN);
			colorIndex++;
			}
		else if (colorIndex==2)	{	
			frmMyMpPlayer.getContentPane().setBackground(Color.RED);
			colorIndex++;
			}
		else if (colorIndex==3)	{	
			frmMyMpPlayer.getContentPane().setBackground(Color.GRAY);
			colorIndex=0;
			}
		}
		//If clicked Addtoplaylist
		if (e.getSource()==btnAddtoplaylist){
		//if (dc.getFileName()!="NoFile") checkes if we click add to playlist before adding a single file
			if (dc.getFileName()!="NoFile"){
			pm.addToPlaylist();
			dc.updatePlaylist(myList,listPlaylist);
			}

		}
		
	}
}
