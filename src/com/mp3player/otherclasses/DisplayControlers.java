package com.mp3player.otherclasses;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class DisplayControlers extends PlayerMethods {
	/**
	 * listhight is the hight of the JList which the playlist is going to dispaly it append every time we add file to the playlist 
	 */
	private int listhight=23;
	
	
	/**
	 * setListhight sets the hight of the JList while opening new file to reset to the default hight which is 23
	 * @param listhight
	 */
	public void setListhight(int listhight) {
		this.listhight = listhight;
	}

	/**
	 * Update playlist while we click add to playlist it updates the JList dispay so it will append/Increase size every time we add new file and reset it while we open new 
	 * @param myList
	 * @param listPlaylist
	 */
	public void updatePlaylist(DefaultListModel<String> myList,JList<String> listPlaylist){
		myList.addElement(getCurrentFile());
		listhight+=18;
		listPlaylist.setBounds(28, 150, 323, listhight);
		
	}
	/**
	 * update playlist while we click open 
	 * @param myList
	 * @param listPlaylist
	 */
	public void updatePlaylistOnOpen(DefaultListModel<String> myList,JList<String> listPlaylist){
		
		if (getFileName()!="NoFile"){
		myList.removeAllElements();
		myList.addElement(getFileName());
		listPlaylist.setBounds(28, 150, 323, 23);
		listPlaylist.setSelectedIndex(0);
		}
	}
	
	/**
	 * ChangePlaypause changes the name of the btnPlayPause, to play or pause depending on the situation
	 */
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
