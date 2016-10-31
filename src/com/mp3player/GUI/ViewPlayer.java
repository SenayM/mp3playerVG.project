package com.mp3player.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.mp3player.otherclasses.DisplayControlers;
import com.mp3player.otherclasses.PlayerMethods;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class ViewPlayer {

	int colorIndex=1;
	
	DisplayControlers dc=new DisplayControlers();
	PlayerMethods pm=new PlayerMethods();
	
	DefaultListModel<String> myList=new DefaultListModel<String>();
	JList<String> listPlaylist = new JList<String>();
	
	JLabel lblNowplaying = new JLabel("NowPlaying");
	private JFrame frmMyMpPlayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the application.
	 */
	public ViewPlayer() {
		initialize();
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
		
		JButton btnOpen = new JButton("Open Media");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pm.open();
				pm.updateDisplay(lblNowplaying);
				dc.updatePlaylistOnOpen(myList, listPlaylist);
			}
		});
		btnOpen.setBounds(28, 11, 116, 23);
		frmMyMpPlayer.getContentPane().add(btnOpen);
		
		JButton btnPlaypause = new JButton("Play");
		btnPlaypause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pm.play();
				
			}
		});
		btnPlaypause.setBounds(28, 45, 72, 23);
		frmMyMpPlayer.getContentPane().add(btnPlaypause);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.stop();
			}
		});
		btnStop.setBounds(185, 45, 72, 23);
		frmMyMpPlayer.getContentPane().add(btnStop);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PlayerMethods.displayIndex>0){
				pm.previous();
				pm.updateDisplayOnNextPrevious(lblNowplaying);
				listPlaylist.setSelectedIndex(PlayerMethods.displayIndex);
				}
			}
		});
		btnPrevious.setBounds(270, 45, 72, 23);
		frmMyMpPlayer.getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlayerMethods.displayIndex<PlayerMethods.playerIndex){
				pm.next();
				pm.updateDisplayOnNextPrevious(lblNowplaying);
				listPlaylist.setSelectedIndex(PlayerMethods.displayIndex);
				
				//dc.changePlayPause();
				}
			}
		});
		btnNext.setBounds(342, 45, 72, 23);
		frmMyMpPlayer.getContentPane().add(btnNext);
		
		JButton btnChangeSkin = new JButton("Change Skin");
		btnChangeSkin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		btnChangeSkin.setBounds(298, 11, 116, 23);
		frmMyMpPlayer.getContentPane().add(btnChangeSkin);
		
		JLabel lblDisplay = new JLabel("Now Playing :");
		lblDisplay.setForeground(Color.BLUE);
		lblDisplay.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDisplay.setBounds(28, 88, 89, 14);
		frmMyMpPlayer.getContentPane().add(lblDisplay);
		
		
		lblNowplaying.setForeground(Color.BLUE);
		lblNowplaying.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNowplaying.setBounds(122, 88, 292, 14);
		frmMyMpPlayer.getContentPane().add(lblNowplaying);
		
		JLabel lblDisplayPlayList = new JLabel("Play List");
		lblDisplayPlayList.setForeground(Color.BLUE);
		lblDisplayPlayList.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDisplayPlayList.setBounds(28, 125, 89, 14);
		frmMyMpPlayer.getContentPane().add(lblDisplayPlayList);
		
		JButton btnAddtoplaylist = new JButton("Add File To Playlist");
		btnAddtoplaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.addToPlaylist();
				dc.updatePlaylist(myList,listPlaylist);
				
			}
		});
		btnAddtoplaylist.setBounds(267, 122, 147, 23);
		frmMyMpPlayer.getContentPane().add(btnAddtoplaylist);
		
		JButton btnShuffle = new JButton("Shuffle");
		btnShuffle.setBounds(143, 11, 79, 23);
		//frmMyMpPlayer.getContentPane().add(btnShuffle);
		
		JButton btnRepeat = new JButton("Repeat");
		btnRepeat.setBounds(221, 11, 79, 23);
		//frmMyMpPlayer.getContentPane().add(btnRepeat);
		
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.pause();
			}
		});
		btnPause.setBounds(99, 45, 72, 23);
		frmMyMpPlayer.getContentPane().add(btnPause);
		
		
		listPlaylist.setBounds(28, 150, 386, 23);
		frmMyMpPlayer.getContentPane().add(listPlaylist);
		
		listPlaylist.setModel(myList);
	}
}
