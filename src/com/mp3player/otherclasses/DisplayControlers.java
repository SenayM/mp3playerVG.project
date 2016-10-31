package com.mp3player.otherclasses;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class DisplayControlers extends PlayerMethods {
	//PlayerMethods pm=new PlayerMethods();
	//ViewPlayer vp=new ViewPlayer();
	private int listhight=23;
	
	
	
	public void setListhight(int listhight) {
		this.listhight = listhight;
	}

	public void updatePlaylist(DefaultListModel<String> myList,JList<String> listPlaylist){
		myList.addElement(getCurrentFile());
		listhight+=18;
		listPlaylist.setBounds(28, 150, 323, listhight);
		
	}
	
	public void updatePlaylistOnOpen(DefaultListModel<String> myList,JList<String> listPlaylist){
		
		if (getFileName()!="NoFile"){
		myList.removeAllElements();
		myList.addElement(getFileName());
		listPlaylist.setBounds(28, 150, 323, 23);
		listPlaylist.setSelectedIndex(0);
		}
	}
	
	
	public void changePlayPause(){
		
		//System.out.println(getFileName());
		/*
		if (playpause.getText()=="Play"){
			if (!pm.isThereFile())
				JOptionPane.showMessageDialog(null, "Please select an MP3 file to play","Error Message",JOptionPane.ERROR_MESSAGE);
			else
			
			pm.pause();
			if(pm.player.isPaused())
				playpause.setText("Pause");}
		else if(playpause.getText()=="Pause")
			{playpause.setText("Play");
			pm.player.play();
			}*/
		
	}
	/*public void updateDisplay(JLabel lblNowPlaying){
		PlayerMethods pm=new PlayerMethods();
		lblNowPlaying.setText(pm.file.getName());
		System.out.println(pm.file.getName());
	}*/

}
