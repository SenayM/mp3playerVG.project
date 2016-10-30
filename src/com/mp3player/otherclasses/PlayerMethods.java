package com.mp3player.otherclasses;
import jaco.mp3.player.*;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.mp3player.interfaces.PlayerInterface;



public class PlayerMethods implements PlayerInterface {
	
	
	MP3Player player=new MP3Player();
	public static String fileName="Bado Filename ";
	public File file=new File("none");
	
	
	
	public String getFileName(){
		return fileName;
	}
	public void updateDisplay(JLabel lblNowPlaying){
		lblNowPlaying.setText(file.getName());
		}
	@Override
	public void play() {
		if(file.getName()=="none")
			JOptionPane.showMessageDialog(null, "Please choose mp3 file first","Error Message",JOptionPane.ERROR_MESSAGE);
		else
		player.play();
	
	}

	@Override
	public void pause() {
		player.pause();
		
	}

	@Override
	public void stop() {
		player.stop();
		
	}

	@Override
	public void next() {
		player.skipForward();
		
	}

	@Override
	public void previous() {
		player.skipBackward();
		
	}

	@Override
	public void shuffle() {
		player.setShuffle(true);
		
	}

	@Override
	public void repeat() {
		player.setRepeat(true);
		
	}

	@Override
	public void addToPlaylist(File file) {
		player.addToPlayList(file);
		
	}

	
	public void open() {
		JFileChooser fileChooser=new JFileChooser();
			int returnval=fileChooser.showOpenDialog( null);
			if (returnval==JFileChooser.APPROVE_OPTION){
				this.file=fileChooser.getSelectedFile() ;
				player.stop();
				this.player=new MP3Player(file);
				player.play();
				fileName=file.getName();
				
				
			}
			
				
		
	}
	
	

}
